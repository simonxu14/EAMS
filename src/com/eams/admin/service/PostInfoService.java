package com.eams.admin.service;

import java.util.List;

import com.eams.model.PostInfo;

public interface PostInfoService {

	public List<PostInfo> queryAllPostInfo();

	public boolean addPostInfo(PostInfo postInfo);

	public boolean deleteRealPostInfo(Integer postId);

	public PostInfo forUpdatePostInfo(Integer postId);

	public boolean updatePostInfo(PostInfo postInfo);

	public List<PostInfo> queryRealAllPostInfo();

	public boolean deletePostInfo(Integer postId);

	public PostInfo queryPostById(Integer postId);

}
