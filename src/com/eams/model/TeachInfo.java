package com.eams.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TeachInfo entity. @author MyEclipse Persistence Tools
 */

public class TeachInfo implements java.io.Serializable {

	// Fields

	private Integer teachId;
	private TeachLevel teachLevel;
	private String teachAccount;
	private String teachName;
	private String teachPsd;
	private String teachPhoto;
	private Boolean teachSex;
	private String teachIdentity;
	private String teachTel;
	private Integer teachQq;
	private String teachAddress;
	private String teachCollage;
	private String teachMajor;
	private String teachType;
	private Integer teachClassNumber;
	private Timestamp teachStart;
	private Timestamp teachEnd;
	private String teachClearForm;
	private String teachComment;
	private Boolean teachValid;
	private Set courseInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeachInfo() {
	}

	/** minimal constructor */
	public TeachInfo(Timestamp teachStart, Timestamp teachEnd) {
		this.teachStart = teachStart;
		this.teachEnd = teachEnd;
	}

	/** full constructor */
	public TeachInfo(TeachLevel teachLevel, String teachAccount,
			String teachName, String teachPsd, String teachPhoto,
			Boolean teachSex, String teachIdentity, String teachTel,
			Integer teachQq, String teachAddress, String teachCollage,
			String teachMajor, String teachType, Integer teachClassNumber,
			Timestamp teachStart, Timestamp teachEnd, String teachClearForm,
			String teachComment, Boolean teachValid, Set courseInfos) {
		this.teachLevel = teachLevel;
		this.teachAccount = teachAccount;
		this.teachName = teachName;
		this.teachPsd = teachPsd;
		this.teachPhoto = teachPhoto;
		this.teachSex = teachSex;
		this.teachIdentity = teachIdentity;
		this.teachTel = teachTel;
		this.teachQq = teachQq;
		this.teachAddress = teachAddress;
		this.teachCollage = teachCollage;
		this.teachMajor = teachMajor;
		this.teachType = teachType;
		this.teachClassNumber = teachClassNumber;
		this.teachStart = teachStart;
		this.teachEnd = teachEnd;
		this.teachClearForm = teachClearForm;
		this.teachComment = teachComment;
		this.teachValid = teachValid;
		this.courseInfos = courseInfos;
	}

	// Property accessors

	public Integer getTeachId() {
		return this.teachId;
	}

	public void setTeachId(Integer teachId) {
		this.teachId = teachId;
	}

	public TeachLevel getTeachLevel() {
		return this.teachLevel;
	}

	public void setTeachLevel(TeachLevel teachLevel) {
		this.teachLevel = teachLevel;
	}

	public String getTeachAccount() {
		return this.teachAccount;
	}

	public void setTeachAccount(String teachAccount) {
		this.teachAccount = teachAccount;
	}

	public String getTeachName() {
		return this.teachName;
	}

	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}

	public String getTeachPsd() {
		return this.teachPsd;
	}

	public void setTeachPsd(String teachPsd) {
		this.teachPsd = teachPsd;
	}

	public String getTeachPhoto() {
		return this.teachPhoto;
	}

	public void setTeachPhoto(String teachPhoto) {
		this.teachPhoto = teachPhoto;
	}

	public Boolean getTeachSex() {
		return this.teachSex;
	}

	public void setTeachSex(Boolean teachSex) {
		this.teachSex = teachSex;
	}

	public String getTeachIdentity() {
		return this.teachIdentity;
	}

	public void setTeachIdentity(String teachIdentity) {
		this.teachIdentity = teachIdentity;
	}

	public String getTeachTel() {
		return this.teachTel;
	}

	public void setTeachTel(String teachTel) {
		this.teachTel = teachTel;
	}

	public Integer getTeachQq() {
		return this.teachQq;
	}

	public void setTeachQq(Integer teachQq) {
		this.teachQq = teachQq;
	}

	public String getTeachAddress() {
		return this.teachAddress;
	}

	public void setTeachAddress(String teachAddress) {
		this.teachAddress = teachAddress;
	}

	public String getTeachCollage() {
		return this.teachCollage;
	}

	public void setTeachCollage(String teachCollage) {
		this.teachCollage = teachCollage;
	}

	public String getTeachMajor() {
		return this.teachMajor;
	}

	public void setTeachMajor(String teachMajor) {
		this.teachMajor = teachMajor;
	}

	public String getTeachType() {
		return this.teachType;
	}

	public void setTeachType(String teachType) {
		this.teachType = teachType;
	}

	public Integer getTeachClassNumber() {
		return this.teachClassNumber;
	}

	public void setTeachClassNumber(Integer teachClassNumber) {
		this.teachClassNumber = teachClassNumber;
	}

	public Timestamp getTeachStart() {
		return this.teachStart;
	}

	public void setTeachStart(Timestamp teachStart) {
		this.teachStart = teachStart;
	}

	public Timestamp getTeachEnd() {
		return this.teachEnd;
	}

	public void setTeachEnd(Timestamp teachEnd) {
		this.teachEnd = teachEnd;
	}

	public String getTeachClearForm() {
		return this.teachClearForm;
	}

	public void setTeachClearForm(String teachClearForm) {
		this.teachClearForm = teachClearForm;
	}

	public String getTeachComment() {
		return this.teachComment;
	}

	public void setTeachComment(String teachComment) {
		this.teachComment = teachComment;
	}

	public Boolean getTeachValid() {
		return this.teachValid;
	}

	public void setTeachValid(Boolean teachValid) {
		this.teachValid = teachValid;
	}

	public Set getCourseInfos() {
		return this.courseInfos;
	}

	public void setCourseInfos(Set courseInfos) {
		this.courseInfos = courseInfos;
	}

}