package com.eams.teacher.teacherLevel.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.model.TeachLevel;
import com.eams.teacher.teacherLevel.dao.TeaLevDao;

public class TeaLevDaoImpl extends HibernateDaoSupport implements TeaLevDao{

	// 列出所有等级信息
	public List<TeachLevel> queryAllLevels() {
		List<TeachLevel> levels = getHibernateTemplate().find("from TeachLevel");
		return levels;
	}
	
	//列出有效值(valid==1)为1的所有等级信息
	public List<TeachLevel> queryAllLevelsV() {
		List<TeachLevel> levels = getHibernateTemplate().find("from TeachLevel");
		int i;
		for(i=0;i<levels.size();i++){
			if(levels.get(i).getTeachLevelValid() == false){
				System.out.println(levels.get(i).getTeachLevelName());
				levels.remove(i);
				i = i-1;
			}
		}
		return levels;
	}
	
	//添加教师等级
	public void addLevel(TeachLevel teacherLevel) {	
		teacherLevel.setTeachLevelValid(true);
		this.getHibernateTemplate().save(teacherLevel);
		}
	
	//删除教师等级
	public boolean deleteLevel(int id){
		TeachLevel teacherLevel=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		getHibernateTemplate().delete(teacherLevel);
		return true;
	}
	
	//假删除（即不在前台对用户显示，但实际保存于数据库中的数据）
	public boolean deleteLevelV(int id) {
		TeachLevel teacherLevel=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		//设置有效位为0（无效）
		
		teacherLevel.setTeachLevelValid(false);
		this.getHibernateTemplate().update(teacherLevel);
		return true;
	}
	
	
	//按ID号查询教师等级
	public TeachLevel queryById(int id) {
		TeachLevel t=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		return t;
	}

	//修改教师等级信息
	public boolean updateLevel(TeachLevel teacherLevel) {
		this.getHibernateTemplate().update(teacherLevel);
		return true;
	}

	public List<TeachLevel> queryTeachLevel() {
		List<TeachLevel> info =getHibernateTemplate().find("from TeachLevel");
		return info;
	}
	
}