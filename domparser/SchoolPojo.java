package com.domparser;

import java.util.List;


public class SchoolPojo {

	
	int classnumber;
	String classteacher;
	int subs;
	static public List<StudentPojo> list;
	
	
	public List<StudentPojo> getList() {
		return list;
	}
	public void setList(List<StudentPojo> list) {
		this.list = list;
	}
	public int getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(int classnumber) {
		this.classnumber = classnumber;
	}
	public String getClassteacher() {
		return classteacher;
	}
	public void setClassteacher(String classteacher) {
		this.classteacher = classteacher;
	}
	public int getSubs() {
		return subs;
	}
	public void setSubs(int subs) {
		this.subs = subs;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Class number :"+this.classnumber+" Class techer "+this.classteacher+" subs "+this.subs;
	}




}
