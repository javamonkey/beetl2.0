package org.beetl.core.statement;

import org.beetl.core.exception.TempException;

public class ASTNodeUtil {
	public static  boolean isTrue(Object value,ASTNode node){
		if(value instanceof Boolean){
			return ((Boolean)value).booleanValue();
		}else{
			throw new TempException(node.token.getText());
		}
	}
}
