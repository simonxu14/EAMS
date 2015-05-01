package com.eams.model;

/**
 * CheckInfo entity. @author MyEclipse Persistence Tools
 */

public class CheckInfo implements java.io.Serializable {

	// Fields

	private Integer checkId;
	private GradeInfo gradeInfo;
	private ClassInfo classInfo;
	private EmpInfo empInfo;
	private Integer checkYear;
	private Integer checkMonth;
	private String checkFile;

	// Constructors

	/** default constructor */
	public CheckInfo() {
	}

	/** full constructor */
	public CheckInfo(GradeInfo gradeInfo, ClassInfo classInfo, EmpInfo empInfo,
			Integer checkYear, Integer checkMonth, String checkFile) {
		this.gradeInfo = gradeInfo;
		this.classInfo = classInfo;
		this.empInfo = empInfo;
		this.checkYear = checkYear;
		this.checkMonth = checkMonth;
		this.checkFile = checkFile;
	}

	// Property accessors

	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public GradeInfo getGradeInfo() {
		return this.gradeInfo;
	}

	public void setGradeInfo(GradeInfo gradeInfo) {
		this.gradeInfo = gradeInfo;
	}

	public ClassInfo getClassInfo() {
		return this.classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public EmpInfo getEmpInfo() {
		return this.empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public Integer getCheckYear() {
		return this.checkYear;
	}

	public void setCheckYear(Integer checkYear) {
		this.checkYear = checkYear;
	}

	public Integer getCheckMonth() {
		return this.checkMonth;
	}

	public void setCheckMonth(Integer checkMonth) {
		this.checkMonth = checkMonth;
	}

	public String getCheckFile() {
		return this.checkFile;
	}

	public void setCheckFile(String checkFile) {
		this.checkFile = checkFile;
	}

}