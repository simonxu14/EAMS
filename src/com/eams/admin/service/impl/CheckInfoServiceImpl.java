package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.CheckInfoDao;
import com.eams.admin.service.CheckInfoService;
import com.eams.model.CheckInfo;

public class CheckInfoServiceImpl implements CheckInfoService {
	private CheckInfoDao checkInfoDao;
    
	public CheckInfoDao getCheckInfoDao() {
		return checkInfoDao;
	}

	public void setCheckInfoDao(CheckInfoDao checkInfoDao) {
		this.checkInfoDao = checkInfoDao;
	}

	@Override
	public List<CheckInfo> queryAllCheckInfo() {
		return checkInfoDao.queryAll();
	}

	@Override
	public boolean addCheckInfo(CheckInfo checkInfo) {
		if(checkInfoDao.add(checkInfo)){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteRealCheckInfo(Integer checkId) {
		if(checkInfoDao.deleteReal(checkId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public CheckInfo forUpdateCheckInfo(Integer checkId) {
		CheckInfo checkInfo = checkInfoDao.queryById(checkId);
		return checkInfo;
	}

	@Override
	public boolean updateCheckInfo(CheckInfo checkInfo) {
			try {
				checkInfoDao.update(checkInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<CheckInfo> queryRealAllCheckInfo() {
		return checkInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteCheckInfo(Integer checkId) {
		if(checkInfoDao.delete(checkId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public CheckInfo queryCheckById(Integer checkId) {
		CheckInfo checkInfo = checkInfoDao.queryById(checkId);
		return checkInfo;
	}

}
