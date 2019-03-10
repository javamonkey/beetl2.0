package org.beetl.core.statement;

import java.util.LinkedHashMap;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.tag.HTMLTagVarBindingWrapper;
import org.beetl.core.tag.Tag;

public class TagVarBindingStatement extends TagStatement {
	VarDefineNode[] varIndexs;

	public TagVarBindingStatement(String tagName, Expression[] paras, Statement block, VarDefineNode[] varDefine,
			GrammarToken token) {
		super(tagName, paras, block, token);
		this.varIndexs = varDefine;
	}

	@Override
	protected void runTag(Tag tag, Context ctx) {
		try {
			if (!(tag instanceof HTMLTagVarBindingWrapper)) {
				
				BeetlException be = new BeetlException(BeetlException.ERROR, "tag必须是HTMLTagVarBindingWrapper");
				be.pushToken(this.token);
				throw be;
			} 
			
			HTMLTagVarBindingWrapper htmlTag = (HTMLTagVarBindingWrapper) tag;
			
			LinkedHashMap<String, Integer> indexMap = new LinkedHashMap<String, Integer>(this.varIndexs.length);
			for (VarDefineNode node : this.varIndexs) {
				indexMap.put(node.token.text, node.varIndex);
			}
			htmlTag.mapName2Index(indexMap);
			tag.render();
			tag.afterRender();
		} catch (BeetlException ex) {
			// BeetlException异常时不要设置token，因为抛出的地方已经设置了
			throw ex;
		} catch (RuntimeException ex) {
			BeetlException be = new BeetlException(BeetlException.ERROR, "tag执行抛错", ex);
			be.pushToken(token);
			throw be;
		}
	}


}
