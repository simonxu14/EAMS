package com.eams.teacher.teacherInfo.dao;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;

public interface TeaInfoDao {
	
	public List<TeachInfo> queryAllInfo();
	
	public List<TeachInfo> queryAllInfoV();
	
	public void addTeacherInfo(TeachInfo teacherInfo);
	
	public boolean deleteTeacherInfo(int id);
	
	public boolean deleteTeacherInfoV(int id);
	
	public TeachInfo queryById(int id);
	
	public boolean updateTeaInfo(TeachInfo teacherInfo);
	
	public List<TeachLevel> queryTeachLevel();
	
	public TeachInfo checkTeacher(TeachInfo teacherInfo);

	public TeachInfo queryTeacherById(TeachInfo teachInfo);
	
	public List<TeachLevel> queryAllLevelsV();
	
	
	public List<CourseInfo> queryCourseByTeacherId(int id);

	public List<CourseInfo> queryAllCourses();

}
