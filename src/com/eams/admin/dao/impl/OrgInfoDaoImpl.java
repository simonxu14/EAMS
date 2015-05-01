package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.OrgInfoDao;
import com.eams.model.OrgInfo;

public class OrgInfoDaoImpl extends HibernateDaoSupport implements OrgInfoDao {

	@Override
	public List<OrgInfo> queryRealAll() {
		List<OrgInfo> orgInfo = getHibernateTemplate().find("from OrgInfo");
		return orgInfo;
	}

	@Override
	public boolean add(OrgInfo orgInfo) {
		//������Чλ����1����Ч��
		orgInfo.setOrgValid(true);
		this.getHibernateTemplate().save(orgInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer orgId) {
		OrgInfo orgInfo=(OrgInfo)this.getHibernateTemplate().get(OrgInfo.class,orgId);
		getHibernateTemplate().delete(orgInfo);
		return true;
	}

	@Override
	public OrgInfo queryById(Integer orgId) {
		OrgInfo orgInfo=(OrgInfo)this.getHibernateTemplate().get(OrgInfo.class,orgId);
		return orgInfo;
	}

	@Override
	public void update(OrgInfo orgInfo) {
		orgInfo.setOrgValid(true);
		this.getHibernateTemplate().update(orgInfo);
	}

	@Override
	//��ѯ����valid��1����Ч�����ֶ�
	public List<OrgInfo> queryAll() {
		List<OrgInfo> orgInfo = getHibernateTemplate().find("from OrgInfo");
		int i;
		for(i=0;i<orgInfo.size();i++){
			if(orgInfo.get(i).getOrgValid() == false){
				System.out.println(orgInfo.get(i).getOrgName());
				orgInfo.remove(i);
				i = i-1;
			}
		}
		return orgInfo;
	}

	@Override
	public boolean delete(Integer orgId) {
		OrgInfo orgInfo=(OrgInfo)this.getHibernateTemplate().get(OrgInfo.class,orgId);
		//������ЧλΪ0����Ч��
		orgInfo.setOrgValid(false);
		System.out.println("$$$$$$$$$");
		return true;
	}

}
