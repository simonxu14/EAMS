package com.eams.model;

import java.util.HashSet;
import java.util.Set;

/**
 * TeachLevel entity. @author MyEclipse Persistence Tools
 */

public class TeachLevel implements java.io.Serializable {

	// Fields

	private Integer teachLevelId;
	private String teachLevelName;
	private Integer teachLevelClasshour;
	private Double teachLevelCost;
	private Boolean teachLevelValid;
	private Set teachInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeachLevel() {
	}

	/** full constructor */
	public TeachLevel(String teachLevelName, Integer teachLevelClasshour,
			Double teachLevelCost, Boolean teachLevelValid, Set teachInfos) {
		this.teachLevelName = teachLevelName;
		this.teachLevelClasshour = teachLevelClasshour;
		this.teachLevelCost = teachLevelCost;
		this.teachLevelValid = teachLevelValid;
		this.teachInfos = teachInfos;
	}

	// Property accessors

	public Integer getTeachLevelId() {
		return this.teachLevelId;
	}

	public void setTeachLevelId(Integer teachLevelId) {
		this.teachLevelId = teachLevelId;
	}

	public String getTeachLevelName() {
		return this.teachLevelName;
	}

	public void setTeachLevelName(String teachLevelName) {
		this.teachLevelName = teachLevelName;
	}

	public Integer getTeachLevelClasshour() {
		return this.teachLevelClasshour;
	}

	public void setTeachLevelClasshour(Integer teachLevelClasshour) {
		this.teachLevelClasshour = teachLevelClasshour;
	}

	public Double getTeachLevelCost() {
		return this.teachLevelCost;
	}

	public void setTeachLevelCost(Double teachLevelCost) {
		this.teachLevelCost = teachLevelCost;
	}

	public Boolean getTeachLevelValid() {
		return this.teachLevelValid;
	}

	public void setTeachLevelValid(Boolean teachLevelValid) {
		this.teachLevelValid = teachLevelValid;
	}

	public Set getTeachInfos() {
		return this.teachInfos;
	}

	public void setTeachInfos(Set teachInfos) {
		this.teachInfos = teachInfos;
	}

}