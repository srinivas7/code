package com.syncaccdetails;



public class EmpAcc {

	int AccId;
	Object obj;
	
	EmpAcc(int AccId){
		this.AccId = AccId;
	}

	public int getAccId() {
		return AccId;
	}
	public void setAccId(int accId) {
		AccId = accId;
	}
	
	@Override
	public int hashCode(){
		
		return  AccId;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(this.obj == obj)
		return true;
		
		else
		return false;
	}
}
