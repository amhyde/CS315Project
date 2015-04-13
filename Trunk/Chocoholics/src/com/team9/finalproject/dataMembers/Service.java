package com.team9.finalproject.dataMembers;

import java.io.Serializable;

public class Service implements DataInterface, Serializable{

	private String serviceCode;
	private String serviceDate;
	private String recivedDate;
	private String providerNumber;
	private String memberNumber;
	private String comment;
	
	public Service(String serviceCode, String sericeDate, String recivedDate,
			String providerNumber, String memberNumber, String comment) {
		super();
		this.serviceCode = serviceCode;
		this.serviceDate = sericeDate;
		this.recivedDate = recivedDate;
		this.providerNumber = providerNumber;
		this.memberNumber = memberNumber;
		this.comment = comment;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String sericeDate) {
		this.serviceDate = sericeDate;
	}

	public String getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(String recivedDate) {
		this.recivedDate = recivedDate;
	}

	public String getProviderNumber() {
		return providerNumber;
	}

	public void setProviderNumber(String providerNumber) {
		this.providerNumber = providerNumber;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String reportFormat() {
		return String.format("Service Code: %s\nService Date: %s\nRecived Date: %s\nProvider Number: %s\nMember Number: %s\n"
				, serviceCode, serviceDate, recivedDate, providerNumber, memberNumber);

	}

	

}
