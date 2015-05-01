package com.eams.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StuInfo entity. @author MyEclipse Persistence Tools
 */

public class StuInfo implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String stuAccount;
	private String stuName;
	private String stuPassword;
	private String stuPhoto;
	private Integer stuSex;
	private Timestamp stuBirth;
	private String stuSchool;
	private String stuAddress;
	private Integer stuBalance;
	private String stuTel;
	private String stuMajor;
	private String stuComment;
	private Boolean stuValid;
	private Set stuChecks = new HashSet(0);
	private Set stuCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public StuInfo() {
	}

	/** minimal constructor */
	public StuInfo(Timestamp stuBirth) {
		this.stuBirth = stuBirth;
	}

	/** full constructor */
	public StuInfo(String stuAccount, String stuName, String stuPassword,
			String stuPhoto, Integer stuSex, Timestamp stuBirth,
			String stuSchool, String stuAddress, Integer stuBalance,
			String stuTel, String stuMajor, String stuComment,
			Boolean stuValid, Set stuChecks, Set stuCourses) {
		this.stuAccount = stuAccount;
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuPhoto = stuPhoto;
		this.stuSex = stuSex;
		this.stuBirth = stuBirth;
		this.stuSchool = stuSchool;
		this.stuAddress = stuAddress;
		this.stuBalance = stuBalance;
		this.stuTel = stuTel;
		this.stuMajor = stuMajor;
		this.stuComment = stuComment;
		this.stuValid = stuValid;
		this.stuChecks = stuChecks;
		this.stuCourses = stuCourses;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuAccount() {
		return this.stuAccount;
	}

	public void setStuAccount(String stuAccount) {
		this.stuAccount = stuAccount;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPassword() {
		return this.stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuPhoto() {
		return this.stuPhoto;
	}

	public void setStuPhoto(String stuPhoto) {
		this.stuPhoto = stuPhoto;
	}

	public Integer getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(Integer stuSex) {
		this.stuSex = stuSex;
	}

	public Timestamp getStuBirth() {
		return this.stuBirth;
	}

	public void setStuBirth(Timestamp stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuSchool() {
		return this.stuSchool;
	}

	public void setStuSchool(String stuSchool) {
		this.stuSchool = stuSchool;
	}

	public String getStuAddress() {
		return this.stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public Integer getStuBalance() {
		return this.stuBalance;
	}

	public void setStuBalance(Integer stuBalance) {
		this.stuBalance = stuBalance;
	}

	public String getStuTel() {
		return this.stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuMajor() {
		return this.stuMajor;
	}

	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}

	public String getStuComment() {
		return this.stuComment;
	}

	public void setStuComment(String stuComment) {
		this.stuComment = stuComment;
	}

	public Boolean getStuValid() {
		return this.stuValid;
	}

	public void setStuValid(Boolean stuValid) {
		this.stuValid = stuValid;
	}

	public Set getStuChecks() {
		return this.stuChecks;
	}

	public void setStuChecks(Set stuChecks) {
		this.stuChecks = stuChecks;
	}

	public Set getStuCourses() {
		return this.stuCourses;
	}

	public void setStuCourses(Set stuCourses) {
		this.stuCourses = stuCourses;
	}

}