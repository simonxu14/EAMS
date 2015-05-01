package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.ScheduleInfoDao;
import com.eams.model.EmpInfo;
import com.eams.model.ScheduleInfo;

public class ScheduleInfoDaoImpl extends HibernateDaoSupport implements ScheduleInfoDao {

	@Override
	public List<ScheduleInfo> queryRealAll() {
		List<ScheduleInfo> scheduleInfo = getHibernateTemplate().find("from scheduleInfo");
		return scheduleInfo;
	}

	@Override
	public boolean add(ScheduleInfo scheduleInfo) {
		scheduleInfo.setSchValid(true);
		this.getHibernateTemplate().save(scheduleInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer scheduleId) {
		ScheduleInfo scheduleInfo=(ScheduleInfo)this.getHibernateTemplate().get(ScheduleInfo.class,scheduleId);
		getHibernateTemplate().delete(scheduleInfo);
		return true;
	}

	@Override
	public ScheduleInfo queryById(Integer scheduleId) {
		ScheduleInfo scheduleInfo=(ScheduleInfo)this.getHibernateTemplate().get(ScheduleInfo.class,scheduleId);
		return scheduleInfo;
	}

	@Override
	public void update(ScheduleInfo scheduleInfo) {
		scheduleInfo.setSchValid(true);
		this.getHibernateTemplate().update(scheduleInfo);
	}

	@Override
	public List<ScheduleInfo> queryAll() {
		List<ScheduleInfo> scheduleInfo = getHibernateTemplate().find("from ScheduleInfo");
		int i;
		for(i=0;i<scheduleInfo.size();i++){
			if(scheduleInfo.get(i).getSchValid() == false){
				scheduleInfo.remove(i);
				i = i-1;
			}
		}
		return scheduleInfo;
	}

	@Override
	public boolean delete(Integer scheduleId) {
		ScheduleInfo scheduleInfo=(ScheduleInfo)this.getHibernateTemplate().get(ScheduleInfo.class,scheduleId);
		scheduleInfo.setSchValid(false);
		return true;
	}
	
	public EmpInfo queryByAccount(String empAccount) {
		List<EmpInfo> empInfo = getHibernateTemplate().find("from EmpInfo emp where emp.empAccount=?",empAccount);
		System.out.println(empInfo.get(0).getEmpName());
		return empInfo.get(0);
	}

	@Override
	public List<ScheduleInfo> queryByFK(Integer empId) {
		List<ScheduleInfo> schedule = getHibernateTemplate().find("from ScheduleInfo sch where sch.empInfo.empId=?",empId);
		int i;
		for(i=0;i<schedule.size();i++){
			if(schedule.get(i).getSchValid() == false){
				schedule.remove(i);
				i = i-1;
			}
		}
		return schedule;
	}

}
