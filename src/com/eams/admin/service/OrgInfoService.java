package com.eams.admin.service;

import java.util.List;

import com.eams.model.OrgInfo;

public interface OrgInfoService {

	public List<OrgInfo> queryAllOrgInfo();

	public boolean addOrgInfo(OrgInfo orgInfo);

	public boolean deleteRealOrgInfo(Integer orgId);

	public OrgInfo forUpdateOrgInfo(Integer orgId);

	public boolean updateOrgInfo(OrgInfo orgInfo);

	public List<OrgInfo> queryRealAllOrgInfo();

	public boolean deleteOrgInfo(Integer orgId);
	
	public OrgInfo queryOrgById(Integer orgId);

}
