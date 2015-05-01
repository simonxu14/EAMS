package com.eams.admin.dao;

import java.util.List;

import com.eams.model.CheckInfo;

public interface CheckInfoDao {

	public List<CheckInfo> queryAll();

	public boolean add(CheckInfo checkInfo);

	public boolean deleteReal(Integer checkId);

	public CheckInfo queryById(Integer checkId);

	public void update(CheckInfo checkInfo);

	public List<CheckInfo> queryRealAll();

	public boolean delete(Integer checkId);

}
