package com.eams.admin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eams.admin.service.CheckInfoService;
import com.eams.admin.service.ClassInfoService;
import com.eams.admin.service.EmpInfoService;
import com.eams.admin.service.GradeInfoService;
import com.eams.model.CheckInfo;
import com.eams.model.ClassInfo;
import com.eams.model.EmpInfo;
import com.eams.model.GradeInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckInfoAction extends ActionSupport{
	private CheckInfoService checkInfoService;
	private GradeInfoService gradeInfoService;
	private ClassInfoService classInfoService;
	private EmpInfoService empInfoService;
	
	
	private EmpInfo empInfo;
	private CheckInfo checkInfo;
	private GradeInfo gradeInfo;
	private ClassInfo classInfo;
	
	private Map<String,Object> request;
	private Map<String,Object> request_emp;
	private Map<String,Object> request_grade;
	private Map<String,Object> request_class;
	
    private static final int BUFFER_SIZE = 16 * 1024;
    private String title;
    private File upload;
    private String uploadFileName;
    private String uploadContentType;
    private String savePath ="d:/";
    
	
    public ArrayList<ClassInfo> theClass;
    private String thegrade;
	
	
	
	public String getThegrade() {
		return thegrade;
	}



	public void setThegrade(String thegrade) {
		this.thegrade = thegrade;
	}



	public ArrayList<ClassInfo> getTheClass() {
		return theClass;
	}



	public void setTheClass(ArrayList<ClassInfo> theClass) {
		this.theClass = theClass;
	}



	public CheckInfoService getCheckInfoService() {
		return checkInfoService;
	}



	public void setCheckInfoService(CheckInfoService checkInfoService) {
		this.checkInfoService = checkInfoService;
	}



	public GradeInfoService getGradeInfoService() {
		return gradeInfoService;
	}



	public void setGradeInfoService(GradeInfoService gradeInfoService) {
		this.gradeInfoService = gradeInfoService;
	}



	public ClassInfoService getClassInfoService() {
		return classInfoService;
	}



	public void setClassInfoService(ClassInfoService classInfoService) {
		this.classInfoService = classInfoService;
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



	public CheckInfo getCheckInfo() {
		return checkInfo;
	}



	public void setCheckInfo(CheckInfo checkInfo) {
		this.checkInfo = checkInfo;
	}



	public GradeInfo getGradeInfo() {
		return gradeInfo;
	}



	public void setGradeInfo(GradeInfo gradeInfo) {
		this.gradeInfo = gradeInfo;
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



	public Map<String, Object> getRequest_emp() {
		return request_emp;
	}



	public void setRequest_emp(Map<String, Object> request_emp) {
		this.request_emp = request_emp;
	}



	public Map<String, Object> getRequest_grade() {
		return request_grade;
	}



	public void setRequest_grade(Map<String, Object> request_grade) {
		this.request_grade = request_grade;
	}



	public Map<String, Object> getRequest_class() {
		return request_class;
	}



	public void setRequest_class(Map<String, Object> request_class) {
		this.request_class = request_class;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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
		List<CheckInfo> list = checkInfoService.queryAllCheckInfo();
		request = (Map)ActionContext.getContext().get("request");
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getEmpInfo().getEmpName());
		request.put("allCheckInfo", list);
		
		
	}
	
	public void list_emp(){
		List<EmpInfo> list_emp = empInfoService.queryAllEmpInfo();
		request_emp = (Map)ActionContext.getContext().get("request");
		request_emp.put("allEmpInfo", list_emp);
		System.out.println(list_emp.size());
	}
	
	public void list_grade(){
		List<GradeInfo> list_grade = gradeInfoService.queryAllGradeInfo();
		request_grade = (Map)ActionContext.getContext().get("request");
		request_grade.put("allGradeInfo", list_grade);
		System.out.println(list_grade.size());
	}
	
	public void list_class(){
		List<ClassInfo> list_class = classInfoService.queryAllClassInfo();
		request_class = (Map)ActionContext.getContext().get("request");
		request_class.put("allClassInfo", list_class);
		System.out.println(list_class.size());
	}
	
	public void realList(){
		List<CheckInfo> list = checkInfoService.queryRealAllCheckInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allCheckInfo", list);
	}
	
	public String showCheckInfo(){
		list();
		return "showcheckinfo";
	}
	
	public String showRealCheckInfo(){
		realList();
		return "showcheckinfo";
	}

	
	//转换empInfo.empName成完整empInfo类型
	public void exchange_emp(){
		System.out.println("$$$$$$");
		System.out.println(checkInfo.getEmpInfo().getEmpId());
		empInfo = empInfoService.queryEmpById(checkInfo.getEmpInfo().getEmpId());
		System.out.println(empInfo.getEmpName());
	}
	
	public void exchange_grade(){
		System.out.println(checkInfo.getGradeInfo().getGradeId());
		gradeInfo = gradeInfoService.queryGradeById(checkInfo.getGradeInfo().getGradeId());
		System.out.println(gradeInfo.getGradeName());
	}
	
	public void exchange_class(){
		System.out.println(checkInfo.getClassInfo().getClassId());
		classInfo = classInfoService.queryClassById(checkInfo.getClassInfo().getClassId());
		System.out.println(classInfo.getClassName());
	}
	
	
	public String forAddCheckInfo(){
		list_emp();
		list_grade();
		list_class();
		return "addcheckinfo";
	}
	
	
	public String addCheckInfo(){
		
		exchange_emp();
		exchange_grade();
		exchange_class();
		
		String dstPath = ServletActionContext.getServletContext()  
                .getRealPath(this.getSavePath())+"/"+gradeInfo.getGradeName()+"Grade"+classInfo.getClassName()+"Class"+checkInfo.getCheckYear() +"Y"+ checkInfo.getCheckMonth()+ "M"+".doc";
	    System.out.println(dstPath);
	    
	    String dataPath = "check/" + gradeInfo.getGradeName()+"Grade"+classInfo.getClassName()+"Class"+checkInfo.getCheckYear() +"Y"+ checkInfo.getCheckMonth()+ "M"+".doc";
	    System.out.println(dataPath);
	    System.out.println(this.getUploadContentType());
	    checkInfo.setCheckFile(dataPath);
	         
	    File dstFile = new File(dstPath);  
	    copy(this.upload, dstFile);  
		
		
		if(checkInfoService.addCheckInfo(checkInfo)){
			list();
			return "showcheckinfo";
		}
		else
			return "checkinfofalse";
	}
	
	public String deleteCheckInfo(){
		if(checkInfoService.deleteCheckInfo(checkInfo.getCheckId())){
			list();
			return "showcheckinfo";
		}
		else
			return "checkinfofalse";
	}
	
	public String delectRealCheckInfo(){
		if(checkInfoService.deleteRealCheckInfo(checkInfo.getCheckId())){
			realList();
			return "showcheckinfo";
		}
		else
			return "checkinfofalse";
	}
	
	public String updateCheckInfo(){
		exchange_emp();
		exchange_grade();
		exchange_class();
		
		
		String dstPath = ServletActionContext.getServletContext()  
                .getRealPath(this.getSavePath())+"/"+gradeInfo.getGradeName()+"Grade"+classInfo.getClassName()+"Class"+checkInfo.getCheckYear() +"Y"+ checkInfo.getCheckMonth()+ "M"+".doc";
	    System.out.println(dstPath);
	    
	    String dataPath = "check/" + gradeInfo.getGradeName()+"Grade"+classInfo.getClassName()+"Class"+checkInfo.getCheckYear() +"Y"+ checkInfo.getCheckMonth()+ "M"+".doc";
	    System.out.println(dataPath);
	    System.out.println(this.getUploadContentType());
	    checkInfo.setCheckFile(dataPath);
	         
	    File dstFile = new File(dstPath);  
	    copy(this.upload, dstFile);  
		
		
		if(checkInfoService.updateCheckInfo(checkInfo)){
			list();
			return "showcheckinfo";
		}
		else
			return "checkinfofalse";
	}
	
	public String forUpdateCheckInfo(){
		checkInfo = checkInfoService.forUpdateCheckInfo(checkInfo.getCheckId());
		if(checkInfo != null){
			list_emp();
			list_grade();
			list_class();
			return "updatecheckinfo";
		}
		else
			return "checkinfofalse";
	}
	
	public String checkCheckInfo(){
		return null;
	}
	
	public String checkPage(){
		list();
		return "checkpage";
	}
	
	public String ajax(){
		theClass = new ArrayList<ClassInfo>();
		System.out.println(thegrade);
		List<ClassInfo> list_class = classInfoService.queryAllClassInfo();
		int i;
		for(i=0;i<list_class.size();i++){
			if (thegrade.equals(list_class.get(i).getGradeInfo().getGradeId().toString())){
				theClass.add(list_class.get(i));
			}
		}
		return SUCCESS;
	}

}
