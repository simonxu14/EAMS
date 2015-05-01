package com.eams.course.service;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;

public interface CourseService {
	public List<CourseInfo> queryAllCourses();
	
	public int addCourse(CourseInfo course);
	
	public List<TeachInfo> queryAllTeachInfo();
	
	public void deleteCourse(CourseInfo courseDel);
	
	public CourseInfo queryCourseById(int id);
	
	public int updateCourseInfo(CourseInfo courseUpdate);
	
	public List<CourseInfo> queryCourseByTeacherId(int id);
	
	public int CheckCourseConflict(CourseInfo course);
}
