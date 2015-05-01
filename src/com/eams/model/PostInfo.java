package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * PostInfo entity. @author MyEclipse Persistence Tools
 */

public class PostInfo implements java.io.Serializable {

	// Fields

	private Integer postId;
	private DepInfo depInfo;
	private String postName;
	private Integer postSalary;
	private Boolean postValid;
	private Set empInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public PostInfo() {
	}

	/** full constructor */
	public PostInfo(DepInfo depInfo, String postName, Integer postSalary,
			Boolean postValid, Set empInfos) {
		this.depInfo = depInfo;
		this.postName = postName;
		this.postSalary = postSalary;
		this.postValid = postValid;
		this.empInfos = empInfos;
	}

	// Property accessors

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public DepInfo getDepInfo() {
		return this.depInfo;
	}

	public void setDepInfo(DepInfo depInfo) {
		this.depInfo = depInfo;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Integer getPostSalary() {
		return this.postSalary;
	}

	public void setPostSalary(Integer postSalary) {
		this.postSalary = postSalary;
	}

	public Boolean getPostValid() {
		return this.postValid;
	}

	public void setPostValid(Boolean postValid) {
		this.postValid = postValid;
	}

	public Set getEmpInfos() {
		return this.empInfos;
	}

	public void setEmpInfos(Set empInfos) {
		this.empInfos = empInfos;
	}

}