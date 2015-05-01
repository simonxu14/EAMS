package com.eams.admin.dao;

import java.util.List;

import com.eams.model.DepInfo;

public interface DepInfoDao {

	public List<DepInfo> queryAll();

	public boolean add(DepInfo depInfo);

	public boolean deleteReal(Integer depId);

	public DepInfo queryById(Integer depId);

	public void update(DepInfo depInfo);

	public List<DepInfo> queryRealAll();

	public boolean delete(Integer depId);

}
