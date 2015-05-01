package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.EmpInfoDao;
import com.eams.admin.service.EmpInfoService;
import com.eams.model.EmpInfo;

public class EmpInfoServiceImpl implements EmpInfoService {
	private EmpInfoDao empInfoDao;
    
	public EmpInfoDao getEmpInfoDao() {
		return empInfoDao;
	}

	public void setEmpInfoDao(EmpInfoDao empInfoDao) {
		this.empInfoDao = empInfoDao;
	}

	@Override
	public List<EmpInfo> queryAllEmpInfo() {
		return empInfoDao.queryAll();
	}

	@Override
	public boolean addEmpInfo(EmpInfo empInfo) {
		if(empInfoDao.add(empInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealEmpInfo(Integer empId) {
		if(empInfoDao.deleteReal(empId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public EmpInfo forUpdateEmpInfo(Integer empId) {
		EmpInfo empInfo = empInfoDao.queryById(empId);
		return empInfo;
	}

	@Override
	public boolean updateEmpInfo(EmpInfo empInfo) {
			try {
				empInfoDao.update(empInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<EmpInfo> queryRealAllEmpInfo() {
		return empInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteEmpInfo(Integer empId) {
		if(empInfoDao.delete(empId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public EmpInfo queryEmpById(Integer empId) {
		EmpInfo empInfo = empInfoDao.queryById(empId);
		return empInfo;
	}

	@Override
	public EmpInfo checkEmpInfo(String empAccount) {
		EmpInfo empInfo = empInfoDao.queryByAccount(empAccount);
		return empInfo;
	}

}
