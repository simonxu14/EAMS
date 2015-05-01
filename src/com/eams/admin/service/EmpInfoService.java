package com.eams.admin.service;

import java.util.List;

import com.eams.model.EmpInfo;

public interface EmpInfoService {

	public List<EmpInfo> queryAllEmpInfo();

	public boolean addEmpInfo(EmpInfo empInfo);

	public boolean deleteRealEmpInfo(Integer empId);

	public EmpInfo forUpdateEmpInfo(Integer empId);

	public boolean updateEmpInfo(EmpInfo empInfo);

	public List<EmpInfo> queryRealAllEmpInfo();

	public boolean deleteEmpInfo(Integer empId);

	public EmpInfo queryEmpById(Integer empId);

	public EmpInfo checkEmpInfo(String empAccount);

}
