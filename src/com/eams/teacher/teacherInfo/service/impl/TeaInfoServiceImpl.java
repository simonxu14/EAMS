package com.eams.teacher.teacherInfo.service.impl;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;
import com.eams.teacher.teacherInfo.dao.TeaInfoDao;
import com.eams.teacher.teacherInfo.service.TeaInfoService;

public class TeaInfoServiceImpl implements TeaInfoService{
	
	private TeaInfoDao teaInfoDao;

	public TeaInfoDao getTeaInfoDao() {
		return teaInfoDao;
	}



	public void setTeaInfoDao(TeaInfoDao teaInfoDao) {
		this.teaInfoDao = teaInfoDao;
	}



	public List<TeachInfo> queryAllInfo() {
		return teaInfoDao.queryAllInfo();
	}

	public List<TeachInfo> queryAllInfoV() {
		return teaInfoDao.queryAllInfoV();
	}


	public boolean addTeacherInfo(TeachInfo teacherInfo) {
		try{
			teaInfoDao.addTeacherInfo(teacherInfo);

			return true;
		}catch(Exception e){
			return false;
		}
	}



	public boolean deleteTeacherInfo(int id){
		if(teaInfoDao.deleteTeacherInfo(id)){
			return true;
		}
		return false;
	}

	public boolean deleteTeacherInfoV(int id) {
		if(teaInfoDao.deleteTeacherInfoV(id)){
			return true;
		}
		return false;
	}


	public TeachInfo queryById(int id) {
		return teaInfoDao.queryById(id);
	}



	public boolean updateTeaInfo(TeachInfo teacherInfo) {
		if(teaInfoDao.updateTeaInfo(teacherInfo)){
			return true;
		}
		return false;
	}



	public List<TeachLevel> queryTeachLevel() {
		return teaInfoDao.queryTeachLevel();
	}



	public TeachInfo checkTeacher(TeachInfo teacherInfo) {
		return teaInfoDao.checkTeacher(teacherInfo);
	}



	@Override
	public TeachInfo queryTeacherById(TeachInfo teachInfo) {
		return teaInfoDao.queryTeacherById(teachInfo);
	}



	@Override
	public List<CourseInfo> queryCourseByTeacherId(int i) {
		return teaInfoDao.queryCourseByTeacherId(i);
	}



	@Override
	public List<CourseInfo> queryAllCourses() {
		List<CourseInfo> allCourses = teaInfoDao.queryAllCourses();
		System.out.println("query all courses " + allCourses.size());
		for(int i = 0; i < allCourses.size(); i++){
			if(!allCourses.get(i).getCourseValid()){
				allCourses.remove(i);
				i--;
			}
		}
		System.out.println("query all courses " + allCourses.size());
		return allCourses;
	}
	
	public List<TeachLevel> queryAllLevelsV() {
		return teaInfoDao.queryAllLevelsV();
	}

}
