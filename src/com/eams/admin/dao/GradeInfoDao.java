package com.eams.admin.dao;

import java.util.List;

import com.eams.model.GradeInfo;

public interface GradeInfoDao {

	public List<GradeInfo> queryAll();

	public boolean add(GradeInfo gradeInfo);

	public boolean deleteReal(Integer gradeId);

	public GradeInfo queryById(Integer gradeId);

	public void update(GradeInfo gradeInfo);

	public List<GradeInfo> queryRealAll();

	public boolean delete(Integer gradeId);

}
