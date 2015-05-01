package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.GradeInfoService;
import com.eams.model.GradeInfo;
import com.opensymphony.xwork2.ActionContext;

public class GradeInfoAction {
	private GradeInfoService gradeInfoService;
	private GradeInfo gradeInfo;
	private Map<String,Object> request;
	
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
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public void list(){
		List<GradeInfo> list = gradeInfoService.queryAllGradeInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allGradeInfo", list);
	}
	
	public void realList(){
		List<GradeInfo> list = gradeInfoService.queryRealAllGradeInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allGradeInfo", list);
	}
	
	public String showGradeInfo(){
		list();
		return "showgradeinfo";
	}
	
	public String showRealGradeInfo(){
		realList();
		return "showgradeinfo";
	}
	
	public String addGradeInfo(){
		if(gradeInfoService.addGradeInfo(gradeInfo)){
			list();
			return "showgradeinfo";
		}
		else
			return "gradeinfofalse";
	}
	
	public String deleteGradeInfo(){
		if(gradeInfoService.deleteGradeInfo(gradeInfo.getGradeId())){
			list();
			return "showgradeinfo";
		}
		else
			return "gradeinfofalse";
	}
	
	public String delectRealGradeInfo(){
		if(gradeInfoService.deleteRealGradeInfo(gradeInfo.getGradeId())){
			realList();
			return "showgradeinfo";
		}
		else
			return "gradeinfofalse";
	}
	
	public String updateGradeInfo(){
		if(gradeInfoService.updateGradeInfo(gradeInfo)){
			list();
			return "showgradeinfo";
		}
		else
			return "gradeinfofalse";
	}
	
	public String forUpdateGradeInfo(){
		gradeInfo = gradeInfoService.forUpdateGradeInfo(gradeInfo.getGradeId());
		if(gradeInfo != null){
			return "updategradeinfo";
		}
		return "gradeinfofalse";
	}
	
	public String checkGradeInfo(){
		return null;
	}
	
	public String gradePage(){
		list();
		return "gradepage";
	}
	
}
