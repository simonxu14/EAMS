package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.ClassInfoService;
import com.eams.model.ClassInfo;
import com.eams.model.GradeInfo;
import com.eams.admin.service.GradeInfoService;
import com.opensymphony.xwork2.ActionContext;

public class ClassInfoAction {
	private ClassInfoService classInfoService;
	private GradeInfoService gradeInfoService;
	private GradeInfo gradeInfo;
	private ClassInfo classInfo;
	private Map<String,Object> request;
	private Map<String,Object> request_grade;
	
	
	
	public GradeInfoService getGradeInfoService() {
		return gradeInfoService;
	}
	public void setGradeInfoService(GradeInfoService gradeInfoService) {
		this.gradeInfoService = gradeInfoService;
	}
	public GradeInfo getGradeInfo() {
		return gradeInfo;
	}
	public void setGradeInfo(GradeInfo gradeInfo) {
		this.gradeInfo = gradeInfo;
	}
	public Map<String, Object> getRequest_grade() {
		return request_grade;
	}
	public void setRequest_grade(Map<String, Object> request_grade) {
		this.request_grade = request_grade;
	}
	
	
	public ClassInfoService getClassInfoService() {
		return classInfoService;
	}
	public void setClassInfoService(ClassInfoService classInfoService) {
		this.classInfoService = classInfoService;
	}
	public ClassInfo getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	public void list(){
		List<ClassInfo> list = classInfoService.queryAllClassInfo();
		request = (Map)ActionContext.getContext().get("request");
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getGradeInfo().getGradeName());
		request.put("allClassInfo", list);
	}
	
	public void list_grade(){
		List<GradeInfo> list_grade = gradeInfoService.queryAllGradeInfo();
		request_grade = (Map)ActionContext.getContext().get("request");
		request_grade.put("allGradeInfo", list_grade);
	}
	
	public void realList(){
		List<ClassInfo> list = classInfoService.queryRealAllClassInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allClassInfo", list);
	}
	
	public String showClassInfo(){
		list();
		return "showclassinfo";
	}
	
	public String showRealClassInfo(){
		realList();
		return "showclassinfo";
	}
	
	public String forAddClassInfo(){
		list_grade();
		return "addclassinfo";
	}
	
	//转换gradeInfo.gradeName成完整gradeInfo类型
	public void exchange(){
		System.out.println(classInfo.getGradeInfo().getGradeId());
		gradeInfo = gradeInfoService.queryGradeById(classInfo.getGradeInfo().getGradeId());
	}
	
	public String addClassInfo(){
		exchange();
		if(classInfoService.addClassInfo(classInfo)){
			list();
			return "showclassinfo";
		}
		else
			return "classinfofalse";
	}
	
	public String deleteClassInfo(){
		if(classInfoService.deleteClassInfo(classInfo.getClassId())){
			list();
			return "showclassinfo";
		}
		else
			return "classinfofalse";
	}
	
	public String delectRealClassInfo(){
		if(classInfoService.deleteRealClassInfo(classInfo.getClassId())){
			realList();
			return "showclassinfo";
		}
		else
			return "classinfofalse";
	}
	
	public String updateClassInfo(){
		exchange();
		if(classInfoService.updateClassInfo(classInfo)){
			list();
			return "showclassinfo";
		}
		else
			return "classinfofalse";
	}
	
	public String forUpdateClassInfo(){
		classInfo = classInfoService.forUpdateClassInfo(classInfo.getClassId());
		if(classInfo != null){
			list_grade();
			return "updateclassinfo";
		}
		else
			return "classinfofalse";
	}
	
	public String checkClassInfo(){
		return null;
	}
	
	public String classPage(){
		list();
		return "classpage";
	}
}
