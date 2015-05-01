package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.OrgInfoService;
import com.eams.model.OrgInfo;
import com.opensymphony.xwork2.ActionContext;

public class OrgInfoAction {
	private OrgInfoService orgInfoService;
	private OrgInfo orgInfo;
	private Map<String,Object> request;
	
	public OrgInfoService getOrgInfoService() {
		return orgInfoService;
	}
	public void setOrgInfoService(OrgInfoService orgInfoService) {
		this.orgInfoService = orgInfoService;
	}
	public OrgInfo getOrgInfo() {
		return orgInfo;
	}
	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public void list(){
		List<OrgInfo> list = orgInfoService.queryAllOrgInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allOrgInfo", list);
	}
	
	public void realList(){
		List<OrgInfo> list = orgInfoService.queryRealAllOrgInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allOrgInfo", list);
	}
	
	public String showOrgInfo(){
		list();
		return "showorginfo";
	}
	
	public String orgPage(){
		list();
		return "orgpage";
	}
	
	public String showRealOrgInfo(){
		realList();
		return "showorginfo";
	}
	
	public String addOrgInfo(){
		if(orgInfoService.addOrgInfo(orgInfo)){
			list();
			return "showorginfo";
		}
		else
			return "orginfofalse";
	}
	
	public String deleteOrgInfo(){
		if(orgInfoService.deleteOrgInfo(orgInfo.getOrgId())){
			list();
			return "showorginfo";
		}
		else
			return "orginfofalse";
	}
	
	public String delectRealOrgInfo(){
		if(orgInfoService.deleteRealOrgInfo(orgInfo.getOrgId())){
			realList();
			return "showorginfo";
		}
		else
			return "orginfofalse";
	}
	
	public String updateOrgInfo(){
		if(orgInfoService.updateOrgInfo(orgInfo)){
			list();
			return "showorginfo";
		}
		else
			return "orginfofalse";
	}
	
	public String forUpdateOrgInfo(){
		orgInfo = orgInfoService.forUpdateOrgInfo(orgInfo.getOrgId());
		if(orgInfo != null){
			return "updateorginfo";
		}
		return "orginfofalse";
	}
	
	public String checkOrgInfo(){
		return null;
	}
}
