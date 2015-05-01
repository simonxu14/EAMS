package com.eams.admin.dao;

import java.util.List;

import com.eams.model.EmpInfo;

public interface EmpInfoDao {

	public List<EmpInfo> queryAll();

	public boolean add(EmpInfo empInfo);

	public boolean deleteReal(Integer empId);

	public EmpInfo queryById(Integer empId);

	public void update(EmpInfo empInfo);

	public List<EmpInfo> queryRealAll();

	public boolean delete(Integer empId);

	public EmpInfo queryByAccount(String empAccount);

}
