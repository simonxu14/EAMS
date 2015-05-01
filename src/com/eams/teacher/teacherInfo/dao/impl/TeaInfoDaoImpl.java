package com.eams.teacher.teacherInfo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;

import com.eams.teacher.teacherInfo.dao.TeaInfoDao;


public class TeaInfoDaoImpl extends HibernateDaoSupport implements TeaInfoDao{

	//��ѯ���н�ʦ��Ϣ
	public List<TeachInfo> queryAllInfo() {
		List<TeachInfo> info =getHibernateTemplate().find("from TeachInfo");
		return info;
	}
	
	//�г���Чֵ(valid==1)Ϊ1�����н�ʦ��Ϣ
	public List<TeachInfo> queryAllInfoV() {
		List<TeachInfo> info =getHibernateTemplate().find("from TeachInfo");
		int i;
		System.out.println("123"+info.size());
		for(i=0; i<info.size(); i++){
			if(info.get(i).getTeachValid()== false){
				System.out.println(info.get(i).getTeachName());
				info.remove(i);
				i = i-1;
			}
		}
		return info;
	}

	//������ʦ��Ϣ
	public void addTeacherInfo(TeachInfo teacherInfo) {
		//������Чλ����1����Ч��
		teacherInfo.setTeachValid(true);
		System.out.println(teacherInfo.getTeachAccount());
		System.out.println("@@@@@@@");
		System.out.println(teacherInfo.getTeachId());
		this.getHibernateTemplate().save(teacherInfo);

		
	}

	//ɾ����ʦ��Ϣ
	public boolean deleteTeacherInfo(int id){
		TeachInfo teacherInfo=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class, id);
		getHibernateTemplate().delete(teacherInfo);
		
		return true;
	}
	
	//��ɾ����ʦ��Ϣ��������ǰ̨���û���ʾ����ʵ�ʱ��������ݿ��е����ݣ�
	public boolean deleteTeacherInfoV(int id) {
		
		
		System.out.println("1111111111111111111");
		TeachInfo teacherInfo=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class,id);
		teacherInfo.setTeachValid(false);
		
		
		this.getHibernateTemplate().update(teacherInfo);
		System.out.println("teacherInfo.");
		System.out.println("1111111111111111111");
		return true;
	}

	
	//��id���ҽ�ʦ
	public TeachInfo queryById(int id) {
		TeachInfo ti=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class,id);
		return ti;
	}

	
	//�޸Ľ�ʦ��Ϣ
	public boolean updateTeaInfo(TeachInfo teacherInfo) {
		this.getHibernateTemplate().update(teacherInfo);
		return true;
	}
	
	//��ѯ��ʦ�ȼ�
	public List<TeachLevel> queryTeachLevel() {
		List<TeachLevel> info =getHibernateTemplate().find("from TeachLevel");
		return info;
	}

	public TeachInfo checkTeacher(TeachInfo teacherInfo) {
		Query q=this.getSession().createQuery("from TeachInfo t where t.teachAccount=:teachAccount and t.teachPsd=:teachPsd");
		q.setParameter("teachAccount",teacherInfo.getTeachAccount());
		q.setParameter("teachPsd",teacherInfo.getTeachPsd());
		TeachInfo t=(TeachInfo)q.uniqueResult();
		return t;
	}

	@Override
	public TeachInfo queryTeacherById(TeachInfo teachInfo) {
		TeachInfo teacherInfo=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class, teachInfo.getTeachId());
		return teacherInfo;
	}
	
	
	public List<CourseInfo> queryCourseByTeacherId(int id) {
		Query q=this.getSession().createQuery("from CourseInfo ci where ci.teachInfo.teachId=:teacherId");
		q.setParameter("teacherId",id);
		List<CourseInfo> course_list = q.list();
		System.out.println("##^^^^^^^^");
		System.out.println(course_list.get(0).getCourseName());
		return course_list;
	}

	@Override
	public List<CourseInfo> queryAllCourses() {
		List<CourseInfo> courses = getHibernateTemplate().find("from CourseInfo");
		return courses;
	}
	
	public List<TeachLevel> queryAllLevelsV() {
		List<TeachLevel> levels = getHibernateTemplate().find("from TeachLevel");
		int i;
		for(i=0;i<levels.size();i++){
			if(levels.get(i).getTeachLevelValid() == false){
				System.out.println(levels.get(i).getTeachLevelName());
				levels.remove(i);
				i = i-1;
			}
		}
		return levels;
	}

}
