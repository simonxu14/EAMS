package com.eams.course.service.impl;

import java.util.Calendar;
import java.util.List;

import com.eams.course.dao.CourseDao;
import com.eams.course.service.CourseService;
import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;

public class CourseServiceImpl implements CourseService{

	private CourseDao courseDao;
	

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	/*
	 * ��ѯ���пγ���Ϣ����
	 * (non-Javadoc)
	 * @see com.eams.course.service.CourseService#queryAllCourses()
	 */
	public List<CourseInfo> queryAllCourses() {
		List<CourseInfo> allCourses = courseDao.queryAllCourses();
		System.out.println("query all courses " + allCourses.size());
		for(int i = 0; i < allCourses.size(); i++){
			if(!allCourses.get(i).getCourseValid()){
				allCourses.remove(i);
				i--;
			}
		}
		System.out.println("query all courses " + allCourses.size());
		return allCourses;
	}
	
	public int addCourse(CourseInfo course) {
		int flag = CheckCourseConflict(course);
		if(flag == 0){
			course.setCourseValid(true);
			courseDao.addCourse(course);
		}
		return flag;
	}
	
	/*
	 * ����0��ʾ���ͨ����������ӻ��߸���
	 * ����1��ʾ����ʦ���ڳ�ͻ
	 * ����2��ʾ����ʦʱ���ͻ
	 * ����3��ʾ�������γ̳�ͻ
	 * (non-Javadoc)
	 * @see com.eams.course.service.CourseService#CheckCourseConflict(com.eams.model.CourseInfo)
	 */
	public int CheckCourseConflict(CourseInfo course) {
		
		System.out.println("check course conflict "+course.getTeachInfo().getTeachId()+" "+course.getTeachInfo().getTeachName());
		//ȡ����ǰ�γ��ο���ʦ�����пγ�
		List<CourseInfo> teacherCourses = courseDao.queryCourseByTeacherId(course.getTeachInfo().getTeachId());
		Calendar startTime_temp = Calendar.getInstance();
		
		//ȡ���ο���ʦ�Ŀ�ʼ�ͽ���ʱ��
		TeachInfo teacher = courseDao.queryTeacherById(course.getTeachInfo().getTeachId());
		Calendar teacherStartTime = Calendar.getInstance();//��ʼʱ��
		Calendar teacherEndTime = Calendar.getInstance();//����ʱ��
		teacherStartTime.setTime(teacher.getTeachStart());
		teacherEndTime.setTime(teacher.getTeachEnd());
		
		Calendar addCourseTimeStart = Calendar.getInstance();//����ӿγ̵Ŀ�ʼʱ��
		Calendar addCourseTimeEnd = Calendar.getInstance();//����ӿγ̵Ľ���ʱ��
		addCourseTimeStart.setTime(course.getCourseStart());//���ÿ�ʼʱ���ֵ
		addCourseTimeEnd.setTime(course.getCourseEnd());//���ý���ʱ���ֵ
		
		if(teacherStartTime.get(Calendar.DAY_OF_MONTH) != addCourseTimeStart.get(Calendar.DAY_OF_MONTH)){
			//System.out.println("��ʦ��ʼʱ��" + teacherStartTime.get(Calendar.DAY_OF_MONTH));
			//System.out.println("�γ̿�ʼʱ��" + addCourseTimeStart.get(Calendar.DAY_OF_MONTH));			
			System.out.println("��ӿγ�����ʦʱ������ڳ�ͻ");
			return 1;//��ӿγ�����ʦʱ������ڳ�ͻ������false
		}
		else if(teacherStartTime.get(Calendar.HOUR_OF_DAY) > addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
			System.out.println("��ӿγ̵Ŀ�ʼʱ��С����ʦ�Ŀ�ʼʱ��");
			return 2;//��ӿγ̵Ŀ�ʼʱ��С����ʦ�Ŀ�ʼʱ�䣬����false
		}
		else if(teacherEndTime.get(Calendar.HOUR_OF_DAY) <= addCourseTimeEnd.get(Calendar.HOUR_OF_DAY)){
			System.out.println("��ӿγ̵Ľ���ʱ����ڻ��ߵ�����ʦ�Ľ���ʱ��");
			return 2;//��ӿγ̵Ľ���ʱ����ڻ��ߵ�����ʦ�Ľ���ʱ�䣬����false
		}
		else{
			//ɾ���γ����Ѿ�ʧЧ�ļ�¼
			for(int i = 0; i < teacherCourses.size(); i++){
				if(teacherCourses.get(i).getCourseValid()){
					teacherCourses.remove(i);
				}
			}
			//�γ����Ѿ�����ID ��ʾ����γ��Ǹ��²���
			if(course.getCourseId() != null){
				for(int i = 0; i < teacherCourses.size(); i++){
					if(course.getCourseId().equals(teacherCourses.get(i).getCourseId())){
						continue;
					}
					startTime_temp.setTime(teacherCourses.get(i).getCourseStart());
					if(startTime_temp.get(Calendar.HOUR_OF_DAY) == addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
						System.out.println(teacherCourses.get(i).getCourseName()+" �γ��� ����ӿγ�ʱ���ͻ update");
						return 3;//��ӿγ̺���ʦ���еĿγ̳�ͻ������false
					}
					else{
						continue;
					}
				}
			//û��ID��ʾ������ӵĿγ�
			}else{
				for(int i = 0; i < teacherCourses.size(); i++){
					startTime_temp.setTime(teacherCourses.get(i).getCourseStart());
					if(startTime_temp.get(Calendar.HOUR_OF_DAY) == addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
						System.out.println(teacherCourses.get(i).getCourseName()+" �γ��� ����ӿγ�ʱ���ͻ");
						return 3;//��ӿγ̺���ʦ���еĿγ̳�ͻ������false
					}
					else{
						continue;
					}
				}
			}
		}
		//ѭ��������������ӿγ�
		
		return 0;
	}

	public List<TeachInfo> queryAllTeachInfo() {
		return courseDao.queryAllTeachInfo();
	}

	public void deleteCourse(CourseInfo courseDel) {
		courseDao.deleteCourse(courseDel);
	}

	public CourseInfo queryCourseById(int id) {
		return courseDao.queryCourseById(id);
	}

	public int updateCourseInfo(CourseInfo courseUpdate) {
		TeachInfo teacher = courseDao.queryTeacherById(courseUpdate.getTeachInfo().getTeachId());
		courseUpdate.setTeachInfo(teacher);
		
		int flag = CheckCourseConflict(courseUpdate);
		
		if(flag == 0){
			List<CourseInfo> teacherCourses = courseDao.queryCourseByTeacherId(courseUpdate.getTeachInfo().getTeachId());
			for(int i=0;i<teacherCourses.size();i++){
				CourseInfo ci=teacherCourses.get(i);	
				if(ci.getCourseId().equals(courseUpdate.getCourseId())){
					ci.setCourseComment(courseUpdate.getCourseComment());
					ci.setTeachInfo(teacher);
					ci.setCourseRemain(courseUpdate.getCourseRemain());	
					ci.setCourseStart(courseUpdate.getCourseStart());
					ci.setCourseEnd(courseUpdate.getCourseEnd());
					ci.setCourseMajor(courseUpdate.getCourseMajor());
				}
			}
		}
		return flag;
	}

	public List<CourseInfo> queryCourseByTeacherId(int id) {
		return courseDao.queryCourseByTeacherId(id);
	}

	}
