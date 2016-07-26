package com.blog.product.service.dao;

import java.util.List;

import com.blog.product.core.entity.ArticleComment;

public interface ArticleCommentDao {

	public List<ArticleComment> findArticleCommentByArticleId(long articleId);
	
	public long insert(ArticleComment ac);
	
}
