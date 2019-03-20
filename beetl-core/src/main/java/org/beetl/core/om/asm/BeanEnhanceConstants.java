package org.beetl.core.om.asm;

import org.beetl.core.om.AttributeAccess;

/**
 * @author laozhaishaozuo@foxmail.com
 *
 */
final class BeanEnhanceConstants {

	private BeanEnhanceConstants() {

	}

	static final String METHOD_VALUE_OF = "valueOf";

	static final String OBJECT_INTERNAL_NAME = "java/lang/Object";

	static final String METHOD_TO_GENERATE = "value";

	static final String METHOD_SIGNATURE = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";

	static final String CLASS_NAME = AttributeAccess.class.getName();

	static final String SUPER_CLASS_NAME = CLASS_NAME.replace('.', '/');

	static final String GENETRATED_CLASS_SUFFIX = AttributeAccess.class.getSimpleName();

	static final String GET_METHOD_NAME = "get";

	static final String GET_METHOD_DESC = "(Ljava/lang/Object;)Ljava/lang/Object;";

	/**
	 * 表示get(Object,Object)方法
	 */
	static final String GET_METHOD_NAME_DESC = GET_METHOD_NAME + GET_METHOD_DESC;


}
