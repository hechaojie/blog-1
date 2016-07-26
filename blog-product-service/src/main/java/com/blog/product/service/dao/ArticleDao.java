package com.blog.product.service.dao;

import java.util.List;
import java.util.Map;

import com.blog.product.core.entity.Article;
import com.blog.product.core.vo.ArticleVo;

public interface ArticleDao {

	public List<ArticleVo> findArticlesByConditions(Map<String,Object> sqlParams,long currPage,int pageSize);

	public long totalArticlesByConditions(Map<String,Object> sqlParams);
	
	/**
	 * 根据文章Id查询
	 */
	public Article findArticleById(long articleId);
	
	/**
	 * @功能描述 保存文章
	 * @param article
	 * @return long
	 * @Version		V1.0
	 * @date		2016-1-5 上午11:49:28
	 * @author hechaojie
	 * @modify
	 */
	public long save(Article article);
	
	/**
	 * @功能描述 编辑文章
	 * @param article
	 * @return long
	 * @Version		V1.0
	 * @date		2016-1-5 16:49:28
	 * @author hechaojie
	 * @modify
	 */
	public int update(Article article);
}
