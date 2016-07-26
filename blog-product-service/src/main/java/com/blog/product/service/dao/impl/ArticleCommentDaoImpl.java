package com.blog.product.service.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.product.core.entity.ArticleComment;
import com.blog.product.service.dao.ArticleCommentDao;

public class ArticleCommentDaoImpl extends SqlSessionDaoSupport implements ArticleCommentDao {

	@Override
	public List<ArticleComment> findArticleCommentByArticleId(long articleId) {

		return this.getSqlSession().selectList("articleComment.findArticleCommentByArticleId", articleId);
	}

	@Override
	public long insert(ArticleComment ac) {
		this.getSqlSession().insert("articleComment.insert", ac);
		return ac.getId();
	}

}
