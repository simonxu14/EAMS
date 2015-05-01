package com.eams.model;

import java.sql.Timestamp;

/**
 * StuCheck entity. @author MyEclipse Persistence Tools
 */

public class StuCheck implements java.io.Serializable {

	// Fields

	private Integer stuCheckId;
	private StuInfo stuInfo;
	private CourseInfo courseInfo;
	private Timestamp stuCheckTime;
	private Boolean stuCheckInfo;
	private String stuCheckComment;

	// Constructors

	/** default constructor */
	public StuCheck() {
	}

	/** minimal constructor */
	public StuCheck(Timestamp stuCheckTime) {
		this.stuCheckTime = stuCheckTime;
	}

	/** full constructor */
	public StuCheck(StuInfo stuInfo, CourseInfo courseInfo,
			Timestamp stuCheckTime, Boolean stuCheckInfo, String stuCheckComment) {
		this.stuInfo = stuInfo;
		this.courseInfo = courseInfo;
		this.stuCheckTime = stuCheckTime;
		this.stuCheckInfo = stuCheckInfo;
		this.stuCheckComment = stuCheckComment;
	}

	// Property accessors

	public Integer getStuCheckId() {
		return this.stuCheckId;
	}

	public void setStuCheckId(Integer stuCheckId) {
		this.stuCheckId = stuCheckId;
	}

	public StuInfo getStuInfo() {
		return this.stuInfo;
	}

	public void setStuInfo(StuInfo stuInfo) {
		this.stuInfo = stuInfo;
	}

	public CourseInfo getCourseInfo() {
		return this.courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public Timestamp getStuCheckTime() {
		return this.stuCheckTime;
	}

	public void setStuCheckTime(Timestamp stuCheckTime) {
		this.stuCheckTime = stuCheckTime;
	}

	public Boolean getStuCheckInfo() {
		return this.stuCheckInfo;
	}

	public void setStuCheckInfo(Boolean stuCheckInfo) {
		this.stuCheckInfo = stuCheckInfo;
	}

	public String getStuCheckComment() {
		return this.stuCheckComment;
	}

	public void setStuCheckComment(String stuCheckComment) {
		this.stuCheckComment = stuCheckComment;
	}

}