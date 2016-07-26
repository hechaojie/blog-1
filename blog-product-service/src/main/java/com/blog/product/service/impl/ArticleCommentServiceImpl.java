package com.blog.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.blog.product.core.entity.ArticleComment;
import com.blog.product.core.service.ArticleCommentService;
import com.blog.product.service.dao.ArticleCommentDao;

public class ArticleCommentServiceImpl implements ArticleCommentService {

	@Resource
	public ArticleCommentDao articleCommentDao;
	
	@Override
	public List<ArticleComment> findArticleCommentByArticleId(long articleId) {
		
		List<ArticleComment> list = articleCommentDao.findArticleCommentByArticleId(articleId);
		return list;
	}

	@Override
	public long insert(ArticleComment ac) {
		return articleCommentDao.insert(ac);
	}

}
