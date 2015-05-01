package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.PowerInfoDao;
import com.eams.admin.service.PowerInfoService;
import com.eams.model.PowerInfo;

public class PowerInfoServiceImpl implements PowerInfoService {
	private PowerInfoDao powerInfoDao;
    
	public PowerInfoDao getPowerInfoDao() {
		return powerInfoDao;
	}

	public void setPowerInfoDao(PowerInfoDao powerInfoDao) {
		this.powerInfoDao = powerInfoDao;
	}

	@Override
	public List<PowerInfo> queryAllPowerInfo() {
		return powerInfoDao.queryAll();
	}

	@Override
	public boolean addPowerInfo(PowerInfo powerInfo) {
		if(powerInfoDao.add(powerInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealPowerInfo(Integer powerId) {
		if(powerInfoDao.deleteReal(powerId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public PowerInfo forUpdatePowerInfo(Integer powerId) {
		PowerInfo powerInfo = powerInfoDao.queryById(powerId);
		return powerInfo;
	}
	
	public PowerInfo queryPowerById(Integer powerId) {
		PowerInfo powerInfo = powerInfoDao.queryById(powerId);
		return powerInfo;
	}

	@Override
	public boolean updatePowerInfo(PowerInfo powerInfo) {
			try {
				powerInfoDao.update(powerInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<PowerInfo> queryRealAllPowerInfo() {
		return powerInfoDao.queryRealAll();
	}

	@Override
	public boolean deletePowerInfo(Integer powerId) {
		if(powerInfoDao.delete(powerId)){
			return true;
		}
		else
			return false;
	}

}
