package com.eams.admin.action;

import java.util.List;
import java.util.Map;

import com.eams.admin.service.PostInfoService;
import com.eams.model.PostInfo;
import com.eams.model.DepInfo;
import com.eams.admin.service.DepInfoService;
import com.opensymphony.xwork2.ActionContext;

public class PostInfoAction {
	private PostInfoService postInfoService;
	private DepInfoService depInfoService;
	private DepInfo depInfo;
	private PostInfo postInfo;
	private Map<String,Object> request;
	private Map<String,Object> request_dep;
	
	
	
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
	public Map<String, Object> getRequest_dep() {
		return request_dep;
	}
	public void setRequest_dep(Map<String, Object> request_dep) {
		this.request_dep = request_dep;
	}
	
	
	public PostInfoService getPostInfoService() {
		return postInfoService;
	}
	public void setPostInfoService(PostInfoService postInfoService) {
		this.postInfoService = postInfoService;
	}
	public PostInfo getPostInfo() {
		return postInfo;
	}
	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	public void list(){
		List<PostInfo> list = postInfoService.queryAllPostInfo();
		request = (Map)ActionContext.getContext().get("request");
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getDepInfo().getDepName());
		request.put("allPostInfo", list);
	}
	
	public void list_dep(){
		List<DepInfo> list_dep = depInfoService.queryAllDepInfo();
		request_dep = (Map)ActionContext.getContext().get("request");
		request_dep.put("allDepInfo", list_dep);
	}
	
	public void realList(){
		List<PostInfo> list = postInfoService.queryRealAllPostInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allPostInfo", list);
	}
	
	public String showPostInfo(){
		list();
		return "showpostinfo";
	}
	
	public String showRealPostInfo(){
		realList();
		return "showpostinfo";
	}
	
	public String forAddPostInfo(){
		list_dep();
		return "addpostinfo";
	}
	
	public void exchange(){
		System.out.println(postInfo.getDepInfo().getDepId());
		depInfo = depInfoService.queryDepById(postInfo.getDepInfo().getDepId());
	}
	
	public String addPostInfo(){
		exchange();
		if(postInfoService.addPostInfo(postInfo)){
			list();
			return "showpostinfo";
		}
		else
			return "postinfofalse";
	}
	
	public String deletePostInfo(){
		if(postInfoService.deletePostInfo(postInfo.getPostId())){
			list();
			return "showpostinfo";
		}
		else
			return "postinfofalse";
	}
	
	public String delectRealPostInfo(){
		if(postInfoService.deleteRealPostInfo(postInfo.getPostId())){
			realList();
			return "showpostinfo";
		}
		else
			return "postinfofalse";
	}
	
	public String updatePostInfo(){
		exchange();
		if(postInfoService.updatePostInfo(postInfo)){
			list();
			return "showpostinfo";
		}
		else
			return "postinfofalse";
	}
	
	public String forUpdatePostInfo(){
		postInfo = postInfoService.forUpdatePostInfo(postInfo.getPostId());
		if(postInfo != null){
			list_dep();
			System.out.println(request_dep.size());
			return "updatepostinfo";
		}
		else
			return "postinfofalse";
	}
	
	public String checkPostInfo(){
		return null;
	}
	
	public String postPage(){
		list();
		return "postpage";
	}

}
