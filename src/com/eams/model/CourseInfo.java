package com.eams.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CourseInfo entity. @author MyEclipse Persistence Tools
 */

public class CourseInfo implements java.io.Serializable {

	// Fields

	private Integer courseId;
	private TeachInfo teachInfo;
	private String courseName;
	private String courseMajor;
	private Integer courseRemain;
	private Timestamp courseStart;
	private Timestamp courseEnd;
	private String courseComment;
	private String teachManagePlan;
	private String teachManageCase;
	private String teacherSummary;
	private Timestamp teachManageTime;
	private Boolean courseValid;
	private Set stuChecks = new HashSet(0);
	private Set stuCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CourseInfo() {
	}

	/** minimal constructor */
	public CourseInfo(Timestamp courseStart, Timestamp courseEnd,
			Timestamp teachManageTime) {
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.teachManageTime = teachManageTime;
	}

	/** full constructor */
	public CourseInfo(TeachInfo teachInfo, String courseName,
			String courseMajor, Integer courseRemain, Timestamp courseStart,
			Timestamp courseEnd, String courseComment, String teachManagePlan,
			String teachManageCase, String teacherSummary,
			Timestamp teachManageTime, Boolean courseValid, Set stuChecks,
			Set stuCourses) {
		this.teachInfo = teachInfo;
		this.courseName = courseName;
		this.courseMajor = courseMajor;
		this.courseRemain = courseRemain;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
		this.courseComment = courseComment;
		this.teachManagePlan = teachManagePlan;
		this.teachManageCase = teachManageCase;
		this.teacherSummary = teacherSummary;
		this.teachManageTime = teachManageTime;
		this.courseValid = courseValid;
		this.stuChecks = stuChecks;
		this.stuCourses = stuCourses;
	}

	// Property accessors

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public TeachInfo getTeachInfo() {
		return this.teachInfo;
	}

	public void setTeachInfo(TeachInfo teachInfo) {
		this.teachInfo = teachInfo;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseMajor() {
		return this.courseMajor;
	}

	public void setCourseMajor(String courseMajor) {
		this.courseMajor = courseMajor;
	}

	public Integer getCourseRemain() {
		return this.courseRemain;
	}

	public void setCourseRemain(Integer courseRemain) {
		this.courseRemain = courseRemain;
	}

	public Timestamp getCourseStart() {
		return this.courseStart;
	}

	public void setCourseStart(Timestamp courseStart) {
		this.courseStart = courseStart;
	}

	public Timestamp getCourseEnd() {
		return this.courseEnd;
	}

	public void setCourseEnd(Timestamp courseEnd) {
		this.courseEnd = courseEnd;
	}

	public String getCourseComment() {
		return this.courseComment;
	}

	public void setCourseComment(String courseComment) {
		this.courseComment = courseComment;
	}

	public String getTeachManagePlan() {
		return this.teachManagePlan;
	}

	public void setTeachManagePlan(String teachManagePlan) {
		this.teachManagePlan = teachManagePlan;
	}

	public String getTeachManageCase() {
		return this.teachManageCase;
	}

	public void setTeachManageCase(String teachManageCase) {
		this.teachManageCase = teachManageCase;
	}

	public String getTeacherSummary() {
		return this.teacherSummary;
	}

	public void setTeacherSummary(String teacherSummary) {
		this.teacherSummary = teacherSummary;
	}

	public Timestamp getTeachManageTime() {
		return this.teachManageTime;
	}

	public void setTeachManageTime(Timestamp teachManageTime) {
		this.teachManageTime = teachManageTime;
	}

	public Boolean getCourseValid() {
		return this.courseValid;
	}

	public void setCourseValid(Boolean courseValid) {
		this.courseValid = courseValid;
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