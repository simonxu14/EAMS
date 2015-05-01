package com.eams.teacher.teacherInfo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.model.CourseInfo;
import com.eams.model.TeachInfo;
import com.eams.model.TeachLevel;

import com.eams.teacher.teacherInfo.dao.TeaInfoDao;


public class TeaInfoDaoImpl extends HibernateDaoSupport implements TeaInfoDao{

	//查询所有教师信息
	public List<TeachInfo> queryAllInfo() {
		List<TeachInfo> info =getHibernateTemplate().find("from TeachInfo");
		return info;
	}
	
	//列出有效值(valid==1)为1的所有教师信息
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

	//新增教师信息
	public void addTeacherInfo(TeachInfo teacherInfo) {
		//设置有效位都是1（有效）
		teacherInfo.setTeachValid(true);
		System.out.println(teacherInfo.getTeachAccount());
		System.out.println("@@@@@@@");
		System.out.println(teacherInfo.getTeachId());
		this.getHibernateTemplate().save(teacherInfo);

		
	}

	//删除教师信息
	public boolean deleteTeacherInfo(int id){
		TeachInfo teacherInfo=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class, id);
		getHibernateTemplate().delete(teacherInfo);
		
		return true;
	}
	
	//假删除教师信息（即不在前台对用户显示，但实际保存于数据库中的数据）
	public boolean deleteTeacherInfoV(int id) {
		
		
		System.out.println("1111111111111111111");
		TeachInfo teacherInfo=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class,id);
		teacherInfo.setTeachValid(false);
		
		
		this.getHibernateTemplate().update(teacherInfo);
		System.out.println("teacherInfo.");
		System.out.println("1111111111111111111");
		return true;
	}

	
	//按id查找教师
	public TeachInfo queryById(int id) {
		TeachInfo ti=(TeachInfo)this.getHibernateTemplate().get(TeachInfo.class,id);
		return ti;
	}

	
	//修改教师信息
	public boolean updateTeaInfo(TeachInfo teacherInfo) {
		this.getHibernateTemplate().update(teacherInfo);
		return true;
	}
	
	//查询教师等级
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
