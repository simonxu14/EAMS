package com.eams.admin.dao;

import java.util.List;

import com.eams.model.PowerInfo;

public interface PowerInfoDao {

	public List<PowerInfo> queryAll();

	public boolean add(PowerInfo powerInfo);

	public boolean deleteReal(Integer powerId);

	public PowerInfo queryById(Integer powerId);

	public void update(PowerInfo powerInfo);

	public List<PowerInfo> queryRealAll();

	public boolean delete(Integer powerId);

}
