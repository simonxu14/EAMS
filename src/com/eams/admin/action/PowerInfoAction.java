package com.eams.admin.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eams.admin.service.PowerInfoService;
import com.eams.model.PowerInfo;
import com.opensymphony.xwork2.ActionContext;

public class PowerInfoAction {
	private PowerInfoService powerInfoService;
	private PowerInfo powerInfo;
	private Map<String,Object> request;
	
	public PowerInfoService getPowerInfoService() {
		return powerInfoService;
	}
	public void setPowerInfoService(PowerInfoService powerInfoService) {
		this.powerInfoService = powerInfoService;
	}
	public PowerInfo getPowerInfo() {
		return powerInfo;
	}
	public void setPowerInfo(PowerInfo powerInfo) {
		this.powerInfo = powerInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public void list(){
		List<PowerInfo> list = powerInfoService.queryAllPowerInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allPowerInfo", list);
	}
	
	public void realList(){
		List<PowerInfo> list = powerInfoService.queryRealAllPowerInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allPowerInfo", list);
	}
	
	public String showPowerInfo(){
		list();
		return "showpowerinfo";
	}
	
	public String showRealPowerInfo(){
		realList();
		return "showpowerinfo";
	}
	
	public String addPowerInfo(){
		change();
		if(powerInfoService.addPowerInfo(powerInfo)){
			list();
			return "showpowerinfo";
		}
		else
			return "powerinfofalse";
	}
	
	public String deletePowerInfo(){
		if(powerInfoService.deletePowerInfo(powerInfo.getPowerId())){
			list();
			return "showpowerinfo";
		}
		else
			return "powerinfofalse";
	}
	
	public String delectRealPowerInfo(){
		if(powerInfoService.deleteRealPowerInfo(powerInfo.getPowerId())){
			realList();
			return "showpowerinfo";
		}
		else
			return "powerinfofalse";
	}
	
	public String updatePowerInfo(){
		change();
		if(powerInfoService.updatePowerInfo(powerInfo)){
			list();
			return "showpowerinfo";
		}
		else
			return "powerinfofalse";
	}
	
	public String forUpdatePowerInfo(){
		powerInfo = powerInfoService.forUpdatePowerInfo(powerInfo.getPowerId());
		if(powerInfo != null){
			return "updatepowerinfo";
		}
		return "powerinfofalse";
	}
	
	public String checkPowerInfo(){
		return null;
	}
	
	public void change(){
		ArrayList<Integer> powerAccountArray = new ArrayList<Integer>();
		powerAccountArray = powerInfo.getPowerAccountArray();
		int i;
		Integer powerAccount = 0;
		for(i=0;i<powerAccountArray.size();i++){
			powerAccount = powerAccount + powerAccountArray.get(i);
		}
		powerInfo.setPowerAccount(powerAccount);
		System.out.println(powerAccount);
	}
	
	public String powerPage(){
		list();
		return "powerpage";
	}
}
