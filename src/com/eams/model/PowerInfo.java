package com.eams.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * PowerInfo entity. @author MyEclipse Persistence Tools
 */

public class PowerInfo implements java.io.Serializable {

	// Fields

	private Integer powerId;
	private String powerName;
	private Integer powerAccount;
	private String powerComment;
	private Boolean powerValid;
	private Set empInfos = new HashSet(0);
	private ArrayList<Integer> powerAccountArray;

	// Constructors

	/** default constructor */
	public PowerInfo() {
	}

	public ArrayList<Integer> getPowerAccountArray() {
		return powerAccountArray;
	}

	public void setPowerAccountArray(ArrayList<Integer> powerAccountArray) {
		this.powerAccountArray = powerAccountArray;
	}

	/** full constructor */
	public PowerInfo(String powerName, Integer powerAccount,
			String powerComment, Boolean powerValid, Set empInfos) {
		this.powerName = powerName;
		this.powerAccount = powerAccount;
		this.powerComment = powerComment;
		this.powerValid = powerValid;
		this.empInfos = empInfos;
	}

	// Property accessors

	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public Integer getPowerAccount() {
		return this.powerAccount;
	}

	public void setPowerAccount(Integer powerAccount) {
		this.powerAccount = powerAccount;
	}

	public String getPowerComment() {
		return this.powerComment;
	}

	public void setPowerComment(String powerComment) {
		this.powerComment = powerComment;
	}

	public Boolean getPowerValid() {
		return this.powerValid;
	}

	public void setPowerValid(Boolean powerValid) {
		this.powerValid = powerValid;
	}

	public Set getEmpInfos() {
		return this.empInfos;
	}

	public void setEmpInfos(Set empInfos) {
		this.empInfos = empInfos;
	}

}