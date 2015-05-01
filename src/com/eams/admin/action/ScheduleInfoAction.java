package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.ScheduleInfoService;
import com.eams.model.ScheduleInfo;
import com.eams.model.EmpInfo;
import com.eams.admin.service.EmpInfoService;
import com.opensymphony.xwork2.ActionContext;

public class ScheduleInfoAction {
	private ScheduleInfoService scheduleInfoService;
	private EmpInfoService empInfoService;
	private EmpInfo empInfo;
	private ScheduleInfo scheduleInfo;
	private Map<String,Object> request;
	private Map<String,Object> request_emp;
	
	
	
	public EmpInfoService getEmpInfoService() {
		return empInfoService;
	}
	public void setEmpInfoService(EmpInfoService empInfoService) {
		this.empInfoService = empInfoService;
	}
	public EmpInfo getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}
	public Map<String, Object> getRequest_emp() {
		return request_emp;
	}
	public void setRequest_emp(Map<String, Object> request_emp) {
		this.request_emp = request_emp;
	}
	
	
	public ScheduleInfoService getScheduleInfoService() {
		return scheduleInfoService;
	}
	public void setScheduleInfoService(ScheduleInfoService scheduleInfoService) {
		this.scheduleInfoService = scheduleInfoService;
	}
	public ScheduleInfo getScheduleInfo() {
		return scheduleInfo;
	}
	public void setScheduleInfo(ScheduleInfo scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	public void list(){
		List<ScheduleInfo> list = scheduleInfoService.queryAllScheduleInfo();
		request = (Map)ActionContext.getContext().get("request");
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getEmpInfo().getEmpName());
		request.put("allScheduleInfo", list);
	}
	
	public void list_emp(){
		List<EmpInfo> list_emp = empInfoService.queryAllEmpInfo();
		request_emp = (Map)ActionContext.getContext().get("request");
		request_emp.put("allEmpInfo", list_emp);
	}
	
	public void realList(){
		List<ScheduleInfo> list = scheduleInfoService.queryRealAllScheduleInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allScheduleInfo", list);
	}
	
	public String showScheduleInfo(){
		list();
		return "showscheduleinfo";
	}
	
	public String showRealScheduleInfo(){
		realList();
		return "showscheduleinfo";
	}
	
	public String forAddScheduleInfo(){
		list_emp();
		return "addscheduleinfo";
	}
	
	//转换empInfo.empName成完整empInfo类型
	public void exchange(){
		System.out.println(scheduleInfo.getEmpInfo().getEmpId());
		empInfo = empInfoService.queryEmpById(scheduleInfo.getEmpInfo().getEmpId());
	}
	
	public String addScheduleInfo(){
		exchange();
		if(scheduleInfoService.addScheduleInfo(scheduleInfo)){
			list();
			return "showscheduleinfo";
		}
		else
			return "scheduleinfofalse";
	}
	
	public String deleteScheduleInfo(){
		if(scheduleInfoService.deleteScheduleInfo(scheduleInfo.getSchId())){
			list();
			return "showscheduleinfo";
		}
		else
			return "scheduleinfofalse";
	}
	
	public String delectRealScheduleInfo(){
		if(scheduleInfoService.deleteRealScheduleInfo(scheduleInfo.getSchId())){
			realList();
			return "showscheduleinfo";
		}
		else
			return "scheduleinfofalse";
	}
	
	public String updateScheduleInfo(){
		exchange();
		if(scheduleInfoService.updateScheduleInfo(scheduleInfo)){
			list();
			return "showscheduleinfo";
		}
		else
			return "scheduleinfofalse";
	}
	
	public String forUpdateScheduleInfo(){
		scheduleInfo = scheduleInfoService.forUpdateScheduleInfo(scheduleInfo.getSchId());
		if(scheduleInfo != null){
			list_emp();
			return "updatescheduleinfo";
		}
		else
			return "scheduleinfofalse";
	}
	
	public String checkScheduleInfo(){
		return null;
	}

	public String schedulePage(){
		list();
		return "schedulepage";
	}
	
	public String mySchedulePage(){
		List<ScheduleInfo> list = scheduleInfoService.queryMyScheduleInfo(scheduleInfo.getEmpInfo().getEmpId());
		request = (Map)ActionContext.getContext().get("request");
		request.put("myScheduleInfo", list);
		return "myschedulepage";
	}
	
	
	
	public String myAddScheduleInfo(){
		exchange();
		if(scheduleInfoService.addScheduleInfo(scheduleInfo)){
			List<ScheduleInfo> list = scheduleInfoService.queryMyScheduleInfo(scheduleInfo.getEmpInfo().getEmpId());
			request = (Map)ActionContext.getContext().get("request");
			request.put("myScheduleInfo", list);
			return "myschedulepage";
		}
		else
			return "scheduleinfofalse";
	}
	
	
	
	
	
}
