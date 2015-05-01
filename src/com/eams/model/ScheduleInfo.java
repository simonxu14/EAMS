package com.eams.model;

import java.sql.Timestamp;

/**
 * ScheduleInfo entity. @author MyEclipse Persistence Tools
 */

public class ScheduleInfo implements java.io.Serializable {

	// Fields

	private Integer schId;
	private EmpInfo empInfo;
	private Timestamp schStart;
	private Timestamp schEnd;
	private String schContent;
	private Boolean schValid;

	// Constructors

	/** default constructor */
	public ScheduleInfo() {
	}

	/** minimal constructor */
	public ScheduleInfo(Timestamp schStart, Timestamp schEnd) {
		this.schStart = schStart;
		this.schEnd = schEnd;
	}

	/** full constructor */
	public ScheduleInfo(EmpInfo empInfo, Timestamp schStart, Timestamp schEnd,
			String schContent, Boolean schValid) {
		this.empInfo = empInfo;
		this.schStart = schStart;
		this.schEnd = schEnd;
		this.schContent = schContent;
		this.schValid = schValid;
	}

	// Property accessors

	public Integer getSchId() {
		return this.schId;
	}

	public void setSchId(Integer schId) {
		this.schId = schId;
	}

	public EmpInfo getEmpInfo() {
		return this.empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public Timestamp getSchStart() {
		return this.schStart;
	}

	public void setSchStart(Timestamp schStart) {
		this.schStart = schStart;
	}

	public Timestamp getSchEnd() {
		return this.schEnd;
	}

	public void setSchEnd(Timestamp schEnd) {
		this.schEnd = schEnd;
	}

	public String getSchContent() {
		return this.schContent;
	}

	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}

	public Boolean getSchValid() {
		return this.schValid;
	}

	public void setSchValid(Boolean schValid) {
		this.schValid = schValid;
	}

}