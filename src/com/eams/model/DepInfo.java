package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * DepInfo entity. @author MyEclipse Persistence Tools
 */

public class DepInfo implements java.io.Serializable {

	// Fields

	private Integer depId;
	private OrgInfo orgInfo;
	private String depName;
	private Integer depOrder;
	private Boolean depValid;
	private Set empInfos = new HashSet(0);
	private Set postInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public DepInfo() {
	}

	/** full constructor */
	public DepInfo(OrgInfo orgInfo, String depName, Integer depOrder,
			Boolean depValid, Set empInfos, Set postInfos) {
		this.orgInfo = orgInfo;
		this.depName = depName;
		this.depOrder = depOrder;
		this.depValid = depValid;
		this.empInfos = empInfos;
		this.postInfos = postInfos;
	}

	// Property accessors

	public Integer getDepId() {
		return this.depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public OrgInfo getOrgInfo() {
		return this.orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Integer getDepOrder() {
		return this.depOrder;
	}

	public void setDepOrder(Integer depOrder) {
		this.depOrder = depOrder;
	}

	public Boolean getDepValid() {
		return this.depValid;
	}

	public void setDepValid(Boolean depValid) {
		this.depValid = depValid;
	}

	public Set getEmpInfos() {
		return this.empInfos;
	}

	public void setEmpInfos(Set empInfos) {
		this.empInfos = empInfos;
	}

	public Set getPostInfos() {
		return this.postInfos;
	}

	public void setPostInfos(Set postInfos) {
		this.postInfos = postInfos;
	}

}