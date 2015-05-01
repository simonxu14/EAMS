package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.OrgInfoDao;
import com.eams.admin.service.OrgInfoService;
import com.eams.model.OrgInfo;

public class OrgInfoServiceImpl implements OrgInfoService {
	private OrgInfoDao orgInfoDao;
    
	public OrgInfoDao getOrgInfoDao() {
		return orgInfoDao;
	}

	public void setOrgInfoDao(OrgInfoDao orgInfoDao) {
		this.orgInfoDao = orgInfoDao;
	}

	@Override
	public List<OrgInfo> queryAllOrgInfo() {
		return orgInfoDao.queryAll();
	}

	@Override
	public boolean addOrgInfo(OrgInfo orgInfo) {
		if(orgInfoDao.add(orgInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealOrgInfo(Integer orgId) {
		if(orgInfoDao.deleteReal(orgId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public OrgInfo forUpdateOrgInfo(Integer orgId) {
		OrgInfo orgInfo = orgInfoDao.queryById(orgId);
		return orgInfo;
	}
	
	public OrgInfo queryOrgById(Integer orgId) {
		OrgInfo orgInfo = orgInfoDao.queryById(orgId);
		return orgInfo;
	}

	@Override
	public boolean updateOrgInfo(OrgInfo orgInfo) {
			try {
				orgInfoDao.update(orgInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<OrgInfo> queryRealAllOrgInfo() {
		return orgInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteOrgInfo(Integer orgId) {
		if(orgInfoDao.delete(orgId)){
			return true;
		}
		else
			return false;
	}

}
