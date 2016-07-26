package com.blog.product.core.service;

import java.util.List;
import com.blog.product.core.entity.ArticleComment;

public interface ArticleCommentService {

	/**
	 * 查询文章评论
	 */
	public List<ArticleComment> findArticleCommentByArticleId(long articleId);
	
	/**
	 * 保存文章评论
	 * @param ac
	 * @return
	 */
	public long insert(ArticleComment ac);
	
}
