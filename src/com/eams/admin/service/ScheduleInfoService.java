package com.eams.admin.service;

import java.util.List;

import com.eams.model.ScheduleInfo;

public interface ScheduleInfoService {

	public List<ScheduleInfo> queryAllScheduleInfo();

	public boolean addScheduleInfo(ScheduleInfo scheduleInfo);

	public boolean deleteRealScheduleInfo(Integer scheduleId);

	public ScheduleInfo forUpdateScheduleInfo(Integer scheduleId);

	public boolean updateScheduleInfo(ScheduleInfo scheduleInfo);

	public List<ScheduleInfo> queryRealAllScheduleInfo();

	public boolean deleteScheduleInfo(Integer scheduleId);

	public ScheduleInfo queryScheduleById(Integer scheduleId);

	public List<ScheduleInfo> queryMyScheduleInfo(Integer integer);

}
