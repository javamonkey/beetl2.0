package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.exception.TempException;

public class StaticTextASTNode extends Statement {

	int textIndex;

	public StaticTextASTNode(int textIndex, Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx) {
		try {
			if (ctx.byteOutputMode) {
				ctx.byteWriter.write((byte[]) ctx.staticTextArray[textIndex]);
			} else {
				ctx.byteWriter.write((char[]) ctx.staticTextArray[textIndex]);
			}
		} catch (IOException ex) {
			throw new TempException(ex.getMessage());
		}

	}

	@Override
	public void infer(Type[] types, Object temp) {
		// do nothing
	}

}
