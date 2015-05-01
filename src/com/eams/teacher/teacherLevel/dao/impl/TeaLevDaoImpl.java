package com.eams.teacher.teacherLevel.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.model.TeachLevel;
import com.eams.teacher.teacherLevel.dao.TeaLevDao;

public class TeaLevDaoImpl extends HibernateDaoSupport implements TeaLevDao{

	// �г����еȼ���Ϣ
	public List<TeachLevel> queryAllLevels() {
		List<TeachLevel> levels = getHibernateTemplate().find("from TeachLevel");
		return levels;
	}
	
	//�г���Чֵ(valid==1)Ϊ1�����еȼ���Ϣ
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
	
	//��ӽ�ʦ�ȼ�
	public void addLevel(TeachLevel teacherLevel) {	
		teacherLevel.setTeachLevelValid(true);
		this.getHibernateTemplate().save(teacherLevel);
		}
	
	//ɾ����ʦ�ȼ�
	public boolean deleteLevel(int id){
		TeachLevel teacherLevel=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		getHibernateTemplate().delete(teacherLevel);
		return true;
	}
	
	//��ɾ����������ǰ̨���û���ʾ����ʵ�ʱ��������ݿ��е����ݣ�
	public boolean deleteLevelV(int id) {
		TeachLevel teacherLevel=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		//������ЧλΪ0����Ч��
		
		teacherLevel.setTeachLevelValid(false);
		this.getHibernateTemplate().update(teacherLevel);
		return true;
	}
	
	
	//��ID�Ų�ѯ��ʦ�ȼ�
	public TeachLevel queryById(int id) {
		TeachLevel t=(TeachLevel)this.getHibernateTemplate().get(TeachLevel.class,id);
		return t;
	}

	//�޸Ľ�ʦ�ȼ���Ϣ
	public boolean updateLevel(TeachLevel teacherLevel) {
		this.getHibernateTemplate().update(teacherLevel);
		return true;
	}

	public List<TeachLevel> queryTeachLevel() {
		List<TeachLevel> info =getHibernateTemplate().find("from TeachLevel");
		return info;
	}
	
}