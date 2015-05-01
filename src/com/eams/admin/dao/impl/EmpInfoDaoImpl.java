package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.EmpInfoDao;
import com.eams.model.EmpInfo;

public class EmpInfoDaoImpl extends HibernateDaoSupport implements EmpInfoDao {

	@Override
	public List<EmpInfo> queryRealAll() {
		List<EmpInfo> empInfo = getHibernateTemplate().find("from empInfo");
		return empInfo;
	}

	@Override
	public boolean add(EmpInfo empInfo) {
		empInfo.setEmpValid(true);
		this.getHibernateTemplate().save(empInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer empId) {
		EmpInfo empInfo=(EmpInfo)this.getHibernateTemplate().get(EmpInfo.class,empId);
		getHibernateTemplate().delete(empInfo);
		return true;
	}

	@Override
	public EmpInfo queryById(Integer empId) {
		EmpInfo empInfo=(EmpInfo)this.getHibernateTemplate().get(EmpInfo.class,empId);
		return empInfo;
	}

	@Override
	public void update(EmpInfo empInfo) {
		empInfo.setEmpValid(true);
		this.getHibernateTemplate().update(empInfo);
	}

	@Override
	public List<EmpInfo> queryAll() {
		List<EmpInfo> empInfo = getHibernateTemplate().find("from EmpInfo");
		int i;
		for(i=0;i<empInfo.size();i++){
			if(empInfo.get(i).getEmpValid() == false){
				System.out.println(empInfo.get(i).getEmpName());
				empInfo.remove(i);
				i = i-1;
			}
		}
		return empInfo;
	}

	@Override
	public boolean delete(Integer empId) {
		EmpInfo empInfo=(EmpInfo)this.getHibernateTemplate().get(EmpInfo.class,empId);
		empInfo.setEmpValid(false);
		return true;
	}

	@Override
	public EmpInfo queryByAccount(String empAccount) {
		List<EmpInfo> empInfo = getHibernateTemplate().find("from EmpInfo emp where emp.empAccount=?",empAccount);
		System.out.println(empInfo.get(0).getEmpName());
		return empInfo.get(0);
	}

}
