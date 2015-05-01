package com.eams.course.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

import com.eams.course.service.CourseService;
import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.opensymphony.xwork2.ActionContext;

public class CourseAction {

	private CourseService courseService;
	private List<CourseInfo> allCourseList;
	private Map<String,Object> request;
	private Map<String,Object> request_courseFlag;
	private Map<String,Object> request_courseUpdateFlag;
	private CourseInfo course;

	public Map<String, Object> getRequest() {
		return request;
	}

	public Map<String, Object> getRequest_courseFlag() {
		return request_courseFlag;
	}

	public void setRequest_courseFlag(Map<String, Object> requestCourseFlag) {
		request_courseFlag = requestCourseFlag;
	}

	public Map<String, Object> getRequest_courseUpdateFlag() {
		return request_courseUpdateFlag;
	}

	public void setRequest_courseUpdateFlag(
			Map<String, Object> requestCourseUpdateFlag) {
		request_courseUpdateFlag = requestCourseUpdateFlag;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public CourseService getCourseService() {
		return courseService;
	}
	
	public void setAllCourseList(List<CourseInfo> allCourseList) {
		this.allCourseList = allCourseList;
	}

	public List<CourseInfo> getAllCourseList() {
		return allCourseList;
	}
	public void setCourse(CourseInfo course) {
		this.course = course;
	}
	
	public CourseInfo getCourse() {
		return course;
	}
	
	/*
	 * 查询所有课程
	 */
	public String queryAllCourses(){
		allCourseList = courseService.queryAllCourses();
		request=(Map)ActionContext.getContext().get("request");
		request.put("allCL",allCourseList);
		System.out.println("success action level");
		return "showAllCourse";
	}
	/*
	 * 查询所有老师信息
	 */
	public String queryAllTeachInfo(){
		List<TeachInfo> allTeacher = courseService.queryAllTeachInfo();
		request=(Map)ActionContext.getContext().get("request");
		request.put("allTC",allTeacher);
		return "addCourse";
	}
	/*
	 * 增加课程
	 */
	public String addCourse(){
		//this.setSession_courseFlag(null);
		System.out.println(course.getCourseName()+" name of course");
		System.out.println(course.getCourseStart() + "start time");
		
		//获取开始时间，设置结束时间
		Calendar endtime = Calendar.getInstance();
		endtime.setTime(course.getCourseStart());
		endtime.set(Calendar.MINUTE, 50);
		
		//Date类型向Timestamp类型转换
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(endtime.getTime());
		Timestamp ts_end = Timestamp.valueOf(time);
		
		course.setCourseEnd(ts_end);
		System.out.println(course.getCourseEnd()+ "end time");
		int flag = courseService.addCourse(course);
		request_courseFlag=(Map)ActionContext.getContext().get("request");
		
		if(flag==0){
			return "success";
		}else{
			request_courseFlag.put("courseFlag",flag);//1 课程日期和老师冲突  2  课程时间和老师时间冲突  3 课程和老师其他课程冲突 0  添加课程成功
			return queryAllTeachInfo();
		}
	}
	/*
	 * 删除课程
	 */
	public String deleteCourse(){
		courseService.deleteCourse(course);
		return queryAllCourses();
	}
	/*
	 * 通过ID查询courseInfo类
	 */
	public String queryCourseById(){
		//this.setSession_courseUpdateFlag(null);
		course = courseService.queryCourseById(course.getCourseId());
		List<TeachInfo> allTeacher = courseService.queryAllTeachInfo();
		request=(Map)ActionContext.getContext().get("request");
		request.put("course",course);
		request.put("allTeacher",allTeacher);
		return "courseInfo";
	}
	/*
	 * 更新课程信息
	 */
	public String updateCourseInfo(){
	
		Calendar endtime = Calendar.getInstance();
		endtime.setTime(course.getCourseStart());
		endtime.set(Calendar.MINUTE, 50);
		
		//Date类型向Timestamp类型转换
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(endtime.getTime());
		Timestamp ts_end = Timestamp.valueOf(time);
		
		course.setCourseEnd(ts_end);
		System.out.println(course.getTeachInfo().getTeachId()+" "+course.getTeachInfo().getTeachName());
		int flag = courseService.updateCourseInfo(course);
		request_courseUpdateFlag=(Map)ActionContext.getContext().get("request");
		request_courseUpdateFlag.put("courseUpdateFlag",flag);//1 课程日期和老师冲突  2  课程时间和老师时间冲突 3 课程和老师其他课程冲突   0  添加课程成功
		if(flag==0){
			return queryAllCourses();
		}else{
			return queryCourseById();
		}
	}


}
