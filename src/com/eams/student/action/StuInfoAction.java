package com.eams.student.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eams.model.CourseInfo;
import com.eams.model.StuCheck;
import com.eams.model.StuConsult;
import com.eams.model.StuCourse;
import com.eams.model.StuInfo;
import com.eams.student.service.StuInfoService;
import com.opensymphony.xwork2.ActionContext;

public class StuInfoAction {
	private StuInfoService stuService;
	private StuInfo student;
	private StuConsult stuconsult;
	private Map<String,Object> session;
	private Map<String,Object> request_return;
	private Map<String,Object> request;
	private StuCourse stucourse;
	private CourseInfo courseInfo;
	
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

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public StuInfoService getStuService() {
		return stuService;
	}

	public void setStuService(StuInfoService stuService) {
		this.stuService = stuService;
	}

	public StuInfo getStudent() {
		return student;
	}

	public void setStudent(StuInfo student) {
		this.student = student;
	}

	public StuConsult getStuconsult() {
		return stuconsult;
	}

	public void setStuconsult(StuConsult stuconsult) {
		this.stuconsult = stuconsult;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public StuCourse getStucourse() {
		return stucourse;
	}

	public void setStucourse(StuCourse stucourse) {
		this.stucourse = stucourse;
	}

	
	/*
	 * 添加咨询学生
	 */
	public String AddConsultStudent(){
		stuconsult.setConsultPay(false);
		stuService.addConsultStudent(stuconsult);
		return "consultSuccess";
	}
	
	public String myAddConsultStudent(){
		stuconsult.setConsultPay(false);
		stuService.addConsultStudent(stuconsult);
		return "myconsultSuccess";
	}
	
	/*
	 * 用户登录函数
	 */
	public String CheckStudent(){
		student = stuService.CheckStudent(student);
		if(student != null){
			//获取map类型的session
			session=ActionContext.getContext().getSession();
			session.put("student",student);
			System.out.println("success "+student.getStuName());
			//return "studentIndex";
			return showStudentInfo();
		}else{
			System.out.println("fail");
			return "default";
		}
	}
	/*
	 * 显示学生个人信息
	 */
	public String showStudentInfo(){
		//System.out.println(student.getStuAccount()+"action level");
		student = stuService.queryStudentById(student.getStuId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("studentInfo",student);
		//System.out.println(student.getStuId());
		return "studentIndex";
	}
	/*
	 * 查询选课信息
	 */
	public String checkCourseByStudent(){
		List<StuCourse> courses = stuService.checkCourseByStudent(student);
		System.out.println(courses.size()+"action check courses by student");
		request=(Map)ActionContext.getContext().get("request");
		request.put("courses",courses);
		return "studentCourse";
	}
	/*
	 * 删除已选课程
	 */
	public String deleteStuCourse(){
		stuService.deleteStuCourse(stucourse);
		return checkCourseByStudent();
	}
	/*
	 * 显示所有课程信息
	 */
	public String checkAllCourse(){
		List<CourseInfo> allCourses = stuService.checkAllCourse();
		request=(Map)ActionContext.getContext().get("request");
		request.put("allcourses",allCourses);
		return "allCourses";
	}
	/*
	 * 选课
	 */
	public String selectCourse(){
		System.out.println("##########!!!!!!!!!!!!!!!!!!!!2222222222222");
		int flag = stuService.AddStuCourse(student, courseInfo);
		System.out.println("##########!!!!!!!!!!!!!!!!!!!!2222222222222");
		System.out.println(student.getStuAccount());
		System.out.println(courseInfo.getCourseId());
		request_return=(Map)ActionContext.getContext().get("request");
		request_return.put("stuCourseflag",flag);//1 课程已存在 2 时间冲突 0 选课成功
		return checkAllCourse();
	}
	/*
	 * 修改个人信息
	 */
	public String showStudentInfoForUpdate(){
		student = stuService.queryStudentById(student.getStuId());
		request=(Map)ActionContext.getContext().get("request");
		request.put("studentInfo",student);
		return "showStudentInfoPage";
	}
	public String updateStuInfo(){
		StuInfo stu_temp = stuService.updateStuInfo(student);
		this.setStudent(stu_temp);
		return "updateStudentInfo";
	}
	/*
	 * 管理员修改学生信息
	 */
	public String queryStudentById(){
		//System.out.println("queryStudentById===========================");
		student = stuService.queryStudentById(student.getStuId());
		student.setStuPhoto(this.getPath());
		return "updateStuInfo";
	}
	public String updateStuInfoManager(){
		String name="";
		String Account="";
		String school="";
		String address="";
		String Telephone="";
		String Major="";
		String Comment="";
		try {
			name = new String(student.getStuName().getBytes("ISO-8859-1"),"utf-8");
			Account = new String(student.getStuAccount().getBytes("ISO-8859-1"),"utf-8");
			school = new String(student.getStuSchool().getBytes("ISO-8859-1"),"utf-8");
			address = new String(student.getStuAddress().getBytes("ISO-8859-1"),"utf-8");
			Telephone = new String(student.getStuTel().getBytes("ISO-8859-1"),"utf-8");
			Major = new String(student.getStuMajor().getBytes("ISO-8859-1"),"utf-8");
			Comment = new String(student.getStuComment().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("action=============== "+student.getStuTel()+"===="+name);
		student.setStuName(name);
		student.setStuAccount(Account);
		student.setStuAddress(address);
		student.setStuComment(Comment);
		student.setStuMajor(Major);
		student.setStuSchool(school);
		stuService.updateStuInfo(student);
		//session.put("student",student);
		return queryAllStudent();
	}
	/*
	 * 查询所有学生信息
	 */
	public String queryAllStudent(){
		List<StuInfo> stuList = stuService.queryAllStudent();
		System.out.println(stuList.get(0).getStuPhoto());
		request=(Map)ActionContext.getContext().get("request");
		request.put("allStudent",stuList);
		return "allStudent";
	}
	/*
	 * 删除学生信息
	 */
	public String deleteStudent(){
		stuService.deleteStudent(student);
		return queryAllStudent();
	}
	/*
	 * 查询课程考勤信息
	 */
	public String queryStuCheckByCourse(){
		List<StuCheck> stuCheckList = stuService.queryStuCheckByCourse(courseInfo);
		request=(Map)ActionContext.getContext().get("request");
		request.put("stucheck",stuCheckList);
		System.out.println(courseInfo.getCourseId()+" courseID");
		return "stuCheck";
	}
	/*
	 * 添加学生
	 */
	public String addStudent(){
		student.setStuPhoto(this.getPath());
		stuService.addStudent(student);
		return "stuManageIndex";
	}
	/*
	 * 查询学生
	 */
	public String queryStudentByCondition(){
		List<StuInfo> stuList = stuService.queryStudentByConditon(student);
		request=(Map)ActionContext.getContext().get("request");
		request.put("queryStudent",stuList);
		return "queryStudent";
	}
	/*
	 * 查找并显示所有的咨询学生
	 */
	public String queryAllConsultStudent(){
		List<StuConsult> sc_list = stuService.queryAllConsultStudent();
		request=(Map)ActionContext.getContext().get("request");
		request.put("allConsultStu", sc_list);
		return "allConsultStu";
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
	public String StudentUpdateUpload(){
		updateStudentUpload(student.getStuId());
		return "showStudentInfoPage";
	}
	public String ManagerUpdateUpload(){
		updateStudentUpload(student.getStuId());
		return "updateStuInfo";
	}
	public void updateStudentUpload(int id){
		//System.out.println("updateStudentUpload=================");
		upload();
		student = stuService.queryStudentById(id);
		student.setStuPhoto(this.getPath());
//		request=(Map)ActionContext.getContext().get("request");
//		request.put("student",student);
		session=(Map)ActionContext.getContext().getSession();
		session.put("student", student);
	}
	
	public String addStudentUpload(){
		boolean flag = upload();
		 StuInfo stu = new StuInfo();
         stu.setStuPhoto(this.getPath());
         request=(Map)ActionContext.getContext().get("request");
 		 request.put("student",stu);
		return "addStudentUpload";
	}
	public boolean upload(){
		System.out.println("upload action");
		  //根据服务器的文件保存地址和原文件名创建目录文件全路径  
        String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+ "/" + student.getStuAccount() + ".jpg";  
        String dstPathSave = "stu_photo/" + student.getStuAccount() + ".jpg";
		System.out.println("文件保存路径："+dstPath);
        System.out.println("上传的文件的类型："+ this.getUploadContentType());  
        if(this.getUploadContentType().startsWith("image")){
        	 File dstFile = new File(dstPath); 
             copy(this.upload, dstFile); 
             this.setPath(dstPathSave);
            // System.out.println("头像保存路径："+stu.getStuPhoto());
     		 return true;
        }else{
        	System.out.println("请上传图片格式的文件");
        	return false;
        }
	}
	/*
	 * 缴费函数
	 */
	public String Pay(){
		//System.out.println(stuconsult.getConsultCostType()+" action level");
		//System.out.println(stuconsult.getStuConsultId()+" ID action level");
		
		StuConsult sc_temp = stuService.queryStuConsultById(stuconsult.getStuConsultId());
		sc_temp.setConsultCostType(stuconsult.getConsultCostType());
		sc_temp.setConsultPay(true);
		stuService.updateStuConsult(sc_temp);
		return queryAllConsultStudent();
	}
	/*
	 * 删除咨询学员
	 */
	public String delteConsultStudent(){
		stuService.delteConsultStudent(stuconsult);
		return queryAllConsultStudent();
	}

	public Map<String, Object> getRequest_return() {
		return request_return;
	}

	public void setRequest_return(Map<String, Object> request_return) {
		this.request_return = request_return;
	}
	
	
	

}
