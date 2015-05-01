package com.eams.admin.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.eams.admin.dao.PostInfoDao;
import com.eams.model.PostInfo;

public class PostInfoDaoImpl extends HibernateDaoSupport implements PostInfoDao {

	@Override
	public List<PostInfo> queryRealAll() {
		List<PostInfo> postInfo = getHibernateTemplate().find("from postInfo");
		return postInfo;
	}

	@Override
	public boolean add(PostInfo postInfo) {
		postInfo.setPostValid(true);
		this.getHibernateTemplate().save(postInfo);
		return true;
	}

	@Override
	public boolean deleteReal(Integer postId) {
		PostInfo postInfo=(PostInfo)this.getHibernateTemplate().get(PostInfo.class,postId);
		getHibernateTemplate().delete(postInfo);
		return true;
	}

	@Override
	public PostInfo queryById(Integer postId) {
		PostInfo postInfo=(PostInfo)this.getHibernateTemplate().get(PostInfo.class,postId);
		return postInfo;
	}

	@Override
	public void update(PostInfo postInfo) {
		postInfo.setPostValid(true);
		this.getHibernateTemplate().update(postInfo);
	}

	@Override
	public List<PostInfo> queryAll() {
		List<PostInfo> postInfo = getHibernateTemplate().find("from PostInfo");
		int i;
		for(i=0;i<postInfo.size();i++){
			if(postInfo.get(i).getPostValid() == false){
				System.out.println(postInfo.get(i).getPostName());
				postInfo.remove(i);
				i = i-1;
			}
		}
		return postInfo;
	}

	@Override
	public boolean delete(Integer postId) {
		PostInfo postInfo=(PostInfo)this.getHibernateTemplate().get(PostInfo.class,postId);
		postInfo.setPostValid(false);
		return true;
	}

}
