package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.GradeInfoDao;
import com.eams.model.GradeInfo;

public class GradeInfoDaoImpl extends HibernateDaoSupport implements GradeInfoDao {

	@Override
	public List<GradeInfo> queryRealAll() {
		List<GradeInfo> gradeInfo = getHibernateTemplate().find("from GradeInfo");
		return gradeInfo;
	}

	@Override
	public boolean add(GradeInfo gradeInfo) {
		//设置有效位都是1（有效）
		gradeInfo.setGradeValid(true);
		this.getHibernateTemplate().save(gradeInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer gradeId) {
		GradeInfo gradeInfo=(GradeInfo)this.getHibernateTemplate().get(GradeInfo.class,gradeId);
		getHibernateTemplate().delete(gradeInfo);
		return true;
	}

	@Override
	public GradeInfo queryById(Integer gradeId) {
		GradeInfo gradeInfo=(GradeInfo)this.getHibernateTemplate().get(GradeInfo.class,gradeId);
		return gradeInfo;
	}

	@Override
	public void update(GradeInfo gradeInfo) {
		gradeInfo.setGradeValid(true);
		this.getHibernateTemplate().update(gradeInfo);
	}

	@Override
	//查询所有valid是1（有效）的字段
	public List<GradeInfo> queryAll() {
		List<GradeInfo> gradeInfo = getHibernateTemplate().find("from GradeInfo");
		int i;
		for(i=0;i<gradeInfo.size();i++){
			if(gradeInfo.get(i).getGradeValid() == false){
				System.out.println(gradeInfo.get(i).getGradeName());
				gradeInfo.remove(i);
				i = i-1;
			}
		}
		return gradeInfo;
	}

	@Override
	public boolean delete(Integer gradeId) {
		GradeInfo gradeInfo=(GradeInfo)this.getHibernateTemplate().get(GradeInfo.class,gradeId);
		//设置有效位为0（无效）
		gradeInfo.setGradeValid(false);
		return true;
	}

}
