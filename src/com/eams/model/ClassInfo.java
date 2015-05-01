package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassInfo entity. @author MyEclipse Persistence Tools
 */

public class ClassInfo implements java.io.Serializable {

	// Fields

	private Integer classId;
	private GradeInfo gradeInfo;
	private String className;
	private Boolean classValid;
	private Set checkInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClassInfo() {
	}

	/** full constructor */
	public ClassInfo(GradeInfo gradeInfo, String className, Boolean classValid,
			Set checkInfos) {
		this.gradeInfo = gradeInfo;
		this.className = className;
		this.classValid = classValid;
		this.checkInfos = checkInfos;
	}

	// Property accessors

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public GradeInfo getGradeInfo() {
		return this.gradeInfo;
	}

	public void setGradeInfo(GradeInfo gradeInfo) {
		this.gradeInfo = gradeInfo;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Boolean getClassValid() {
		return this.classValid;
	}

	public void setClassValid(Boolean classValid) {
		this.classValid = classValid;
	}

	public Set getCheckInfos() {
		return this.checkInfos;
	}

	public void setCheckInfos(Set checkInfos) {
		this.checkInfos = checkInfos;
	}

}