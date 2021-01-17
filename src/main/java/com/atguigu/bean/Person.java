package com.atguigu.bean;

public class Person {
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	private Integer age;
	private String name;
	public Person() {
		
	}
	
	public Person(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
