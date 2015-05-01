package com.eams.admin.dao;

import java.util.List;

import com.eams.model.OrgInfo;

public interface OrgInfoDao {

	public List<OrgInfo> queryAll();

	public boolean add(OrgInfo orgInfo);

	public boolean deleteReal(Integer orgId);

	public OrgInfo queryById(Integer orgId);

	public void update(OrgInfo orgInfo);

	public List<OrgInfo> queryRealAll();

	public boolean delete(Integer orgId);

}
