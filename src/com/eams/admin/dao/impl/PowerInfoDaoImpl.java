package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.PowerInfoDao;
import com.eams.model.PowerInfo;

public class PowerInfoDaoImpl extends HibernateDaoSupport implements PowerInfoDao {

	@Override
	public List<PowerInfo> queryRealAll() {
		List<PowerInfo> powerInfo = getHibernateTemplate().find("from PowerInfo");
		return powerInfo;
	}

	@Override
	public boolean add(PowerInfo powerInfo) {
		//设置有效位都是1（有效）
		powerInfo.setPowerValid(true);
		this.getHibernateTemplate().save(powerInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer powerId) {
		PowerInfo powerInfo=(PowerInfo)this.getHibernateTemplate().get(PowerInfo.class,powerId);
		getHibernateTemplate().delete(powerInfo);
		return true;
	}

	@Override
	public PowerInfo queryById(Integer powerId) {
		PowerInfo powerInfo=(PowerInfo)this.getHibernateTemplate().get(PowerInfo.class,powerId);
		return powerInfo;
	}

	@Override
	public void update(PowerInfo powerInfo) {
		powerInfo.setPowerValid(true);
		this.getHibernateTemplate().update(powerInfo);
	}

	@Override
	//查询所有valid是1（有效）的字段
	public List<PowerInfo> queryAll() {
		List<PowerInfo> powerInfo = getHibernateTemplate().find("from PowerInfo");
		int i;
		for(i=0;i<powerInfo.size();i++){
			if(powerInfo.get(i).getPowerValid() == false){
				System.out.println(powerInfo.get(i).getPowerName());
				powerInfo.remove(i);
				i = i-1;
			}
		}
		return powerInfo;
	}

	@Override
	public boolean delete(Integer powerId) {
		PowerInfo powerInfo=(PowerInfo)this.getHibernateTemplate().get(PowerInfo.class,powerId);
		//设置有效位为0（无效）
		powerInfo.setPowerValid(false);
		return true;
	}

}
