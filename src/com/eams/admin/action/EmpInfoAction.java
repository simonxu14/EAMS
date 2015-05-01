package com.eams.admin.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.eams.admin.service.DepInfoService;
import com.eams.admin.service.EmpInfoService;
import com.eams.admin.service.OrgInfoService;
import com.eams.admin.service.PowerInfoService;
import com.eams.model.DepInfo;
import com.eams.model.EmpInfo;
import com.eams.model.OrgInfo;
import com.eams.model.PostInfo;
import com.eams.model.PowerInfo;
import com.eams.model.StuConsult;
import com.eams.student.service.StuInfoService;
import com.eams.admin.service.PostInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//继承ActionSuppot类 接受Http
public class EmpInfoAction extends ActionSupport{
	//Serivce
	private EmpInfoService empInfoService;
	private PostInfoService postInfoService;
	private OrgInfoService orgInfoService;
	private PowerInfoService powerInfoService;
	private DepInfoService depInfoService;
	
	//Model类
	private PostInfo postInfo;
	private EmpInfo empInfo;
	private OrgInfo orgInfo;
	private PowerInfo powerInfo;
	private DepInfo depInfo;
	
	//request
	private Map<String,Object> request;
	private Map<String,Object> request_post;
	private Map<String,Object> request_org;
	private Map<String,Object> request_dep;
	private Map<String,Object> request_power;
	private Map<String,Object> session;
	
	
	
	private StuConsult stuConsult;
	private StuInfoService stuInfoService;
	
	
	
	//接受文件的属性
    private static final int BUFFER_SIZE = 16 * 1024;
    private String title;
    private File upload;// 上传文件域对象  
    private String uploadFileName;// 上传文件名  
    private String uploadContentType;// 上传文件类型  
    private String savePath ="d:/"; // 保存文件的目录路径(通过依赖注入) 
	
	
    
	public StuConsult getStuConsult() {
		return stuConsult;
	}
	public void setStuConsult(StuConsult stuConsult) {
		this.stuConsult = stuConsult;
	}
	public StuInfoService getStuInfoService() {
		return stuInfoService;
	}
	public void setStuInfoService(StuInfoService stuInfoService) {
		this.stuInfoService = stuInfoService;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Map<String, Object> getRequest_org() {
		return request_org;
	}
	public void setRequest_org(Map<String, Object> request_org) {
		this.request_org = request_org;
	}
	public Map<String, Object> getRequest_dep() {
		return request_dep;
	}
	public void setRequest_dep(Map<String, Object> request_dep) {
		this.request_dep = request_dep;
	}
	public Map<String, Object> getRequest_power() {
		return request_power;
	}
	public void setRequest_power(Map<String, Object> request_power) {
		this.request_power = request_power;
	}
	public OrgInfoService getOrgInfoService() {
		return orgInfoService;
	}
	public void setOrgInfoService(OrgInfoService orgInfoService) {
		this.orgInfoService = orgInfoService;
	}
	public PowerInfoService getPowerInfoService() {
		return powerInfoService;
	}
	public void setPowerInfoService(PowerInfoService powerInfoService) {
		this.powerInfoService = powerInfoService;
	}
	public OrgInfo getOrgInfo() {
		return orgInfo;
	}
	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}
	public PowerInfo getPowerInfo() {
		return powerInfo;
	}
	public void setPowerInfo(PowerInfo powerInfo) {
		this.powerInfo = powerInfo;
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
	public Map<String, Object> getRequest_post() {
		return request_post;
	}
	public void setRequest_post(Map<String, Object> request_post) {
		this.request_post = request_post;
	}
	
	
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
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
    
	    

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public static int getBufferSize() {
		return BUFFER_SIZE;
	}
		
		
		
		
		

	private static void copy(File src, File dst){
		InputStream in = null;  
		OutputStream out = null;
	    try{
	    	in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
	    	out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
	    	byte[] buffer = new byte[BUFFER_SIZE];
	    	int len = 0;
	    	while ((len = in.read(buffer)) > 0){
	    		out.write(buffer, 0, len);
	    	}
	        }catch(Exception e){
	        	e.printStackTrace();
	        }finally{
	            if(null != in){
	                try {
	                    in.close();
	                }catch(IOException e){
	                    e.printStackTrace();
	                }
	            }
	            if(null != out){
	                try {
	                    out.close();
	                }catch (IOException e){
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	public void list(){
		List<EmpInfo> list = empInfoService.queryAllEmpInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allEmpInfo", list);
	}
	
	public void list_post(){
		List<PostInfo> list_post = postInfoService.queryAllPostInfo();
		request_post = (Map)ActionContext.getContext().get("request");
		request_post.put("allPostInfo", list_post);
	}
	
	public void list_dep(){
		List<DepInfo> list_dep = depInfoService.queryAllDepInfo();
		request_dep = (Map)ActionContext.getContext().get("request");
		request_dep.put("allDepInfo", list_dep);
	}
	
	public void list_org(){
		List<OrgInfo> list_org = orgInfoService.queryAllOrgInfo();
		request_org = (Map)ActionContext.getContext().get("request");
		request_org.put("allOrgInfo", list_org);
	}
	
	public void list_power(){
		List<PowerInfo> list_power = powerInfoService.queryAllPowerInfo();
		request_power = (Map)ActionContext.getContext().get("request");
		request_power.put("allPowerInfo", list_power);
	}
	
	public void realList(){
		List<EmpInfo> list = empInfoService.queryRealAllEmpInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allEmpInfo", list);
	}
	
	
	
	//show函数
	public String showEmpInfo(){
		list();
		return "showempinfo";
	}
	
	public String showRealEmpInfo(){
		realList();
		return "showempinfo";
	}	
	
	
	public void exchange_post(){
		System.out.println(empInfo.getPostInfo().getPostId());
		postInfo = postInfoService.queryPostById(empInfo.getPostInfo().getPostId());
	}
	
	public void exchange_org(){
		System.out.println(empInfo.getOrgInfo().getOrgId());
		orgInfo = orgInfoService.queryOrgById(empInfo.getOrgInfo().getOrgId());
	}
	
	public void exchange_dep(){
		System.out.println(empInfo.getDepInfo().getDepId());
		depInfo = depInfoService.queryDepById(empInfo.getDepInfo().getDepId());
	}
	
	public void exchange_power(){
		System.out.println(empInfo.getPowerInfo().getPowerId());
		powerInfo = powerInfoService.queryPowerById(empInfo.getPowerInfo().getPowerId());
	}
	

	//add函数
	public String forAddEmpInfo(){
		list_post();
		list_org();
		list_dep();
		list_power();
		return "addempinfo";
	}
	
	public String addEmpInfo()throws Exception{
		System.out.println(empInfo.getEmpBirth()+"----");
	    String dstPath = ServletActionContext.getServletContext()  
                .getRealPath(this.getSavePath())+"/"+empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dstPath);
	    
	    String dataPath = "photo/" + empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dataPath);
	    System.out.println(this.getUploadContentType());
	    empInfo.setEmpPhoto(dataPath);
	         
	    File dstFile = new File(dstPath);  
	    copy(this.upload, dstFile);  
	    
	    
		exchange_post();
		exchange_org();
		exchange_dep();
		exchange_power();
		
		empInfo.setOrgInfo(orgInfo);
		empInfo.setDepInfo(depInfo);
		empInfo.setPostInfo(postInfo);
		empInfo.setPowerInfo(powerInfo);
		
		
		
		if(empInfoService.addEmpInfo(empInfo)){
			list();
			return "showempinfo";
		}
		else
			return "empinfofalse";
	}
	
	
	//delete函数
	public String deleteEmpInfo(){
		if(empInfoService.deleteEmpInfo(empInfo.getEmpId())){
			list();
			return "showempinfo";
		}
		else
			return "empinfofalse";
	}
	
	public String delectRealEmpInfo(){
		if(empInfoService.deleteRealEmpInfo(empInfo.getEmpId())){
			realList();
			return "showempinfo";
		}
		else
			return "empinfofalse";
	}
	
	
	//update函数
	public String updateEmpInfo()throws Exception{
	    String dstPath = ServletActionContext.getServletContext()  
                .getRealPath(this.getSavePath())+"/"+empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dstPath);
	    
	    String dataPath = "photo/" + empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dataPath);
	    System.out.println(this.getUploadContentType());
	    empInfo.setEmpPhoto(dataPath);
	         
	    File dstFile = new File(dstPath);  
	    copy(this.upload, dstFile);  
		
		
		
		exchange_post();
		exchange_org();
		exchange_dep();
		exchange_power();
		System.out.println(empInfo.getEmpAccount());
		System.out.println(empInfo.getEmpName());
		System.out.println(empInfo.getEmpPhoto());
		System.out.println(empInfo.getEmpIdcard());
		
		
		
		if(empInfoService.updateEmpInfo(empInfo)){
			list();
			return "showempinfo";
		}
		else
			return "empinfofalse";
	}
	
	public String forUpdateEmpInfo(){
		empInfo = empInfoService.forUpdateEmpInfo(empInfo.getEmpId());
		if(empInfo != null){
			list_post();
			list_org();
			list_dep();
			list_power();
			System.out.println(request_post.size());
			return "updateempinfo";
		}
		else
			return "empinfofalse";
	}
	

	
	//check函数
	public String checkEmpInfo(){
		String password = empInfo.getEmpPassword();
		empInfo = empInfoService.checkEmpInfo(empInfo.getEmpAccount());
		if(empInfo.getEmpPassword().endsWith(password)){
			session = ActionContext.getContext().getSession();
			session.put("empInfo_session", empInfo);
			return "page";
		}
		else
			return "empinfofalse";
	}
	
	public String empPage(){
		list();
		return "emppage";
	}
	
	
	public String myForUpdateEmpInfo(){
		empInfo = empInfoService.forUpdateEmpInfo(empInfo.getEmpId());
		if(empInfo != null){
			list_post();
			list_org();
			list_dep();
			list_power();
			System.out.println(request_post.size());
			return "myupdateempinfo";
		}
		else
			return "empinfofalse";
	}
	
	public String myUpdateEmpInfo()throws Exception{
	    String dstPath = ServletActionContext.getServletContext()  
                .getRealPath(this.getSavePath())+"/"+empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dstPath);
	    
	    String dataPath = "photo/" + empInfo.getEmpAccount() + ".jpg";
	    System.out.println(dataPath);
	    System.out.println(this.getUploadContentType());
	    empInfo.setEmpPhoto(dataPath);
	         
	    File dstFile = new File(dstPath);  
	    copy(this.upload, dstFile);  
		
		
		
		exchange_post();
		exchange_org();
		exchange_dep();
		exchange_power();
		
		empInfo.setOrgInfo(orgInfo);
		empInfo.setDepInfo(depInfo);
		empInfo.setPostInfo(postInfo);
		empInfo.setPowerInfo(powerInfo);
		
		
		System.out.println(empInfo.getEmpAccount());
		System.out.println(empInfo.getEmpName());
		System.out.println(empInfo.getEmpPhoto());
		System.out.println(empInfo.getEmpIdcard());
		
		
		
		if(empInfoService.updateEmpInfo(empInfo)){
			session = ActionContext.getContext().getSession();
			session.put("empInfo_session", empInfo);
			System.out.println(empInfo.getDepInfo().getDepName());
			return "page";
		}
		else
			return "empinfofalse";
	}
	
	public String checkout(){
		Map session = ActionContext.getContext().getSession();
		empInfo = (EmpInfo)session.get("empInfo_session");
		System.out.println(empInfo.getEmpAccount());
		
		
		return "empinfosuccess";
	}
	
}
