package com.eams.student.service;

import java.util.List;

import com.eams.model.CourseInfo;
import com.eams.model.StuCheck;
import com.eams.model.StuConsult;
import com.eams.model.StuCourse;
import com.eams.model.StuInfo;

public interface StuInfoService {
	public StuInfo CheckStudent(StuInfo student);
	public StuInfo updateStuInfo(StuInfo student);
	public void addConsultStudent(StuConsult stuconsult);
	public List<StuCourse> checkCourseByStudent(StuInfo student);
	public void deleteStuCourse(StuCourse stucourse);
	public List<CourseInfo> checkAllCourse();
	public int AddStuCourse(StuInfo stu, CourseInfo course);
	public List<StuInfo> queryAllStudent();
	public void deleteStudent(StuInfo student);
	public StuInfo queryStudentById(int id);
	public List<StuCheck> queryStuCheckByCourse(CourseInfo course);
	public void addStudent(StuInfo student);
	public List<StuInfo> queryStudentByConditon(StuInfo student);
	public List<StuConsult> queryAllConsultStudent();
	public StuConsult queryStuConsultById(int id);
	public void updateStuConsult(StuConsult stuconsult);
	public void delteConsultStudent(StuConsult stuconsult);
}
