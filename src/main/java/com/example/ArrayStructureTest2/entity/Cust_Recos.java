package com.example.ArrayStructureTest2.entity;

public class Cust_Recos {
	private String cust_id;
	private String story_id;
	private String recos;
	
	public Cust_Recos(String cust_id,String story_id,String recos) {
		this.cust_id=cust_id;
		this.story_id=story_id;
		this.recos=recos;
	}
	
	public String getCustId() {
		return cust_id;
	}
	
	public String getStoryId() {
		return story_id;
	}
	
	public String getRecos() {
		return recos;
	}
	
	public void setCustId(String cust_id) {
		 this.cust_id=cust_id;
	}
	
	public void setStoryId(String story_id) {
		this.story_id=story_id;
	}
	
	public void setRecos(String recos) {
		this.recos=recos;
	}

}
