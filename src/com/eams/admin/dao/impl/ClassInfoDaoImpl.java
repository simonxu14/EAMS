package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.ClassInfoDao;
import com.eams.model.ClassInfo;

public class ClassInfoDaoImpl extends HibernateDaoSupport implements ClassInfoDao {

	@Override
	public List<ClassInfo> queryRealAll() {
		List<ClassInfo> classInfo = getHibernateTemplate().find("from classInfo");
		return classInfo;
	}

	@Override
	public boolean add(ClassInfo classInfo) {
		classInfo.setClassValid(true);
		this.getHibernateTemplate().save(classInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer classId) {
		ClassInfo classInfo=(ClassInfo)this.getHibernateTemplate().get(ClassInfo.class,classId);
		getHibernateTemplate().delete(classInfo);
		return true;
	}

	@Override
	public ClassInfo queryById(Integer classId) {
		ClassInfo classInfo=(ClassInfo)this.getHibernateTemplate().get(ClassInfo.class,classId);
		return classInfo;
	}

	@Override
	public void update(ClassInfo classInfo) {
		classInfo.setClassValid(true);
		this.getHibernateTemplate().update(classInfo);
	}

	@Override
	public List<ClassInfo> queryAll() {
		List<ClassInfo> classInfo = getHibernateTemplate().find("from ClassInfo");
		int i;
		for(i=0;i<classInfo.size();i++){
			if(classInfo.get(i).getClassValid() == false){
				System.out.println(classInfo.get(i).getClassName());
				classInfo.remove(i);
				i = i-1;
			}
		}
		return classInfo;
	}

	@Override
	public boolean delete(Integer classId) {
		ClassInfo classInfo=(ClassInfo)this.getHibernateTemplate().get(ClassInfo.class,classId);
		classInfo.setClassValid(false);
		return true;
	}

}
