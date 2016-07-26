package com.blog.product.service.dao;

import java.util.List;

import com.blog.product.core.entity.ArticleContent;

public interface ArticleContentDao {

	public List<ArticleContent> findArticleContentByArticleId(long articleId);
	
	/**
	 * @功能描述 保存文章内容
	 * @param articleContent
	 * @return long
	 * @Version		V1.0
	 * @date		2016-1-5 下午12:15:19
	 * @author hechaojie
	 * @modify
	 */
	public long save(ArticleContent articleContent);
	
	/**
	 * @功能描述 删除文章内容
	 * @param articleId
	 * @return int
	 * @Version		V1.0
	 * @date		2016-1-5 下午6:17:00
	 * @author hechaojie
	 * @modify
	 */
	public int deleteContent(long articleId);
}
