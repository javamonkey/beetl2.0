package org.beetl.performance.lab;



public class User {
	String name = "user";
	int id;
	double price;

	private class MyPrivateTest implements PrivateTest
	{

		@Override
		public String getName()
		{
			return "abc";
		}

	}

	MyPrivateTest pt = new MyPrivateTest();

	public PrivateTest getPt()
	{
		return pt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[][] getBooks() {
		return null;
	}

	public User getPeer() {
		return new User();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Object get(String cr){
		return "";
	}

}
