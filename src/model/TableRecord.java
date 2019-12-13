package model;

import java.util.*;

public class TableRecord {
	private List<String> strColNames;
	private Integer intID;
	private String	strFirstName;
	private Integer intAge;
	private String	strHome;
	
	//Test data to test code and class relationships
	public TableRecord() {
		strColNames = new ArrayList<String>();
		strColNames = Arrays.asList(new String[]{"ID","Name","Age","Home"});
		intID = 1;
		strFirstName = "John Doe";
		intAge = 30;
		strHome = "Dallas";
	}

	
	//*****Setters and Getters
	public List<String> getStrColNames() {
		return strColNames;
	}

	public void setStrColNames(List<String> strColNames) {
		this.strColNames = strColNames;
	}

	public Integer getIntID() {
		return intID;
	}

	public void setIntID(Integer intID) {
		this.intID = intID;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public Integer getIntAge() {
		return intAge;
	}

	public void setIntAge(Integer intAge) {
		this.intAge = intAge;
	}

	public String getStrHome() {
		return strHome;
	}

	public void setStrHome(String strHome) {
		this.strHome = strHome;
	}
}
