package com.eams.admin.service;

import java.util.List;

import com.eams.model.CheckInfo;

public interface CheckInfoService {

	public List<CheckInfo> queryAllCheckInfo();

	public boolean addCheckInfo(CheckInfo checkInfo);

	public boolean deleteRealCheckInfo(Integer checkId);

	public CheckInfo forUpdateCheckInfo(Integer checkId);

	public boolean updateCheckInfo(CheckInfo checkInfo);

	public List<CheckInfo> queryRealAllCheckInfo();

	public boolean deleteCheckInfo(Integer checkId);

	public CheckInfo queryCheckById(Integer checkId);

}
