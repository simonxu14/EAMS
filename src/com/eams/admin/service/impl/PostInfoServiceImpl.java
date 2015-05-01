package com.eams.admin.service.impl;

import java.util.List;

import com.eams.admin.dao.PostInfoDao;
import com.eams.admin.service.PostInfoService;
import com.eams.model.PostInfo;

public class PostInfoServiceImpl implements PostInfoService {
	private PostInfoDao postInfoDao;
    
	public PostInfoDao getPostInfoDao() {
		return postInfoDao;
	}

	public void setPostInfoDao(PostInfoDao postInfoDao) {
		this.postInfoDao = postInfoDao;
	}

	@Override
	public List<PostInfo> queryAllPostInfo() {
		return postInfoDao.queryAll();
	}

	@Override
	public boolean addPostInfo(PostInfo postInfo) {
		if(postInfoDao.add(postInfo)){
			return true;			
		}
		else
			return false;

	}

	@Override
	public boolean deleteRealPostInfo(Integer postId) {
		if(postInfoDao.deleteReal(postId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public PostInfo forUpdatePostInfo(Integer postId) {
		PostInfo postInfo = postInfoDao.queryById(postId);
		return postInfo;
	}

	@Override
	public boolean updatePostInfo(PostInfo postInfo) {
			try {
				postInfoDao.update(postInfo);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	@Override
	public List<PostInfo> queryRealAllPostInfo() {
		return postInfoDao.queryRealAll();
	}

	@Override
	public boolean deletePostInfo(Integer postId) {
		if(postInfoDao.delete(postId)){
			return true;
		}
		else
			return false;
	}

	@Override
	public PostInfo queryPostById(Integer postId) {
		PostInfo postInfo = postInfoDao.queryById(postId);
		return postInfo;
	}

}
