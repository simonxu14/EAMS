package com.eams.admin.dao;

import java.util.List;

import com.eams.model.ScheduleInfo;

public interface ScheduleInfoDao {

	public List<ScheduleInfo> queryAll();

	public boolean add(ScheduleInfo scheduleInfo);

	public boolean deleteReal(Integer scheduleId);

	public ScheduleInfo queryById(Integer scheduleId);

	public void update(ScheduleInfo scheduleInfo);

	public List<ScheduleInfo> queryRealAll();

	public boolean delete(Integer scheduleId);

	public List<ScheduleInfo> queryByFK(Integer integer);

}
