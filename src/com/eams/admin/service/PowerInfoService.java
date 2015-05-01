package com.eams.admin.service;

import java.util.List;

import com.eams.model.PowerInfo;

public interface PowerInfoService {

	public List<PowerInfo> queryAllPowerInfo();

	public boolean addPowerInfo(PowerInfo powerInfo);

	public boolean deleteRealPowerInfo(Integer powerId);

	public PowerInfo forUpdatePowerInfo(Integer powerId);

	public boolean updatePowerInfo(PowerInfo powerInfo);

	public List<PowerInfo> queryRealAllPowerInfo();

	public boolean deletePowerInfo(Integer powerId);
	
	public PowerInfo queryPowerById(Integer powerId);

}
