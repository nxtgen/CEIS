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
	String gender;
	Date dob; 
	String passportNumber;
	
	String nationality;
	String bags;
	FlightManifestBean infant;
	public FlightManifestBean getInfant() {
		return infant;
	}
	public void setInfant(FlightManifestBean infant) {
		this.infant = infant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((passportNumber == null) ? 0 : passportNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightManifestBean other = (FlightManifestBean) obj;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FlightManifestBean [manifestName=" + manifestName
				+ ", passengerName=" + passengerName + ", cls=" + cls
				+ ", seat=" + seat + ", gender=" + gender + ", dob=" + dob
				+ ", passportNumber=" + passportNumber + ", nationality="
				+ nationality + ", bags=" + bags + ", infant=" + infant + "]";
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
		return gender;
	}
	public void setSex(String sex) {
		this.gender = sex;
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
