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
	
	/*ͨ��ѧ�����ҿγ���Ϣ
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#checkCourseByStudent(com.eams.model.StuInfo)
	 */
	public List<StuCourse> checkCourseByStudent(StuInfo student) {
		return stuDao.checkCourseByStudent(student);
	}

	/*
	 * ɾ����ѡ�γ���Ϣ
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#deleteStuCourse(com.eams.model.StuCourse)
	 */
	public void deleteStuCourse(StuCourse stucourse) {
		stuDao.deleteStuCourse(stucourse);
	}

	/*
	 * ��ѯ���пγ���Ϣ
	 * (non-Javadoc)
	 * @see com.eams.student.service.StuInfoService#checkAllCourse()
	 */
	public List<CourseInfo> checkAllCourse() {
		return stuDao.checkAllCourse();
	}

	/*
	 * ѡ��
	 * �γ�ʱ�����ã�ÿһ�ڶ��Ǵ�xx:00 -- xx:50 ÿ�ڿ�ʱ��50����
	 * 		��ȥ�ж������Ƿ���ͬ�⣬ֻ��Ҫ�ж�Сʱ���Ƿ����
	 * 		��ÿһ����ռ��һ��Сʱ���Ŀγ�ֻ����һ��
	 * (non-Javadoc)
	 * return 1:�γ��Ѵ���  2:�γ�ʱ���ͻ�޷�ѡ�� 0:�γ���ӳɹ�
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
			System.out.println("�γ��Ѵ��ڣ������ظ����");//�γ��Ѿ����ڣ�ѡ��ʧ��
			return 1;
		}else{
			for(int i = 0; i < stuCourse.size(); i++){
				//���õ�ǰѭ������ѡ�γ̵Ŀ�ʼʱ��
				time_temp_start.setTime(stuCourse.get(i).getCourseInfo().getCourseStart());
				//�жϸ���ѡ�γ̺���ѡ�γ̵������Ƿ���ȣ��������ֱ�ӽ�������ѭ��������ֱ�����
				if(time_temp_start.get(Calendar.DAY_OF_MONTH) != time_chose_cos_start.get(Calendar.DAY_OF_MONTH)){
					continue;
				}
				//�жϸ���ѡ�γ̺���ѡ�γ̵�Сʱ���Ƿ���ȣ��������ֱ�ӽ�������ѭ��������ֱ�����
				else if(time_temp_start.get(Calendar.HOUR_OF_DAY) != time_chose_cos_start.get(Calendar.HOUR_OF_DAY)){
					continue;
				}
				//�ÿγ̵����ں�Сʱ��������ѡ�γ̳�ͻ���޷�ѡ�Σ�����false
				else{
					System.out.println("���ڳ�ͻ���޷�ѡ��");
					return 2;
				}
			}
			//ͨ������ѭ��������ѡ��
			System.out.println("@@@@@@@@@@@");
			stuDao.AddStuCourse(sc);
			return 0;
		}
	}

	/*
	 * �޸ĸ�����Ϣ
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
	 * ��ѯ����ѧ����Ϣ
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
