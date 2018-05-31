package org.beetl.core.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 所有测试类采用的Pojo类
 *
 *
 */
public class TestUser 
{
	String name = "default";
	int age = 18;
	Date bir = null;
	double salary = 890.12;
	public TestUser lover = null;
	List friends = null;
	boolean isOk = false;
	int id = 0;
	byte recycle = 1;
	String price="12";
	

	public static enum ORDER
	{
		OK, CANCEL
	};

	public static int MAX = 1;

	public static ORDER tt = ORDER.OK;


	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getCTitle()
	{
		return 0;
	}
	
	public TestUser(String name)
	{
		this.name = name;
		//		try
		//		{
		//			bir = new SimpleDateFormat("yyyy-MM-dd").parse("1978-02-14");
		//		}
		//		catch (ParseException e)
		//		{
		//			throw new RuntimeException(e.getMessage());
		//		}
	}

	public String getName()
	{
		//		throw new RuntimeException();
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
//		throw new ClassCastException();
				return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Date getBir()
	{
		return bir;
	}

	public void setBir(Date bir)
	{
		this.bir = bir;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public TestUser getLover()
	{
		return lover;
	}

	public void setLover(TestUser lover)
	{
		this.lover = lover;
	}

	public List getFriends()
	{
		return this.friends;
	}

	public void setFriends(List friends)
	{
		this.friends = friends;
	}



	public Object getMap()
	{
		return new HashMap();
	}

	public static TestUser getTestUser()
	{
		TestUser joelli = new TestUser("joelli");
		TestUser lucy = new TestUser("lucy");
		joelli.setLover(lucy);
		List friends = new ArrayList();
		friends.add(lucy);
		TestUser lyy = new TestUser("lyy");
		friends.add(lyy);
		joelli.setAge(36);
		joelli.setSalary(10000.01);
		return joelli;

	}

	public int printUsers1(String... strings)
	{
		return strings.length;
	}

	public int printUsers(String str)
	{
		return 0;
	}

	public byte getRecycle()
	{
		return recycle;
	}

	public void setRecycle(byte recycle)
	{
		this.recycle = recycle;
	}

	public static List<TestUser> getTestUsers()
	{
		TestUser joelli = new TestUser("joelli");
		joelli.setAge(36);
		joelli.setSalary(10000.01);
		TestUser lucy = new TestUser("lucy");
		lucy.setAge(35);
		lucy.setSalary(6000.5);

		TestUser lyy = new TestUser("lyy");
		lyy.setAge(37);
		lyy.setSalary(12000.01);

		List all = new ArrayList();

		all.add(joelli);
		all.add(lucy);
		all.add(lyy);

		return all;

	}


	
	public static Info getInfo(){
		return new InfoImpl();
	}
	
	public static interface  Info{
		public String getMsg();
	}
	
	private static class InfoImpl implements Info{

		@Override
		public String getMsg() {
			// TODO Auto-generated method stub
			return "aa";
		}
		
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
