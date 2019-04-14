package org.beetl.core.om.asm;


import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.beetl.core.BasicTestCase;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class ASMBeanFactoryByPropTest extends BasicTestCase {

	private static final String CLASS_NAME = User.class.getName();

	@Test
	public void testGetter() throws Exception {

		User user = new User();
		user.setName("shaozuo");
		user.setAddress("北京");
		user.setNumbers(15);
		user.setBirthDate(new Date());
		user.setAge((short) 12);
		user.setDistance(44L);
		user.setFlag((byte) 1);
		user.setIsManager(false);
		user.setHeight(1.73F);
		user.setGender('M');
//		user.setAAa(12);
//		user.setABB(13);

		ClassDescription classDescription = BeanEnhanceUtils.getClassDescription(CLASS_NAME);
		for (List<PropertyDescriptor> propDescs : classDescription.propertyMap.values()) {
			for (PropertyDescriptor propDesc : propDescs) {
				System.out.println(propDesc.getName() + ":" + ASMBeanFactory.value(user, propDesc.getName()));
//				AssertJUnit.assertEquals(getValue(user, propDesc), ASMBeanFactory.value(user, propDesc.getName()));
			}
		}
		AssertJUnit.assertEquals("哈哈是", ASMBeanFactory.value(user, "填写"));
		AssertJUnit.assertEquals("哈哈是", ASMBeanFactory.value(user, "写"));
		AssertJUnit.assertEquals("哈哈是", ASMBeanFactory.value(user, "填"));
	}


	private static Object getValue(User user, PropertyDescriptor propDesc)
			throws InvocationTargetException, IllegalAccessException, IllegalArgumentException {
		return propDesc.getReadMethod().invoke(user);
	}

}
