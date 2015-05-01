package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.DepInfoDao;
import com.eams.model.DepInfo;

public class DepInfoDaoImpl extends HibernateDaoSupport implements DepInfoDao {

	@Override
	public List<DepInfo> queryRealAll() {
		List<DepInfo> depInfo = getHibernateTemplate().find("from depInfo");
		return depInfo;
	}

	@Override
	public boolean add(DepInfo depInfo) {
		depInfo.setDepValid(true);
		this.getHibernateTemplate().save(depInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer depId) {
		DepInfo depInfo=(DepInfo)this.getHibernateTemplate().get(DepInfo.class,depId);
		getHibernateTemplate().delete(depInfo);
		return true;
	}

	@Override
	public DepInfo queryById(Integer depId) {
		DepInfo depInfo=(DepInfo)this.getHibernateTemplate().get(DepInfo.class,depId);
		return depInfo;
	}

	@Override
	public void update(DepInfo depInfo) {
		depInfo.setDepValid(true);
		this.getHibernateTemplate().update(depInfo);
	}

	@Override
	public List<DepInfo> queryAll() {
		List<DepInfo> depInfo = getHibernateTemplate().find("from DepInfo");
		int i;
		for(i=0;i<depInfo.size();i++){
			if(depInfo.get(i).getDepValid() == false){
				System.out.println(depInfo.get(i).getDepName());
				depInfo.remove(i);
				i = i-1;
			}
		}
		return depInfo;
	}

	@Override
	public boolean delete(Integer depId) {
		DepInfo depInfo=(DepInfo)this.getHibernateTemplate().get(DepInfo.class,depId);
		depInfo.setDepValid(false);
		return true;
	}

}
