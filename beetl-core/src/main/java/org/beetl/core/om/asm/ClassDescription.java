package org.beetl.core.om.asm;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.objectweb.asm.tree.FieldNode;

/**
 * asm生成的类描述
 * @author laozhaishaozuo@foxmail.com
 *
 */
class ClassDescription {

	Map<Integer, List<FieldNode>> fieldMap;

	Set<String> methodNameDescSet;

	Map<Integer, List<PropertyDescriptor>> propertyMap;

}
