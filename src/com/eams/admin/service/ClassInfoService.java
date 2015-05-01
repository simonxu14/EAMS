package com.eams.admin.service;

import java.util.List;

import com.eams.model.ClassInfo;

public interface ClassInfoService {

	public List<ClassInfo> queryAllClassInfo();

	public boolean addClassInfo(ClassInfo classInfo);

	public boolean deleteRealClassInfo(Integer classId);

	public ClassInfo forUpdateClassInfo(Integer classId);

	public boolean updateClassInfo(ClassInfo classInfo);

	public List<ClassInfo> queryRealAllClassInfo();

	public boolean deleteClassInfo(Integer classId);

	public ClassInfo queryClassById(Integer classId);

}
