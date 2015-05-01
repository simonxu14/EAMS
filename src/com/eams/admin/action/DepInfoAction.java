package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.DepInfoService;
import com.eams.model.DepInfo;
import com.eams.model.OrgInfo;
import com.eams.admin.service.OrgInfoService;
import com.opensymphony.xwork2.ActionContext;

public class DepInfoAction {
	private DepInfoService depInfoService;
	private OrgInfoService orgInfoService;
	private OrgInfo orgInfo;
	private DepInfo depInfo;
	private Map<String,Object> request;
	private Map<String,Object> request_org;
	
	
	
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
	public Map<String, Object> getRequest_org() {
		return request_org;
	}
	public void setRequest_org(Map<String, Object> request_org) {
		this.request_org = request_org;
	}
	
	
	public DepInfoService getDepInfoService() {
		return depInfoService;
	}
	public void setDepInfoService(DepInfoService depInfoService) {
		this.depInfoService = depInfoService;
	}
	public DepInfo getDepInfo() {
		return depInfo;
	}
	public void setDepInfo(DepInfo depInfo) {
		this.depInfo = depInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	public void list(){
		List<DepInfo> list = depInfoService.queryAllDepInfo();
		request = (Map)ActionContext.getContext().get("request");
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getOrgInfo().getOrgName());
		request.put("allDepInfo", list);
	}
	
	public void list_org(){
		List<OrgInfo> list_org = orgInfoService.queryAllOrgInfo();
		request_org = (Map)ActionContext.getContext().get("request");
		request_org.put("allOrgInfo", list_org);
	}
	
	public void realList(){
		List<DepInfo> list = depInfoService.queryRealAllDepInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allDepInfo", list);
	}
	
	public String showDepInfo(){
		list();
		return "showdepinfo";
	}
	
	public String showRealDepInfo(){
		realList();
		return "showdepinfo";
	}
	
	public String forAddDepInfo(){
		list_org();
		return "adddepinfo";
	}
	
	//转换orgInfo.orgName成完整orgInfo类型
	public void exchange(){
		System.out.println(depInfo.getOrgInfo().getOrgId());
		orgInfo = orgInfoService.queryOrgById(depInfo.getOrgInfo().getOrgId());
	}
	
	public String addDepInfo(){
		exchange();
		if(depInfoService.addDepInfo(depInfo)){
			list();
			return "showdepinfo";
		}
		else
			return "depinfofalse";
	}
	
	public String deleteDepInfo(){
		if(depInfoService.deleteDepInfo(depInfo.getDepId())){
			list();
			return "showdepinfo";
		}
		else
			return "depinfofalse";
	}
	
	public String delectRealDepInfo(){
		if(depInfoService.deleteRealDepInfo(depInfo.getDepId())){
			realList();
			return "showdepinfo";
		}
		else
			return "depinfofalse";
	}
	
	public String updateDepInfo(){
		exchange();
		if(depInfoService.updateDepInfo(depInfo)){
			list();
			return "showdepinfo";
		}
		else
			return "depinfofalse";
	}
	
	public String forUpdateDepInfo(){
		depInfo = depInfoService.forUpdateDepInfo(depInfo.getDepId());
		if(depInfo != null){
			list_org();
			return "updatedepinfo";
		}
		else
			return "depinfofalse";
	}
	
	public String depPage(){
		list();
		return "deppage";
	}

}
