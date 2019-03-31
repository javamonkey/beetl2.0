package org.beetl.core.lang;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/** 测试javabean
 * @author xiandafu
 *
 */
public class PojoTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		Pojo p = new Pojo();
		Template t = gt.getTemplate("/lang/pojo_template.html");
		t.binding("p",p);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/lang/pojo_expected.html"), str);

	}
	
	
	
}

class Pojo{
	String cName="cName";
	String myName="myName";
	boolean isGood = true;
	boolean girl = true;
	boolean iGood = true;
	
	
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public boolean isGood() {
		return isGood;
	}
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
	public boolean isiGood() {
		return iGood;
	}
	public void setiGood(boolean iGood) {
		this.iGood = iGood;
	}
	public boolean isGirl() {
		return girl;
	}
	public void setGirl(boolean girl) {
		this.girl = girl;
	}
	
	public Object get(Object a){
		return a+"cc";
	}
	
}


