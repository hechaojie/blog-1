package com.blog.product.service.dao;

import java.util.List;
import java.util.Map;

import com.blog.product.core.entity.ArticleType;

public interface ArticleTypeDao {

	public List<ArticleType> findArticleTypesByConditions(Map<String,Object> sqlParams,long currPage,int pageSize);

	public long totalArticleTypesByConditions(Map<String,Object> sqlParams);
}
