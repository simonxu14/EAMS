package com.eams.model;

/**
 * StuConsult entity. @author MyEclipse Persistence Tools
 */

public class StuConsult implements java.io.Serializable {

	// Fields

	private Integer stuConsultId;
	private EmpInfo empInfo;
	private String stuConsultName;
	private Boolean consultSex;
	private Integer consultAge;
	private String consultSchool;
	private String consultAddress;
	private String consulTel;
	private String consultMajor;
	private String consultComment;
	private Boolean consultValid;
	private Double consultCost;
	private String consultCostType;
	private String consultRelation;
	private String consultChannel;
	private String consultWay;
	private Boolean consultPay;

	// Constructors

	/** default constructor */
	public StuConsult() {
	}

	/** full constructor */
	public StuConsult(EmpInfo empInfo, String stuConsultName,
			Boolean consultSex, Integer consultAge, String consultSchool,
			String consultAddress, String consulTel, String consultMajor,
			String consultComment, Boolean consultValid, Double consultCost,
			String consultCostType, String consultRelation,
			String consultChannel, String consultWay, Boolean consultPay) {
		this.empInfo = empInfo;
		this.stuConsultName = stuConsultName;
		this.consultSex = consultSex;
		this.consultAge = consultAge;
		this.consultSchool = consultSchool;
		this.consultAddress = consultAddress;
		this.consulTel = consulTel;
		this.consultMajor = consultMajor;
		this.consultComment = consultComment;
		this.consultValid = consultValid;
		this.consultCost = consultCost;
		this.consultCostType = consultCostType;
		this.consultRelation = consultRelation;
		this.consultChannel = consultChannel;
		this.consultWay = consultWay;
		this.consultPay = consultPay;
	}

	// Property accessors

	public Integer getStuConsultId() {
		return this.stuConsultId;
	}

	public void setStuConsultId(Integer stuConsultId) {
		this.stuConsultId = stuConsultId;
	}

	public EmpInfo getEmpInfo() {
		return this.empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public String getStuConsultName() {
		return this.stuConsultName;
	}

	public void setStuConsultName(String stuConsultName) {
		this.stuConsultName = stuConsultName;
	}

	public Boolean getConsultSex() {
		return this.consultSex;
	}

	public void setConsultSex(Boolean consultSex) {
		this.consultSex = consultSex;
	}

	public Integer getConsultAge() {
		return this.consultAge;
	}

	public void setConsultAge(Integer consultAge) {
		this.consultAge = consultAge;
	}

	public String getConsultSchool() {
		return this.consultSchool;
	}

	public void setConsultSchool(String consultSchool) {
		this.consultSchool = consultSchool;
	}

	public String getConsultAddress() {
		return this.consultAddress;
	}

	public void setConsultAddress(String consultAddress) {
		this.consultAddress = consultAddress;
	}

	public String getConsulTel() {
		return this.consulTel;
	}

	public void setConsulTel(String consulTel) {
		this.consulTel = consulTel;
	}

	public String getConsultMajor() {
		return this.consultMajor;
	}

	public void setConsultMajor(String consultMajor) {
		this.consultMajor = consultMajor;
	}

	public String getConsultComment() {
		return this.consultComment;
	}

	public void setConsultComment(String consultComment) {
		this.consultComment = consultComment;
	}

	public Boolean getConsultValid() {
		return this.consultValid;
	}

	public void setConsultValid(Boolean consultValid) {
		this.consultValid = consultValid;
	}

	public Double getConsultCost() {
		return this.consultCost;
	}

	public void setConsultCost(Double consultCost) {
		this.consultCost = consultCost;
	}

	public String getConsultCostType() {
		return this.consultCostType;
	}

	public void setConsultCostType(String consultCostType) {
		this.consultCostType = consultCostType;
	}

	public String getConsultRelation() {
		return this.consultRelation;
	}

	public void setConsultRelation(String consultRelation) {
		this.consultRelation = consultRelation;
	}

	public String getConsultChannel() {
		return this.consultChannel;
	}

	public void setConsultChannel(String consultChannel) {
		this.consultChannel = consultChannel;
	}

	public String getConsultWay() {
		return this.consultWay;
	}

	public void setConsultWay(String consultWay) {
		this.consultWay = consultWay;
	}

	public Boolean getConsultPay() {
		return this.consultPay;
	}

	public void setConsultPay(Boolean consultPay) {
		this.consultPay = consultPay;
	}

}