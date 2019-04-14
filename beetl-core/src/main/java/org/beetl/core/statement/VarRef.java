/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.om.AttributeAccess;
import org.beetl.core.om.AABuilder;

/**
 * user.name
 * @author joelli
 *
 */
public class VarRef extends Expression implements IVarIndex {

	public VarAttribute[] attributes;
	public Expression safe;
	public int varIndex;
	public boolean hasSafe;
	private GrammarToken firstToken = null;

	public VarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token) {
		this(attributes, hasSafe, safe, token, token);

	}

	public VarRef(VarAttribute[] attributes, boolean hasSafe, Expression safe, GrammarToken token,
			GrammarToken firstToken) {
		super(token);

		this.attributes = attributes;
		this.safe = safe;
		this.hasSafe = hasSafe;
		this.firstToken = firstToken;

	}

	@Override
	public Object evaluate(Context ctx) {

		Result ret = this.getValue(ctx);
		if (ret.safe) {
			return ret.value;
		}

		Object value = ret.value;

		// 属性
		if (attributes.length == 0) {
			return value;
		}

		for (int i = 0; i < attributes.length; i++) {

			VarAttribute attr = attributes[i];
			if (value == null) {
				if (hasSafe) {
					return safe == null ? null : safe.evaluate(ctx);
				} else {
					BeetlException be = new BeetlException(BeetlException.NULL, "空指针");
					if (i == 0) {
						be.pushToken(this.firstToken);
					} else {
						be.pushToken(attributes[i - 1].token);
					}

					throw be;
				}

			}

			try {
				value = attr.evaluate(ctx, value);
			} catch (BeetlException ex) {
				ex.pushToken(attr.token);
				throw ex;

			} catch (RuntimeException ex) {
				BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问出错", ex);
				be.pushToken(attr.token);
				throw be;
			}

		}

		if (value == null && hasSafe) {
			return safe == null ? null : safe.evaluate(ctx);
		} else {
			return value;
		}

	}

	class Result {
		Object value;
		boolean safe = false;

		public Result(Object value, boolean safe) {
			this.value = value;
			this.safe = safe;
		}

		public Result(Object value) {
			this(value, false);
		}

	}

	private Result getValue(Context ctx) {

		Object value = ctx.vars[varIndex];
		if (value == Context.NOT_EXIST_OBJECT) {

			if (ctx.globalVar != null && ctx.globalVar.containsKey("_root")) {
				// 如果有一个根对象
				Object root = ctx.getGlobal("_root");
				String attr = firstToken.text;
				if (root == null) {
					if (hasSafe) {
						return new Result(safe == null ? null : safe.evaluate(ctx), true);
					} else {
						BeetlException be = new BeetlException(BeetlException.NULL,
								"_root为空指针，无" + this.firstToken.text + "值");
						be.pushToken(this.firstToken);
						throw be;
					}

				}
				
				AttributeAccess aa = AABuilder.buildFiledAccessor(root.getClass());
				try {
					value = aa.value(root, attr);
				}catch(RuntimeException e) {
					BeetlException ex = new BeetlException(BeetlException.ATTRIBUTE_INVALID,
							"_root " + root.getClass() + " 属性访问错误");
					ex.pushToken(this.firstToken);
					throw ex;
				}
				
				ctx.vars[varIndex] = value;

			} else if (hasSafe) {
				return new Result(safe == null ? null : safe.evaluate(ctx), true);
			} else {
				BeetlException ex = new BeetlException(BeetlException.VAR_NOT_DEFINED);
				ex.pushToken(this.firstToken);
				throw ex;
			}
		} else if (value == null && hasSafe) {
			return new Result(safe == null ? null : safe.evaluate(ctx), true);
		}

		return new Result(value);
	}

//	private boolean hasAttr(Object o, String attr) {
//
//		if (o instanceof Map) {
//			return true;
//		} else if (o instanceof List) {
//			return false;
//
//		} else {
//			Class c = o.getClass();
//			MethodInvoker invoker = ObjectUtil.getInvokder(c, (String) attr);
//			if (invoker != null) {
//				return true;
//			} else {
//				return false;
//			}
//
//		}
//	}

	/** 计算所有表达式，知道最后一值，用于a.b[xx].c = 1  赋值，只计算到a.b[xx]
	 * @param ctx
	 * @return
	 */
	public Object evaluateUntilLast(Context ctx) {

		if (attributes.length == 0) {
			// 不可能发生，除非beetl写错了，先放在着
			throw new RuntimeException();
		}
		Result ret = this.getValue(ctx);
		Object value = ret.value;
		if (value == null) {
			BeetlException ex = new BeetlException(BeetlException.NULL);
			ex.pushToken(this.firstToken);
			throw ex;
		}


		for (int i = 0; i < attributes.length - 1; i++) {

			VarAttribute attr = attributes[i];
			if (value == null) {

				BeetlException be = new BeetlException(BeetlException.NULL, "空指针");
				if (i == 0) {
					be.pushToken(this.firstToken);
				} else {
					be.pushToken(attributes[i - 1].token);
				}

				throw be;

			}

			try {
				value = attr.evaluate(ctx, value);
			} catch (BeetlException ex) {
				ex.pushToken(attr.token);
				throw ex;

			} catch (RuntimeException ex) {
				BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问出错", ex);
				be.pushToken(attr.token);
				throw be;
			}

		}

		return value;
	}

	@Override
	public void setVarIndex(int index) {
		this.varIndex = index;

	}

	@Override
	public int getVarIndex() {
		return this.varIndex;
	}


}
