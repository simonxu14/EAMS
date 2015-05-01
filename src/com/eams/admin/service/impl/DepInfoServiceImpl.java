package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.DepInfoDao;
import com.eams.admin.service.DepInfoService;
import com.eams.model.DepInfo;

public class DepInfoServiceImpl implements DepInfoService {
	private DepInfoDao depInfoDao;
    
	public DepInfoDao getDepInfoDao() {
		return depInfoDao;
	}

	public void setDepInfoDao(DepInfoDao depInfoDao) {
		this.depInfoDao = depInfoDao;
	}

	@Override
	public List<DepInfo> queryAllDepInfo() {
		return depInfoDao.queryAll();
	}

	@Override
	public boolean addDepInfo(DepInfo depInfo) {
		if(depInfoDao.add(depInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealDepInfo(Integer depId) {
		if(depInfoDao.deleteReal(depId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public DepInfo forUpdateDepInfo(Integer depId) {
		DepInfo depInfo = depInfoDao.queryById(depId);
		return depInfo;
	}

	@Override
	public boolean updateDepInfo(DepInfo depInfo) {
			try {
				depInfoDao.update(depInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<DepInfo> queryRealAllDepInfo() {
		return depInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteDepInfo(Integer depId) {
		if(depInfoDao.delete(depId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public DepInfo queryDepById(Integer depId) {
		DepInfo depInfo = depInfoDao.queryById(depId);
		return depInfo;
	}

}
