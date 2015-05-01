package com.eams.admin.service;

import java.util.List;

import com.eams.model.DepInfo;

public interface DepInfoService {

	public List<DepInfo> queryAllDepInfo();

	public boolean addDepInfo(DepInfo depInfo);

	public boolean deleteRealDepInfo(Integer depId);

	public DepInfo forUpdateDepInfo(Integer depId);

	public boolean updateDepInfo(DepInfo depInfo);

	public List<DepInfo> queryRealAllDepInfo();

	public boolean deleteDepInfo(Integer depId);

	public DepInfo queryDepById(Integer depId);

}
