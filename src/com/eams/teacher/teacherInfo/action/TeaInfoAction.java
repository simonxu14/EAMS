package com.eams.teacher.teacherInfo.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;

import com.eams.course.service.CourseService;
import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;
import com.eams.teacher.teacherInfo.service.TeaInfoService;
import com.eams.teacher.teacherLevel.service.TeaLevService;
import com.opensymphony.xwork2.ActionContext;

public class TeaInfoAction {
	
	private TeaInfoService teaInfoService;
	private TeachInfo teachInfo;
	private Map<String, Object> request;
	private Map<String,Object> session;
	
	
	private CourseInfo courseInfo;
	private CourseService courseInfoService;
	private Map<String,Object> request_course;
	
	private TeachLevel teachlevel;
	private TeaLevService teaLevService;
	private Map<String,Object> request_lev;
	
	private static final int BUFFER_SIZE = 16 * 1024;
	 // 文件标题  
	private String title;  
	// 上传文件域对象  
	private File upload;  
	// 上传文件名  
	private String uploadFileName;  
	// 上传文件类型  
	private String uploadContentType;  
	// 保存文件的目录路径(通过依赖注入)  
	private String savePath; 
	//头像存放路径
	private String path;
	
	
	
	
	
	
	
	public Map<String, Object> getRequest_lev() {
		return request_lev;
	}

	public void setRequest_lev(Map<String, Object> request_lev) {
		this.request_lev = request_lev;
	}

	public TeachLevel getTeachlevel() {
		return teachlevel;
	}

	public void setTeachlevel(TeachLevel teachlevel) {
		this.teachlevel = teachlevel;
	}

	public TeaLevService getTeaLevService() {
		return teaLevService;
	}

	public void setTeaLevService(TeaLevService teaLevService) {
		this.teaLevService = teaLevService;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public CourseService getCourseInfoService() {
		return courseInfoService;
	}

	public void setCourseInfoService(CourseService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public Map<String, Object> getRequest_course() {
		return request_course;
	}

	public void setRequest_course(Map<String, Object> request_course) {
		this.request_course = request_course;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public TeaInfoService getTeaInfoService() {
		return teaInfoService;
	}

	public void setTeaInfoService(TeaInfoService teaInfoService) {
		this.teaInfoService = teaInfoService;
	}

	public TeachInfo getTeachInfo() {
		return teachInfo;
	}

	public void setTeachInfo(TeachInfo teachInfo) {
		this.teachInfo = teachInfo;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String testList(){
		return hiddenList();
	}
	
	public String checkTeacher(){
		teachInfo=teaInfoService.checkTeacher(teachInfo);
		if(teachInfo!=null){
			session=ActionContext.getContext().getSession();
			session.put("teachInfo_session",teachInfo);
			return "check_success";
		}
		return "default";
	}
	
	public String checkAdmin(){
		teachInfo=teaInfoService.checkTeacher(teachInfo);
		if(teachInfo!=null){
			session=ActionContext.getContext().getSession();
			session.put("teachInfo",teachInfo);
			return hiddenList();
		}
		return "default";
	}
	
	public String list(){
		List<TeachInfo> list = teaInfoService.queryAllInfo();
		request = (Map)ActionContext.getContext().get("request");
		request.put("info", list);
		return "success";
	}
	
	public String hiddenList(){
		List list =teaInfoService.queryAllInfoV();
		request = (Map) ActionContext.getContext().get("request");
		request.put("info", list);
		System.out.println(list.size());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "success";
	}
	
	public String tea_hiddenList(){
		List list =teaInfoService.queryAllInfoV();
		request = (Map) ActionContext.getContext().get("request");
		request.put("info", list);
		return "tea_success";
	}
	
	
	
	
	public String addTeacherInfo(){
		boolean flag=teaInfoService.addTeacherInfo(teachInfo);
		if(flag){
			teachInfo.setTeachPhoto(this.getPath());
			String i = hiddenList();
			return i;
		}
		else{
			return "add_default";
		}
	}
	
	public String deleteTeacherInfo(){
		teaInfoService.deleteTeacherInfo(teachInfo.getTeachId());
		String i = list();
		return i;
	}
	
	public String hiddenDeleteTeacherInfo(){
		teaInfoService.deleteTeacherInfoV(teachInfo.getTeachId());
		String i =hiddenList();
		
		System.out.println("&&&&&&&&&&$$$$$$$$$########");
		return i;
	}
	
	public String updateTeaInfo1(){
		teachInfo=teaInfoService.queryById(teachInfo.getTeachId());
		List<TeachLevel> allLevel = teaInfoService.queryTeachLevel();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allLevel", allLevel);
		session=ActionContext.getContext().getSession();
		session.put("teachInfo_session",teachInfo);
		return "update";
	}
	
	public String updateTeaInfo2(){
		//System.out.println("123");
		teaInfoService.updateTeaInfo(teachInfo);
		String i =hiddenList();
		return i;
	}
	
	public String updateTeaInfo3(){
		teaInfoService.updateTeaInfo(teachInfo);
		return "success";
	}
	
	
	public String updateTeaInfo4(){
		teaInfoService.updateTeaInfo(teachInfo);
		session=ActionContext.getContext().getSession();
		session.put("teachInfo_session",teachInfo);
		return "check_success";
	}
	
	
	
	
	public String queryTeachLevel(){
		List<TeachLevel> allLevel = teaInfoService.queryTeachLevel();
		request = (Map)ActionContext.getContext().get("request");
		request.put("allLevel", allLevel);
		return "update";
	}
	
	/*
	 * 上传头像图片文件
	 */
	public static void copy(File src, File dst){
		 InputStream in = null;  
	        OutputStream out = null;  
	        try {  
	            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);  
	            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);  
	            byte[] buffer = new byte[BUFFER_SIZE];  
	            int len = 0;  
	            while ((len = in.read(buffer)) > 0) {  
	                out.write(buffer, 0, len);  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (null != in) {  
	                try {  
	                    in.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (null != out) {  
	                try {  
	                    out.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }
	        }
	}
	
	public String addTeachUpload(){
		boolean flag = upload();
		TeachInfo teachInfo = new TeachInfo();
		teachInfo.setTeachPhoto(this.getPath());
         request=(Map)ActionContext.getContext().get("request");
 		 request.put("teachInfo",teachInfo);	
		return  queryTeachLevel();
	}
	
	
	public String updateTeachUpload(){
		System.out.println("updateStudentUpload=================");
		upload();
		teaInfoService.queryById(teachInfo.getTeachId());
		teachInfo.setTeachPhoto(this.getPath());
		System.out.println(this.getPath());
		System.out.println("###########");
		request=(Map)ActionContext.getContext().get("request");
		request.put("teachInfo",teachInfo);
		return queryTeachLevel();
	}
	public String tea_updateTeachUpload(){
		System.out.println("updateStudentUpload=================");
		upload();
		teaInfoService.queryById(teachInfo.getTeachId());
		teachInfo.setTeachPhoto(this.getPath());
		System.out.println("######");
		
		teaInfoService.updateTeaInfo(teachInfo);
		
		
		request=(Map)ActionContext.getContext().get("request");
		request.put("teachInfo",teachInfo);
		
		session=ActionContext.getContext().getSession();
		session.put("teachInfo_session",teachInfo);
		
		
		return "tea_updateteainfo";
	}
	
	public boolean upload(){
		System.out.println("upload action");
		  //根据服务器的文件保存地址和原文件名创建目录文件全路径  
        String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+ "/" + teachInfo.getTeachAccount() + ".jpg";  
        String dstPath2 = "tea_photo/" +  teachInfo.getTeachAccount() + ".jpg"; 
        
        
        System.out.println(dstPath);
        System.out.println(dstPath2);
        
        
        if(this.getUploadContentType().startsWith("image")){
        	 File dstFile = new File(dstPath);  
             copy(this.upload, dstFile); 
             this.setPath(dstPath2);
             
             
             
             
     		 return true;
        }else{
        	return false;
        }
	}

	
	public void exchange_teach(){
		teachInfo=teaInfoService.queryTeacherById(teachInfo);
	}
	
	
	public String myCourse(){
		System.out.println("###########");
		System.out.println(teachInfo.getTeachId());
		
		
		List<CourseInfo> myCourseInfo = teaInfoService.queryCourseByTeacherId(teachInfo.getTeachId());

		System.out.println(myCourseInfo.get(0).getCourseName());
		
		request_course=(Map)ActionContext.getContext().get("request");
		request_course.put("myCourseInfo",myCourseInfo);
		
		return "mycourse";
	}
	
	public String allCourse(){
		System.out.println("###########");
		System.out.println(teachInfo.getTeachId());
		
		
		List<CourseInfo> allCourseInfo = teaInfoService.queryAllCourses();

		System.out.println(allCourseInfo.get(0).getCourseName());
		
		request_course=(Map)ActionContext.getContext().get("request");
		request_course.put("allCourseInfo",allCourseInfo);
		
		return "allcourse";
	}

	public String forAddTeacher(){
		List<TeachLevel> list_lev = teaInfoService.queryAllLevelsV();
		
		
		
		request_lev = (Map)ActionContext.getContext().get("request");
		request_lev.put("AllLev", list_lev);
		return "adm_foraddteainfo";
	}
	
	
	public String addTeacher(){
		
		System.out.println(teachInfo.getTeachAccount());
		System.out.println(teachInfo.getTeachId());
		System.out.println(teachInfo.getTeachName());
		teaInfoService.addTeacherInfo(teachInfo);
		List<TeachInfo> list =teaInfoService.queryAllInfoV();
		request = (Map) ActionContext.getContext().get("request");
		request.put("info", list);
		System.out.println(list.size());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "success";
	}
	
	
	

}
