package com.soft.test;

import java.util.Date;

public class FlightManifestBean {

	/**
	 * 
	 */
		
	String manifestName;
	String passengerName;
	String cls;
	String seat;
	String sex;
	Date dob; 
	String passportNumber;
	String nationality;
	String bags;
	
	@Override
	public String toString() {
		return "FlightManifestBean [manifestName=" + manifestName
				+ ", passengerName=" + passengerName + ", cls=" + cls
				+ ", seat=" + seat + ", sex=" + sex + ", dob=" + dob
				+ ", passportNumber=" + passportNumber + ", nationality="
				+ nationality + ", bags=" + bags + "]";
	}
	public String getManifestName() {
		return manifestName;
	}
	public void setManifestName(String manifestName) {
		this.manifestName = manifestName;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBags() {
		return bags;
	}
	public void setBags(String bags) {
		this.bags = bags;
	}
		
}
