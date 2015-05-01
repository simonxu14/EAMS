package com.eams.student.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.StuCheck;
import com.eams.model.StuConsult;
import com.eams.model.StuCourse;
import com.eams.model.StuInfo;
import com.eams.student.dao.StuInfoDao;
import com.eams.student.service.StuInfoService;

public class StuInfoServiceImpl implements StuInfoService{

	private StuInfoDao stuDao;
	
	

	public StuInfoDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(StuInfoDao stuDao) {
		this.stuDao = stuDao;
	}

	public StuInfo CheckStudent(StuInfo student) {
		
			return stuDao.CheckStudent(student);
		
	}

	public void addConsultStudent(StuConsult stuconsult) {
		stuconsult.setConsultValid(true);
		stuDao.addConsultStudent(stuconsult);
	}
	
	/*通过学生查找课程信息
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#checkCourseByStudent(com.eams.model.StuInfo)
	 */
	public List<StuCourse> checkCourseByStudent(StuInfo student) {
		return stuDao.checkCourseByStudent(student);
	}

	/*
	 * 删除所选课程信息
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#deleteStuCourse(com.eams.model.StuCourse)
	 */
	public void deleteStuCourse(StuCourse stucourse) {
		stuDao.deleteStuCourse(stucourse);
	}

	/*
	 * 查询所有课程信息
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#checkAllCourse()
	 */
	public List<CourseInfo> checkAllCourse() {
		return stuDao.checkAllCourse();
	}

	/*
	 * 选课
	 * 课程时间设置：每一节都是从xx:00 -- xx:50 每节课时常50分钟
	 * 		除去判断日期是否相同外，只需要判断小时数是否相等
	 * 		在每一天中占据一个小时数的课程只能有一门
	 * (non-Javadoc)
	 * return 1:课程已存在  2:课程时间冲突无法选课 0:课程添加成功
	 * @see com.eams.student.service.StuInfoService#AddStuCourse(com.eams.model.StuInfo, com.eams.model.CourseInfo)
	 */
	public int AddStuCourse(StuInfo stu, CourseInfo course) {
		StuCourse sc = new StuCourse();
		List<StuCourse> stuCourse = stuDao.checkCourseByStudent(stu);
		CourseInfo course_choosen = stuDao.queryCourseById(course.getCourseId());
		System.out.println(course_choosen.getCourseName());
		System.out.println("################");
		sc.setCourseInfo(course_choosen);
		sc.setStuInfo(stu);
		System.out.println(sc.getCourseInfo().getCourseName());
		System.out.println("################");
		System.out.println(sc.getStuInfo().getStuName());
		System.out.println("################");
		
		Calendar time_chose_cos_start = Calendar.getInstance();
		
		Calendar time_temp_start = Calendar.getInstance();
		
		time_chose_cos_start.setTime(course_choosen.getCourseStart());
		
		if(stuDao.CheckStuCourseConflict(sc) != null){
			System.out.println("课程已存在，请勿重复添加");//课程已经存在，选课失败
			return 1;
		}else{
			for(int i = 0; i < stuCourse.size(); i++){
				//设置当前循环的已选课程的开始时间
				time_temp_start.setTime(stuCourse.get(i).getCourseInfo().getCourseStart());
				//判断该已选课程和所选课程的日期是否相等，不相等则直接结束本次循环，可以直接添加
				if(time_temp_start.get(Calendar.DAY_OF_MONTH) != time_chose_cos_start.get(Calendar.DAY_OF_MONTH)){
					continue;
				}
				//判断该已选课程和所选课程的小时数是否相等，不相等则直接结束本次循环，可以直接添加
				else if(time_temp_start.get(Calendar.HOUR_OF_DAY) != time_chose_cos_start.get(Calendar.HOUR_OF_DAY)){
					continue;
				}
				//该课程的日期和小时数都与所选课程冲突，无法选课，返回false
				else{
					System.out.println("日期冲突，无法选课");
					return 2;
				}
			}
			//通过所有循环，可以选课
			System.out.println("@@@@@@@@@@@");
			stuDao.AddStuCourse(sc);
			return 0;
		}
	}

	/*
	 * 修改个人信息
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#updateStuInfo(com.eams.model.StuInfo)
	 */
	public StuInfo updateStuInfo(StuInfo student) {
		if(student.getStuValid()==null){
			student.setStuValid(true);
		}
		if(!student.getStuValid()){
			student.setStuValid(true);
		}
		return stuDao.updateStuInfo(student);
	}

	/*
	 * 查询所有学生信息
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#queryAllStudent()
	 */
	public List<StuInfo> queryAllStudent() {
		List<StuInfo> stuList = stuDao.queryAllStudent();
		for(int i = 0; i < stuList.size(); i++){
			if(!stuList.get(i).getStuValid()){
				stuList.remove(i);
				i--;
			}
		}
		return stuList;
	}

	public void deleteStudent(StuInfo student) {
		//stuDao.deleteStudent(student);
		StuInfo stu_temp = stuDao.queryStudentById(student.getStuId());
		stu_temp.setStuValid(false);
		stuDao.updateStuInfo(stu_temp);
	}

	public StuInfo queryStudentById(int id) {
		return stuDao.queryStudentById(id);
	}

	public List<StuCheck> queryStuCheckByCourse(CourseInfo course) {
		return stuDao.queryStuCheckByCourse(course);
	}

	public void addStudent(StuInfo student) {
		student.setStuValid(true);
		stuDao.addStudent(student);		
	}

	public List<StuInfo> queryStudentByConditon(StuInfo student) {
		List<StuInfo> slist = new ArrayList<StuInfo>();
		if(student.getStuId() != null){
			StuInfo stu = stuDao.queryStudentById(student.getStuId());
			slist.add(stu);
			return slist;
		}else if(student.getStuMajor() != null){
			slist = stuDao.queryStudentByMajor(student);
			return slist;
		}else{
			return stuDao.queryAllStudent();
		}
	}

	public List<StuConsult> queryAllConsultStudent() {
		return stuDao.queryAllConsultStudent();
	}

	public StuConsult queryStuConsultById(int id) {
		return stuDao.queryStuConsultById(id);
	}

	public void updateStuConsult(StuConsult stuconsult) {
		addConsultToStudentAfterPay(stuconsult);
		stuDao.updateStuConsult(stuconsult);
	}

	public void delteConsultStudent(StuConsult stuconsult) {
		stuDao.delteConsultStudent(stuconsult);
	}
	
	public void addConsultToStudentAfterPay(StuConsult stuconsult){
		StuInfo student = new StuInfo();
		student.setStuName(stuconsult.getStuConsultName());
		if(stuconsult.getConsultSex()){
			student.setStuSex(1);
		}else{
			student.setStuSex(0);
		}
		student.setStuSchool(stuconsult.getConsultSchool());
		student.setStuTel(stuconsult.getConsulTel());
		student.setStuAddress(stuconsult.getConsultAddress());
		student.setStuMajor(stuconsult.getConsultMajor());
		student.setStuComment(stuconsult.getConsultComment());
		if(stuconsult.getConsultCostType().equals("Actual Cost")){
			student.setStuBalance( Integer.parseInt(new java.text.DecimalFormat("0").format(stuconsult.getConsultCost())) );
		}else if(stuconsult.getConsultCostType().equals("1000 9.8 discount")){
			student.setStuBalance(1000);
		}else if(stuconsult.getConsultCostType().equals("2000 9.5 discount")){
			student.setStuBalance(2000);
		}else if(stuconsult.getConsultCostType().equals("3000 9.2 discount")){
			student.setStuBalance(3000);
		}else{
			student.setStuBalance(10000);
			System.out.println("service add Consult Student" + student.getStuBalance());
		}
		addStudent(student);
	}


}
