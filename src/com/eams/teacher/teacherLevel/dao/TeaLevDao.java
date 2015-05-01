package com.eams.teacher.teacherLevel.dao;

import java.util.List;

import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;

public interface TeaLevDao {

	public List<TeachLevel> queryAllLevels();
	
	public List<TeachLevel> queryAllLevelsV();
	
	public void addLevel(TeachLevel teacherLevel);

	public boolean deleteLevel(int id);
	
	public boolean deleteLevelV(int id);
	
	public TeachLevel queryById(int id);
	
	public boolean updateLevel(TeachLevel teacherLevel);

	public List<TeachLevel> queryTeachLevel();
	
}
