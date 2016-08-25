package com.example.bb;

public class Resource {
private int ID;
private String name;
private  String context;
private  String data;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public Resource(int iD, String name, String context, String data) {
	super();
	ID = iD;
	this.name = name;
	this.context = context;
	this.data = data;
}
}
