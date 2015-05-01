package com.eams.teacher.teacherLevel.action;

import java.util.List;
import java.util.Map;

import com.eams.model.TeachLevel;
import com.eams.teacher.teacherLevel.service.TeaLevService;
import com.opensymphony.xwork2.ActionContext;

public class TeaLevAction {
	private TeaLevService teaLevService;
	private TeachLevel teacherLevel;
	private Map<String, Object> request;

	public TeaLevService getTeaLevService() {
		return teaLevService;
	}

	public TeachLevel getTeacherLevel() {
		return teacherLevel;
	}

	public void setTeacherLevel(TeachLevel teacherLevel) {
		this.teacherLevel = teacherLevel;
	}

	public void setTeaLevService(TeaLevService teaLevService) {
		this.teaLevService = teaLevService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String testList(){
		String i = hiddenList();
		return i;
	}
	
	
	public String list() {
		List list = teaLevService.queryAllLevels();
		request = (Map) ActionContext.getContext().get("request");
		request.put("levels", list);
		return "success";
	}
	
	public String hiddenList(){
		System.out.println("listcheck");
		List list = teaLevService.queryAllLevelsV();
		request = (Map) ActionContext.getContext().get("request");
		request.put("level", list);
		return "success";
	}
	
	public String addLevel(){
		boolean flag=teaLevService.addLevel(teacherLevel);

		if(flag){
			String i = hiddenList();
			return i;
		}else{
			return "add_default";
		}
	}
	
	public String deleteLevel(){
		teaLevService.deleteLevel(teacherLevel.getTeachLevelId());
			String i = list();
			return i;
	}
	
	public String hiddenDeleteLevel(){
		teaLevService.deleteLevelV(teacherLevel.getTeachLevelId());
		String i = hiddenList();
		return i;
	}
	
	public String updateLevel1(){
//		System.out.println("987654");
//		System.out.println(teacherLevel.getTeachLevelId());
		teacherLevel=teaLevService.queryById(teacherLevel.getTeachLevelId());
		List<TeachLevel> allLevel = teaLevService.queryTeachLevel();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allLevel", allLevel);
		return "update";
	}
	
	public String updateLevel2(){
		System.out.println("hahahahahahaha");
		System.out.println(teacherLevel.getTeachLevelId());
		teaLevService.updateLevel(teacherLevel);
		
		String i = hiddenList();
		return i;
	}
}
