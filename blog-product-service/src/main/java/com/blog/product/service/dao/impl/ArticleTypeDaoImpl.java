package com.blog.product.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.product.core.entity.ArticleType;
import com.blog.product.service.dao.ArticleTypeDao;

public class ArticleTypeDaoImpl extends SqlSessionDaoSupport implements ArticleTypeDao {

	@Override
	public List<ArticleType> findArticleTypesByConditions(Map<String, Object> params, long currPage, int pageSize) {
		
		params.put("start", pageSize * (currPage-1));
		params.put("offset", pageSize);
		
		SqlSession session = this.getSqlSession();
		List<ArticleType> articles = session.selectList("articleType.findArticleTypesByConditions", params);
		return articles;
	}

	@Override
	public long totalArticleTypesByConditions(Map<String, Object> sqlParams) {
		SqlSession session = this.getSqlSession();
		return session.selectOne("articleType.totalArticleTypesByConditions", sqlParams);
	}

}
