package com.eams.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EmpInfo entity. @author MyEclipse Persistence Tools
 */

public class EmpInfo implements java.io.Serializable {

	// Fields

	private Integer empId;
	private OrgInfo orgInfo;
	private PowerInfo powerInfo;
	private DepInfo depInfo;
	private PostInfo postInfo;
	private String empAccount;
	private String empName;
	private String empPassword;
	private String empPhoto;
	private Boolean empSex;
	private Timestamp empBirth;
	private String empIdcard;
	private String empPhone;
	private Integer empQq;
	private String empAddress;
	private Timestamp empStart;
	private Timestamp empEnd;
	private Boolean empValid;
	private Set scheduleInfos = new HashSet(0);
	private Set stuConsults = new HashSet(0);
	private Set checkInfos = new HashSet(0);
	private String role;
	
	
	
	// Constructors




	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/** default constructor */
	public EmpInfo() {
	}

	/** full constructor */
	public EmpInfo(OrgInfo orgInfo, PowerInfo powerInfo, DepInfo depInfo,
			PostInfo postInfo, String empAccount, String empName,
			String empPassword, String empPhoto, Boolean empSex,
			Timestamp empBirth, String empIdcard, String empPhone,
			Integer empQq, String empAddress, Timestamp empStart,
			Timestamp empEnd, Boolean empValid, Set scheduleInfos,
			Set stuConsults, Set checkInfos) {
		this.orgInfo = orgInfo;
		this.powerInfo = powerInfo;
		this.depInfo = depInfo;
		this.postInfo = postInfo;
		this.empAccount = empAccount;
		this.empName = empName;
		this.empPassword = empPassword;
		this.empPhoto = empPhoto;
		this.empSex = empSex;
		this.empBirth = empBirth;
		this.empIdcard = empIdcard;
		this.empPhone = empPhone;
		this.empQq = empQq;
		this.empAddress = empAddress;
		this.empStart = empStart;
		this.empEnd = empEnd;
		this.empValid = empValid;
		this.scheduleInfos = scheduleInfos;
		this.stuConsults = stuConsults;
		this.checkInfos = checkInfos;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public OrgInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	public PowerInfo getPowerInfo() {
		return powerInfo;
	}

	public void setPowerInfo(PowerInfo powerInfo) {
		this.powerInfo = powerInfo;
	}

	public DepInfo getDepInfo() {
		return depInfo;
	}

	public void setDepInfo(DepInfo depInfo) {
		this.depInfo = depInfo;
	}

	public PostInfo getPostInfo() {
		return postInfo;
	}

	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}

	public String getEmpAccount() {
		return empAccount;
	}

	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public Boolean getEmpSex() {
		return empSex;
	}

	public void setEmpSex(Boolean empSex) {
		this.empSex = empSex;
	}

	public Timestamp getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(Timestamp empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpIdcard() {
		return empIdcard;
	}

	public void setEmpIdcard(String empIdcard) {
		this.empIdcard = empIdcard;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public Integer getEmpQq() {
		return empQq;
	}

	public void setEmpQq(Integer empQq) {
		this.empQq = empQq;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Timestamp getEmpStart() {
		return empStart;
	}

	public void setEmpStart(Timestamp empStart) {
		this.empStart = empStart;
	}

	public Timestamp getEmpEnd() {
		return empEnd;
	}

	public void setEmpEnd(Timestamp empEnd) {
		this.empEnd = empEnd;
	}

	public Boolean getEmpValid() {
		return empValid;
	}

	public void setEmpValid(Boolean empValid) {
		this.empValid = empValid;
	}

	public Set getScheduleInfos() {
		return scheduleInfos;
	}

	public void setScheduleInfos(Set scheduleInfos) {
		this.scheduleInfos = scheduleInfos;
	}

	public Set getStuConsults() {
		return stuConsults;
	}

	public void setStuConsults(Set stuConsults) {
		this.stuConsults = stuConsults;
	}

	public Set getCheckInfos() {
		return checkInfos;
	}

	public void setCheckInfos(Set checkInfos) {
		this.checkInfos = checkInfos;
	}
	
	




}