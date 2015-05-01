package com.eams.model;

/**
 * StuCourse entity. @author MyEclipse Persistence Tools
 */

public class StuCourse implements java.io.Serializable {

	// Fields

	private Integer stuCourseId;
	private StuInfo stuInfo;
	private CourseInfo courseInfo;
	private String stuSituation;
	private Integer stuGrade;
	private Integer tecGrade;
	private String courseComment;

	// Constructors

	/** default constructor */
	public StuCourse() {
	}

	/** full constructor */
	public StuCourse(StuInfo stuInfo, CourseInfo courseInfo,
			String stuSituation, Integer stuGrade, Integer tecGrade,
			String courseComment) {
		this.stuInfo = stuInfo;
		this.courseInfo = courseInfo;
		this.stuSituation = stuSituation;
		this.stuGrade = stuGrade;
		this.tecGrade = tecGrade;
		this.courseComment = courseComment;
	}

	// Property accessors

	public Integer getStuCourseId() {
		return this.stuCourseId;
	}

	public void setStuCourseId(Integer stuCourseId) {
		this.stuCourseId = stuCourseId;
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

	public String getStuSituation() {
		return this.stuSituation;
	}

	public void setStuSituation(String stuSituation) {
		this.stuSituation = stuSituation;
	}

	public Integer getStuGrade() {
		return this.stuGrade;
	}

	public void setStuGrade(Integer stuGrade) {
		this.stuGrade = stuGrade;
	}

	public Integer getTecGrade() {
		return this.tecGrade;
	}

	public void setTecGrade(Integer tecGrade) {
		this.tecGrade = tecGrade;
	}

	public String getCourseComment() {
		return this.courseComment;
	}

	public void setCourseComment(String courseComment) {
		this.courseComment = courseComment;
	}

}