package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.ScheduleInfoDao;
import com.eams.admin.service.ScheduleInfoService;
import com.eams.model.ScheduleInfo;

public class ScheduleInfoServiceImpl implements ScheduleInfoService {
	private ScheduleInfoDao scheduleInfoDao;
    
	public ScheduleInfoDao getScheduleInfoDao() {
		return scheduleInfoDao;
	}

	public void setScheduleInfoDao(ScheduleInfoDao scheduleInfoDao) {
		this.scheduleInfoDao = scheduleInfoDao;
	}

	@Override
	public List<ScheduleInfo> queryAllScheduleInfo() {
		return scheduleInfoDao.queryAll();
	}

	@Override
	public boolean addScheduleInfo(ScheduleInfo scheduleInfo) {
		if(scheduleInfoDao.add(scheduleInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealScheduleInfo(Integer scheduleId) {
		if(scheduleInfoDao.deleteReal(scheduleId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public ScheduleInfo forUpdateScheduleInfo(Integer scheduleId) {
		ScheduleInfo scheduleInfo = scheduleInfoDao.queryById(scheduleId);
		return scheduleInfo;
	}

	@Override
	public boolean updateScheduleInfo(ScheduleInfo scheduleInfo) {
			try {
				scheduleInfoDao.update(scheduleInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<ScheduleInfo> queryRealAllScheduleInfo() {
		return scheduleInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteScheduleInfo(Integer scheduleId) {
		if(scheduleInfoDao.delete(scheduleId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public ScheduleInfo queryScheduleById(Integer scheduleId) {
		ScheduleInfo scheduleInfo = scheduleInfoDao.queryById(scheduleId);
		return scheduleInfo;
	}



	@Override
	public List<ScheduleInfo> queryMyScheduleInfo(Integer integer) {
		return scheduleInfoDao.queryByFK(integer);
	}

}
