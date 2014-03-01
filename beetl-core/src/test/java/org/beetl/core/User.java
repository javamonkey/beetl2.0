package org.beetl.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 所有测试类采用的Pojo类
 *
 */
public class User
{
	String name = "default";
	int age = 18;
	Date bir = null;
	double salary = 890.12;
	User lover = null;
	List friends = new ArrayList();

	public User(String name)
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

	public User getLover()
	{
		return lover;
	}

	public void setLover(User lover)
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

	public static User getTestUser()
	{
		User joelli = new User("joelli");
		User lucy = new User("lucy");
		joelli.setLover(lucy);
		List friends = new ArrayList();
		friends.add(lucy);
		User lyy = new User("lyy");
		friends.add(lyy);
		joelli.setAge(36);
		joelli.setSalary(10000.01);
		return joelli;

	}

	public static List<User> getTestUsers()
	{
		User joelli = new User("joelli");
		joelli.setAge(36);
		joelli.setSalary(10000.01);
		User lucy = new User("lucy");
		lucy.setAge(35);
		lucy.setSalary(6000.5);

		User lyy = new User("lyy");
		lyy.setAge(37);
		lyy.setSalary(12000.01);

		List all = new ArrayList();

		all.add(joelli);
		all.add(lucy);
		all.add(lyy);
		return all;

	}

}
