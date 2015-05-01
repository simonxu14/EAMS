package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.GradeInfoDao;
import com.eams.admin.service.GradeInfoService;
import com.eams.model.GradeInfo;

public class GradeInfoServiceImpl implements GradeInfoService {
	private GradeInfoDao gradeInfoDao;
    
	public GradeInfoDao getGradeInfoDao() {
		return gradeInfoDao;
	}

	public void setGradeInfoDao(GradeInfoDao gradeInfoDao) {
		this.gradeInfoDao = gradeInfoDao;
	}

	@Override
	public List<GradeInfo> queryAllGradeInfo() {
		return gradeInfoDao.queryAll();
	}

	@Override
	public boolean addGradeInfo(GradeInfo gradeInfo) {
		if(gradeInfoDao.add(gradeInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealGradeInfo(Integer gradeId) {
		if(gradeInfoDao.deleteReal(gradeId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public GradeInfo forUpdateGradeInfo(Integer gradeId) {
		GradeInfo gradeInfo = gradeInfoDao.queryById(gradeId);
		return gradeInfo;
	}
	
	public GradeInfo queryGradeById(Integer gradeId) {
		GradeInfo gradeInfo = gradeInfoDao.queryById(gradeId);
		return gradeInfo;
	}

	@Override
	public boolean updateGradeInfo(GradeInfo gradeInfo) {
			try {
				gradeInfoDao.update(gradeInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<GradeInfo> queryRealAllGradeInfo() {
		return gradeInfoDao.queryRealAll();
	}

	@Override
	public boolean deleteGradeInfo(Integer gradeId) {
		if(gradeInfoDao.delete(gradeId)){
			return true;
		}
		else
			return false;
	}

}
