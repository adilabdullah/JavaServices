package com.java.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Response")
public class Response {
String code;
String desc;
List<Accounts> result;

public List<Accounts> getResult() {
	return result;
}
public void setResult(List<Accounts> result) {
	this.result = result;
}
public Response() {
	super();
	// TODO Auto-generated constructor stub
}
public Response(String code, String desc,List<Accounts> result) {
	super();
	this.code = code;
	this.desc = desc;
	this.result=result;
}
@Override
public String toString() {
	return "Response [code=" + code + ", desc=" + desc + "]";
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

}
