package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.ClassInfoDao;
import com.eams.admin.service.ClassInfoService;
import com.eams.model.ClassInfo;

public class ClassInfoServiceImpl implements ClassInfoService {
	private ClassInfoDao classInfoDao;
    
	public ClassInfoDao getClassInfoDao() {
		return classInfoDao;
	}

	public void setClassInfoDao(ClassInfoDao classInfoDao) {
		this.classInfoDao = classInfoDao;
	}

	@Override
	public List<ClassInfo> queryAllClassInfo() {
		return classInfoDao.queryAll();
	}

	@Override
	public boolean addClassInfo(ClassInfo classInfo) {
		if(classInfoDao.add(classInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealClassInfo(Integer classId) {
		if(classInfoDao.deleteReal(classId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public ClassInfo forUpdateClassInfo(Integer classId) {
		ClassInfo classInfo = classInfoDao.queryById(classId);
		return classInfo;
	}

	@Override
	public boolean updateClassInfo(ClassInfo classInfo) {
			try {
				classInfoDao.update(classInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<ClassInfo> queryRealAllClassInfo() {
		return classInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteClassInfo(Integer classId) {
		if(classInfoDao.delete(classId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public ClassInfo queryClassById(Integer classId) {
		ClassInfo classInfo = classInfoDao.queryById(classId);
		return classInfo;
	}

}
