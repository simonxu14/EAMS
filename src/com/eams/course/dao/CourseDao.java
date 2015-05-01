package com.eams.course.dao;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;

public interface CourseDao {
	public List<CourseInfo> queryAllCourses();
	
	public void addCourse(CourseInfo course);
	
	public List<TeachInfo> queryAllTeachInfo();
	
	public void deleteCourse(CourseInfo courseDel);
	
	public CourseInfo queryCourseById(int id);
	
	public void updateCourseInfo(CourseInfo courseUpdate);
	
	public List<CourseInfo> queryCourseByTeacherId(int id);
	
	public TeachInfo queryTeacherById(int id);
}
