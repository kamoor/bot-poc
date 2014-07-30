package com.bot.vo;

public class LeadResponseVO {
	
	String leadId;
	
	String status;
	
	String descr;
	
	
	public LeadResponseVO(String leadId, String status, String descr){
		this.leadId = leadId;
		this.status = status;
		this.descr = descr;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	

}
