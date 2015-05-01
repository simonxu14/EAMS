package com.eams.teacher.teacherInfo.service;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;

public interface TeaInfoService {
	
	public List<TeachInfo> queryAllInfo();
	
	public List<TeachInfo> queryAllInfoV();
	
	public boolean addTeacherInfo(TeachInfo teacherInfo);
	
	public boolean deleteTeacherInfo(int id);
	
	public boolean deleteTeacherInfoV(int id);

	public TeachInfo queryById(int id);
	
	public boolean updateTeaInfo(TeachInfo teacherInfo);
	
	public List<TeachLevel> queryTeachLevel();
	
	public TeachInfo checkTeacher(TeachInfo teacherInfo);

	public TeachInfo queryTeacherById(TeachInfo teachInfo);
	
	
	public List<CourseInfo> queryCourseByTeacherId(int i);

	public List<CourseInfo> queryAllCourses();
	
	public List<TeachLevel> queryAllLevelsV();
	
}
