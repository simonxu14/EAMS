package com.eams.course.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.course.dao.CourseDao;
import com.eams.model.CourseInfo;
import com.eams.model.StuConsult;
import com.eams.model.StuInfo;
import com.eams.model.TeachInfo;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao{

	public List<CourseInfo> queryAllCourses() {
		List<CourseInfo> courses = getHibernateTemplate().find("from CourseInfo");
		return courses;
	}

	public void addCourse(CourseInfo course) {
		
		this.getHibernateTemplate().save(course);
	}

	public List<TeachInfo> queryAllTeachInfo() {
		List<TeachInfo> teachers = getHibernateTemplate().find("from TeachInfo");
		return teachers;
	}

	public void deleteCourse(CourseInfo courseDel) {
			CourseInfo c_temp = this.queryCourseById(courseDel.getCourseId());
			c_temp.setCourseValid(false);
			this.updateCourseInfo(c_temp);
	}

	public CourseInfo queryCourseById(int id) {
		CourseInfo c_temp = (CourseInfo) this.getHibernateTemplate().get(CourseInfo.class,id);
		return c_temp;
	}

	public void updateCourseInfo(CourseInfo courseUpdate) {
		System.out.println(courseUpdate.getCourseId() + "dao update course");
		this.getHibernateTemplate().update(courseUpdate);
	}

	public List<CourseInfo> queryCourseByTeacherId(int id) {
		Query q=this.getSession().createQuery("from CourseInfo ci where ci.teachInfo.teachId=:teacherId");
		q.setParameter("teacherId",id);
		List<CourseInfo> course_list = q.list();
		System.out.println("##^^^^^^^^");
		System.out.println(course_list.get(0).getCourseName());
		return course_list;
	}

	public TeachInfo queryTeacherById(int id) {
		Query q=this.getSession().createQuery("from TeachInfo ti where ti.teachId=:teacherId");
		q.setParameter("teacherId",id);
		TeachInfo teacher = (TeachInfo)q.uniqueResult();
		return teacher;
	}

}
