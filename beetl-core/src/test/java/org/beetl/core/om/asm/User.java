package org.beetl.core.om.asm;

import java.util.Date;

public class User {

	private String name;
	private String address;
	private int numbers;
	private Date birthDate;
	private boolean isManager;
	private float height;
	private double weight;
	private long distance;
	private char gender;
	private byte flag;
	private short age;
	private int aaAa;
	private int aaBB;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public int getAaAa() {
		return aaAa;
	}

	public void setAaAa(int aa) {
		aaAa = aa;
	}

	public int getAaBB() {
		return aaBB;
	}

	public void setAaBB(int bB) {
		aaBB = bB;
	}

	public Object get(Object key) {
		return "哈哈是";
	}
}
