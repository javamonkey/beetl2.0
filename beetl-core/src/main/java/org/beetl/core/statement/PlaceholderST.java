package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;

/**
 * ${exp,format=""}
 * @author joelli
 *
 */
public final class PlaceholderST extends Statement {

	public Expression expression;
	
	protected FormatExpression format;
	// 用户定义输出
	public static Output output = null;

	public PlaceholderST(Expression exp, FormatExpression format, GrammarToken token) {
		super(token);
		this.format = format;
		this.expression = exp;

	}

	@Override
	public final void execute(Context ctx) {
		Object value = expression.evaluate(ctx);
		try {
			if (format != null) {
				value = format.evaluateValue(value, ctx);
			}
			if (output != null) {
				output.write(ctx, value);
				return;
			}
			if (value != null) {
				if (value.getClass() == String.class) {
					ctx.byteWriter.writeString((String) value);
					return;
				} else {
					if (value instanceof Number) {
						Class c = value.getClass();
						if (c == Integer.class) {
							ctx.byteWriter.writeInteger((Integer) value);
							return;
						} else if (c == Long.class) {
							ctx.byteWriter.writeLong((Long) value);
							return;
						} else if (c == Double.class) {
							ctx.byteWriter.writeDouble((Double) value);
							return;
						} else if (c == Float.class) {
							ctx.byteWriter.writeFloat((Float) value);
							return;
						} else if (c == Short.class) {
							ctx.byteWriter.writeShort((Short) value);
							return;
						}
					}

				}
				ctx.byteWriter.writeString(value.toString());
			}
			// ctx.byteWriter.writeObject(value);
		} catch (IOException e) {
			BeetlException be = new BeetlException(BeetlException.CLIENT_IO_ERROR_ERROR, e.getMessage(), e);
			be.pushToken(this.token);
			throw be;
		}

	}


	public static interface Output {
		public void write(Context ctx, Object value) throws IOException;
	}

	public FormatExpression getFormat() {
		return format;
	}


}
