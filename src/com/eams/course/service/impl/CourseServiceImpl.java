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
	 * 查询所有课程信息方法
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
	 * 返回0表示检测通过，可以添加或者更改
	 * 返回1表示和老师日期冲突
	 * 返回2表示和老师时间冲突
	 * 返回3表示和其他课程冲突
	 * (non-Javadoc)
	 * @see com.eams.course.service.CourseService#CheckCourseConflict(com.eams.model.CourseInfo)
	 */
	public int CheckCourseConflict(CourseInfo course) {
		
		System.out.println("check course conflict "+course.getTeachInfo().getTeachId()+" "+course.getTeachInfo().getTeachName());
		//取出当前课程任课老师的所有课程
		List<CourseInfo> teacherCourses = courseDao.queryCourseByTeacherId(course.getTeachInfo().getTeachId());
		Calendar startTime_temp = Calendar.getInstance();
		
		//取出任课老师的开始和结束时间
		TeachInfo teacher = courseDao.queryTeacherById(course.getTeachInfo().getTeachId());
		Calendar teacherStartTime = Calendar.getInstance();//开始时间
		Calendar teacherEndTime = Calendar.getInstance();//结束时间
		teacherStartTime.setTime(teacher.getTeachStart());
		teacherEndTime.setTime(teacher.getTeachEnd());
		
		Calendar addCourseTimeStart = Calendar.getInstance();//所添加课程的开始时间
		Calendar addCourseTimeEnd = Calendar.getInstance();//所添加课程的结束时间
		addCourseTimeStart.setTime(course.getCourseStart());//设置开始时间的值
		addCourseTimeEnd.setTime(course.getCourseEnd());//设置结束时间的值
		
		if(teacherStartTime.get(Calendar.DAY_OF_MONTH) != addCourseTimeStart.get(Calendar.DAY_OF_MONTH)){
			//System.out.println("老师开始时间" + teacherStartTime.get(Calendar.DAY_OF_MONTH));
			//System.out.println("课程开始时间" + addCourseTimeStart.get(Calendar.DAY_OF_MONTH));			
			System.out.println("添加课程与老师时间的日期冲突");
			return 1;//添加课程与老师时间的日期冲突，返回false
		}
		else if(teacherStartTime.get(Calendar.HOUR_OF_DAY) > addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
			System.out.println("添加课程的开始时间小于老师的开始时间");
			return 2;//添加课程的开始时间小于老师的开始时间，返回false
		}
		else if(teacherEndTime.get(Calendar.HOUR_OF_DAY) <= addCourseTimeEnd.get(Calendar.HOUR_OF_DAY)){
			System.out.println("添加课程的结束时间大于或者等于老师的结束时间");
			return 2;//添加课程的结束时间大于或者等于老师的结束时间，返回false
		}
		else{
			//删除课程中已经失效的记录
			for(int i = 0; i < teacherCourses.size(); i++){
				if(teacherCourses.get(i).getCourseValid()){
					teacherCourses.remove(i);
				}
			}
			//课程中已经有了ID 表示这个课程是更新操作
			if(course.getCourseId() != null){
				for(int i = 0; i < teacherCourses.size(); i++){
					if(course.getCourseId().equals(teacherCourses.get(i).getCourseId())){
						continue;
					}
					startTime_temp.setTime(teacherCourses.get(i).getCourseStart());
					if(startTime_temp.get(Calendar.HOUR_OF_DAY) == addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
						System.out.println(teacherCourses.get(i).getCourseName()+" 课程与 所添加课程时间冲突 update");
						return 3;//添加课程和老师已有的课程冲突，返回false
					}
					else{
						continue;
					}
				}
			//没有ID表示这是添加的课程
			}else{
				for(int i = 0; i < teacherCourses.size(); i++){
					startTime_temp.setTime(teacherCourses.get(i).getCourseStart());
					if(startTime_temp.get(Calendar.HOUR_OF_DAY) == addCourseTimeStart.get(Calendar.HOUR_OF_DAY)){
						System.out.println(teacherCourses.get(i).getCourseName()+" 课程与 所添加课程时间冲突");
						return 3;//添加课程和老师已有的课程冲突，返回false
					}
					else{
						continue;
					}
				}
			}
		}
		//循环结束，可以添加课程
		
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
