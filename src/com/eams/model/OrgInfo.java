package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * OrgInfo entity. @author MyEclipse Persistence Tools
 */

public class OrgInfo implements java.io.Serializable {

	// Fields

	private Integer orgId;
	private String orgName;
	private Integer orgOrder;
	private Boolean orgValid;
	private Set empInfos = new HashSet(0);
	private Set depInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public OrgInfo() {
	}

	/** full constructor */
	public OrgInfo(String orgName, Integer orgOrder, Boolean orgValid,
			Set empInfos, Set depInfos) {
		this.orgName = orgName;
		this.orgOrder = orgOrder;
		this.orgValid = orgValid;
		this.empInfos = empInfos;
		this.depInfos = depInfos;
	}

	// Property accessors

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getOrgOrder() {
		return this.orgOrder;
	}

	public void setOrgOrder(Integer orgOrder) {
		this.orgOrder = orgOrder;
	}

	public Boolean getOrgValid() {
		return this.orgValid;
	}

	public void setOrgValid(Boolean orgValid) {
		this.orgValid = orgValid;
	}

	public Set getEmpInfos() {
		return this.empInfos;
	}

	public void setEmpInfos(Set empInfos) {
		this.empInfos = empInfos;
	}

	public Set getDepInfos() {
		return this.depInfos;
	}

	public void setDepInfos(Set depInfos) {
		this.depInfos = depInfos;
	}

}