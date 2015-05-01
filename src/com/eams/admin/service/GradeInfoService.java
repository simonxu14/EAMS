package com.eams.admin.service;

import java.util.List;

import com.eams.model.GradeInfo;

public interface GradeInfoService {

	public List<GradeInfo> queryAllGradeInfo();

	public boolean addGradeInfo(GradeInfo gradeInfo);

	public boolean deleteRealGradeInfo(Integer gradeId);

	public GradeInfo forUpdateGradeInfo(Integer gradeId);

	public boolean updateGradeInfo(GradeInfo gradeInfo);

	public List<GradeInfo> queryRealAllGradeInfo();

	public boolean deleteGradeInfo(Integer gradeId);
	
	public GradeInfo queryGradeById(Integer gradeId);

}
