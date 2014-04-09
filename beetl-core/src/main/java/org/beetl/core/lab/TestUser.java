package org.beetl.core.lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 所有测试类采用的Pojo类
 *
 */
public class TestUser
{
	String name = "default";
	int age = 18;
	Date bir = null;
	double salary = 890.12;
	TestUser lover = null;
	List friends = new ArrayList();
	long speed = 128999;
	String[] contacts = new String[]
	{ "1", "2" };

	public TestUser(String name)
	{
		this.name = name;
		try
		{
			bir = new SimpleDateFormat("yyyy-MM-dd").parse("1978-02-14");
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
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
		return friends;
	}

	public void setFriends(List friends)
	{
		this.friends = friends;
	}

	public long getSpeed()
	{
		return speed;
	}

	public void setSpeed(long speed)
	{
		this.speed = speed;
	}

	public String[] getContacts()
	{
		return contacts;
	}

	public void setContacts(String[] contacts)
	{
		this.contacts = contacts;
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

}
