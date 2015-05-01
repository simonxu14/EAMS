package com.eams.teacher.teacherLevel.service.impl;

import java.util.List;

import com.eams.model.TeachLevel;
import com.eams.teacher.teacherLevel.dao.TeaLevDao;
import com.eams.teacher.teacherLevel.service.TeaLevService;

public class TeaLevServiceImpl implements TeaLevService {

	private TeaLevDao teaLevDao;

	public TeaLevDao getTeaLevDao() {
		return teaLevDao;
	}

	public void setTeaLevDao(TeaLevDao teaLevDao) {
		this.teaLevDao = teaLevDao;
	}

	public List<TeachLevel> queryAllLevels() {
		return teaLevDao.queryAllLevels();
	}
	
	public List<TeachLevel> queryAllLevelsV() {
		return teaLevDao.queryAllLevelsV();
	}

	public boolean addLevel(TeachLevel teacherLevel){
		try{
			teaLevDao.addLevel(teacherLevel);
		}catch (Exception e){
			return false;
		}
		return true;
	}

	public boolean deleteLevel(int id) {
		if(teaLevDao.deleteLevel(id)){
			return true;
		}
		return false;
	}
	
	public boolean deleteLevelV(int id) {
		if(teaLevDao.deleteLevelV(id)){
			return true;
		}
		return false;
	}

	public TeachLevel queryById(int id) {
		return teaLevDao.queryById(id);
	}

	public boolean updateLevel(TeachLevel teacherLevel) {
		if(teaLevDao.updateLevel(teacherLevel)){
			return true;
		}
		return false;
	}

	public List<TeachLevel> queryTeachLevel() {
		return teaLevDao.queryTeachLevel();
	}



	
}
