package com.herokuapp.jersey119;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlElement
	private String id;
	@XmlElement
	private String name;
	@XmlElement
	private int age;
	@XmlElement
	private List<ListData> list;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<ListData> getList() {
		return list;
	}
	public void setList(List<ListData> list) {
		this.list = list;
	}
}
