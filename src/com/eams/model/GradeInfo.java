package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * GradeInfo entity. @author MyEclipse Persistence Tools
 */

public class GradeInfo implements java.io.Serializable {

	// Fields

	private Integer gradeId;
	private String gradeName;
	private Boolean gradeValid;
	private Set classInfos = new HashSet(0);
	private Set checkInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public GradeInfo() {
	}

	/** full constructor */
	public GradeInfo(String gradeName, Boolean gradeValid, Set classInfos,
			Set checkInfos) {
		this.gradeName = gradeName;
		this.gradeValid = gradeValid;
		this.classInfos = classInfos;
		this.checkInfos = checkInfos;
	}

	// Property accessors

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Boolean getGradeValid() {
		return this.gradeValid;
	}

	public void setGradeValid(Boolean gradeValid) {
		this.gradeValid = gradeValid;
	}

	public Set getClassInfos() {
		return this.classInfos;
	}

	public void setClassInfos(Set classInfos) {
		this.classInfos = classInfos;
	}

	public Set getCheckInfos() {
		return this.checkInfos;
	}

	public void setCheckInfos(Set checkInfos) {
		this.checkInfos = checkInfos;
	}

}