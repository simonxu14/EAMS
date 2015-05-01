package com.eams.teacher.teacherLevel.service;

import java.util.List;

import com.eams.model.TeachLevel;



public interface TeaLevService {

	public List<TeachLevel> queryAllLevels();
	
	public boolean addLevel(TeachLevel teacherLevel);
	
	public boolean deleteLevel(int id);
	
	public boolean deleteLevelV(int id);
	
	public TeachLevel queryById(int id);
	
	public boolean updateLevel(TeachLevel teacherLevel);
	
	public List<TeachLevel> queryAllLevelsV();
	public List<TeachLevel> queryTeachLevel();
}
