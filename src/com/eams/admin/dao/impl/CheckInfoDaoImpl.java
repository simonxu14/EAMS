package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.CheckInfoDao;
import com.eams.model.CheckInfo;

public class CheckInfoDaoImpl extends HibernateDaoSupport implements CheckInfoDao {

	@Override
	public List<CheckInfo> queryRealAll() {
		List<CheckInfo> checkInfo = getHibernateTemplate().find("from checkInfo");
		return checkInfo;
	}

	@Override
	public boolean add(CheckInfo checkInfo) {
/*		checkInfo.setCheckValid(true);*/
		this.getHibernateTemplate().save(checkInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer checkId) {
		CheckInfo checkInfo=(CheckInfo)this.getHibernateTemplate().get(CheckInfo.class,checkId);
		getHibernateTemplate().delete(checkInfo);
		return true;
	}

	@Override
	public CheckInfo queryById(Integer checkId) {
		CheckInfo checkInfo=(CheckInfo)this.getHibernateTemplate().get(CheckInfo.class,checkId);
		return checkInfo;
	}

	@Override
	public void update(CheckInfo checkInfo) {
/*		checkInfo.setCheckValid(true);*/
		this.getHibernateTemplate().update(checkInfo);
	}

	@Override
	public List<CheckInfo> queryAll() {
		List<CheckInfo> checkInfo = getHibernateTemplate().find("from CheckInfo");
/*		int i;
		for(i=0;i<checkInfo.size();i++){
			if(checkInfo.get(i).getCheckValid() == false){
				checkInfo.remove(i);
				i = i-1;
			}
		}*/
		return checkInfo;
	}

	@Override
	public boolean delete(Integer checkId) {
		CheckInfo checkInfo=(CheckInfo)this.getHibernateTemplate().get(CheckInfo.class,checkId);
/*		checkInfo.setCheckValid(false);*/
		getHibernateTemplate().delete(checkInfo);
		return true;
	}

}
