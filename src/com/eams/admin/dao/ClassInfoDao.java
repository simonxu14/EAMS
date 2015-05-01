package com.eams.admin.dao;

import java.util.List;

import com.eams.model.ClassInfo;

public interface ClassInfoDao {

	public List<ClassInfo> queryAll();

	public boolean add(ClassInfo classInfo);

	public boolean deleteReal(Integer classId);

	public ClassInfo queryById(Integer classId);

	public void update(ClassInfo classInfo);

	public List<ClassInfo> queryRealAll();

	public boolean delete(Integer classId);

}
