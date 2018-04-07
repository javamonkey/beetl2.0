package org.beetl.core.va;

import java.util.List;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Context;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.beetl.core.VirtualAttributeEval;
import org.beetl.core.VirtualClassAttribute;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VirtualAttributeTest extends BasicTestCase {

	@Test
	public void testVirtualAttribute() throws Exception {

		gt.registerVirtualAttributeEval(new VirtualAttributeEval() {

			@Override
			public Object eval(Object o, String attributeName, Context ctx) {
				// TODO Auto-generated method stub
				return attributeName;
			}

			@Override
			public boolean isSupport(Class c, String attributeName) {
				if (attributeName.equals("hello"))
					return true;
				else
					return false;
			}

		});

		List list = User.getTestUsers();
		Template t = gt.getTemplate("/va/va_virtual_template.html");
		this.bind(t, "list", list, "user", new Object());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_virtual_expected.html"), str);

		t = gt.getTemplate("/va/va_virtual_template.html");
		this.bind(t, "list", list, "user", new Object());
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_virtual_expected.html"), str);

	}

	@Test
	public void testVirtualClasAttribute() throws Exception {

		gt.registerVirtualAttributeClass(User.class, new VirtualClassAttribute() {

			@Override
			public String eval(Object o, String attributeName, Context ctx) {
				User user = (User) o;
				if (user.getAge() < 10) {
					return "young";
				} else {
					return "old";
				}

			}

		});

		List list = User.getTestUsers();
		User user = User.getTestUser();
		Template t = gt.getTemplate("/va/class_virtual_template.html");
		this.bind(t, "list", list, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/class_virtual_expected.html"), str);

		t = gt.getTemplate("/va/class_virtual_template.html");
		this.bind(t, "list", list, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/class_virtual_expected.html"), str);

	}

	@Test
	public void testJacksonVirtualAttribute() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"name\":\"lijz\",\"id\":10}";
		JsonNode node = mapper.readTree(json);

		gt.registerVirtualAttributeEval(new VirtualAttributeEval() {

			@Override
			public Object eval(Object o, String attributeName, Context ctx) {
				JsonNode node = (JsonNode) o;
				return node.get(attributeName);
			}

			@Override
			public boolean isSupport(Class c, String attributeName) {
				if (JsonNode.class.isAssignableFrom(c))
					return true;
				else
					return false;
			}

		});

		// String str = "${json.name}"; jaskson 支持get方法，因此不用虚拟属性也能访问
		String str = "${json.~name}";
		Template template = gt.getTemplate(str, new StringTemplateResourceLoader());
		template.binding("json", node);
		String ret = template.render();
		AssertJUnit.assertEquals("\"lijz\"", ret);
	}

	@Test
	public void testFastjosnVirtualAttribute() throws Exception {

		String json = "{\"name\":\"lijz\",\"id\":10}";
		JSONObject node = (JSONObject) JSON.parse(json);

		gt.registerVirtualAttributeEval(new VirtualAttributeEval() {

			@Override
			public Object eval(Object o, String attributeName, Context ctx) {
				return ((JSONObject) o).get(attributeName);
			}

			@Override
			public boolean isSupport(Class c, String attributeName) {
				if (c == JSONObject.class || c == JSONArray.class) {
					return true;
				} else {
					return false;
				}
			}

		});

		String str = "${json.~name}";
		Template template = gt.getTemplate(str, new StringTemplateResourceLoader());
		template.binding("json", node);
		String ret = template.render();
		AssertJUnit.assertEquals("lijz", ret);
	}
}
