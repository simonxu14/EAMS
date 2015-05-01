package com.eams.student.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.model.CourseInfo;
import com.eams.model.StuCheck;
import com.eams.model.StuConsult;
import com.eams.model.StuCourse;
import com.eams.model.StuInfo;
import com.eams.student.dao.StuInfoDao;


public class StuInfoDaoImpl extends HibernateDaoSupport implements StuInfoDao{

	public StuInfo CheckStudent(StuInfo student) {
		//System.out.println(student.getStuAccount());
		Query q=this.getSession().createQuery("from StuInfo s where s.stuAccount=:account and s.stuPassword=:password");
		q.setParameter("account",student.getStuAccount());
		q.setParameter("password",student.getStuPassword());
		 StuInfo s=( StuInfo)q.uniqueResult();
		return s;
	}

	public void addConsultStudent(StuConsult stuconsult) {
		this.getHibernateTemplate().save(stuconsult);
	}

	public List<StuCourse> checkCourseByStudent(StuInfo student) {
		//System.out.println("dao level " + student.getStuAccount());
		
		Query q=this.getSession().createQuery("from StuCourse sc where sc.stuInfo=:student");
		//Query q=this.getSession().createQuery("from CourseInfo ci, StuCourse sc where ci.courseId = sc.courseInfo.courseId");
		q.setParameter("student",student);
		List<StuCourse> stu_courses = q.list();
		//System.out.println(stu_courses.size()+" size");
		//System.out.println(stu_courses.get(0).getCourseInfo().getCourseName());
		
		return stu_courses;
		
		}

	public void deleteStuCourse(StuCourse stucourse) {
		StuCourse sc_temp=(StuCourse)this.getHibernateTemplate().get(StuCourse.class,stucourse.getStuCourseId());
		getHibernateTemplate().delete(sc_temp);
		
	}

	public List<CourseInfo> checkAllCourse() {
		Query q=this.getSession().createQuery("from CourseInfo ci");
		List<CourseInfo> allCourses = q.list();
		return allCourses;
	}

	public void AddStuCourse(StuCourse stuCourseAdd) {
		System.out.println("123123");
		System.out.println(stuCourseAdd.getStuInfo().getStuId());
		System.out.println("123123123123");
		System.out.println(stuCourseAdd.getStuInfo().getStuName());
		System.out.println("123123123123123123123123");
		System.out.println(stuCourseAdd.getCourseInfo().getCourseName());
		System.out.println("123123123123123123123123123123123123");
		System.out.println(stuCourseAdd.getCourseInfo().getCourseId());
		this.getHibernateTemplate().save(stuCourseAdd);
	}

	public StuCourse CheckStuCourseConflict(StuCourse stuCourse) {
		Query q=this.getSession().createQuery("from StuCourse sc where sc.stuInfo=:student and sc.courseInfo=:course");
		q.setParameter("student",stuCourse.getStuInfo());
		q.setParameter("course",stuCourse.getCourseInfo());
		StuCourse sc = (StuCourse)q.uniqueResult();
		return sc;
	}

	public StuInfo updateStuInfo(StuInfo student) {
		//System.out.println("dao level update" + student.getStuName());
		this.getHibernateTemplate().update(student);
		return CheckStudent(student);
	}

	public List<StuInfo> queryAllStudent() {
		Query q=this.getSession().createQuery("from StuInfo si");
		List<StuInfo> s = q.list();
		return s;
	}

	public void deleteStudent(StuInfo student) {
		StuInfo s_temp=(StuInfo) this.getHibernateTemplate().get(StuInfo.class,student.getStuId());
		getHibernateTemplate().delete(s_temp);
	}

	public StuInfo queryStudentById(int id) {
		StuInfo s_temp=(StuInfo) this.getHibernateTemplate().get(StuInfo.class,id);
		return s_temp;
	}

	public List<StuCheck> queryStuCheckByCourse(CourseInfo course) {
		Query q=this.getSession().createQuery("from StuCheck sc where sc.courseInfo=:course");
		q.setParameter("course",course);
		List<StuCheck> sc_list = q.list();
		return sc_list;
	}

	public void addStudent(StuInfo student) {
		this.getHibernateTemplate().save(student);	
	}

	public List<StuInfo> queryStudentByMajor(StuInfo student) {
		Query q=this.getSession().createQuery("from StuInfo s where s.stuMajor=:major");
		q.setParameter("major",student.getStuMajor());
		List<StuInfo> s=q.list();
		return s;
	}

	public List<StuConsult> queryAllConsultStudent() {
		Query q=this.getSession().createQuery("from StuConsult sc");
		List<StuConsult> sc_list = q.list();
		//System.out.println("queryAllConsultStudent" + sc_list.size());
		return sc_list;
	}

	public CourseInfo queryCourseById(int id) {
		Query q=this.getSession().createQuery("from CourseInfo c where c.courseId=:id");
		q.setParameter("id",id);
		CourseInfo c = (CourseInfo)q.uniqueResult();
		return c;
	}

	public StuConsult queryStuConsultById(int id) {
		StuConsult s_temp=(StuConsult) this.getHibernateTemplate().get(StuConsult.class,id);
		return s_temp;
	}

	public void updateStuConsult(StuConsult stuconsult) {
		this.getHibernateTemplate().update(stuconsult);
	}

	public void delteConsultStudent(StuConsult stuconsult) {
		StuConsult s_temp=(StuConsult) this.getHibernateTemplate().get(StuConsult.class,stuconsult.getStuConsultId());
		getHibernateTemplate().delete(s_temp);
	}

}
