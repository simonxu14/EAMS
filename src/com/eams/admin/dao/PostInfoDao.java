package com.eams.admin.dao;

import java.util.List;

import com.eams.model.PostInfo;

public interface PostInfoDao {

	public List<PostInfo> queryAll();

	public boolean add(PostInfo postInfo);

	public boolean deleteReal(Integer postId);

	public PostInfo queryById(Integer postId);

	public void update(PostInfo postInfo);

	public List<PostInfo> queryRealAll();

	public boolean delete(Integer postId);

}
