package com.blog.front.mobile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.front.mobile.controller.base.BaseController;
import com.blog.product.core.entity.Article;
import com.blog.product.core.entity.ArticleComment;
import com.blog.product.core.entity.ArticleContent;
import com.blog.product.core.service.ArticleCommentService;
import com.blog.product.core.service.ArticleService;
import com.blog.product.core.service.ArticleTypeService;
import com.blog.user.core.entity.User;
import com.blog.user.core.service.UserService;
import com.hecj.common.utils.Pagination;
import com.hecj.common.utils.Result;
import com.hecj.common.utils.StringUtil;

@Controller
public class ArticleController extends BaseController{

	private static final Log log = LogFactory.getLog(ArticleController.class);
	
	@Resource
	private UserService userService;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	public ArticleTypeService articleTypeService;
	
	@Resource
	public ArticleCommentService articleCommentService;
	
	@RequestMapping(value="/p/article", method=RequestMethod.GET)
	public String index(Long page,Long type,String sq,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		if(page == null){
			page = 1l;
		}
		
		// 查询文章类型
		Pagination articleTypePagination = new Pagination();
		articleTypePagination.setPageSize(100);
		Map<String,Object> articleTypeParams = new HashMap<String,Object>();
		articleTypeParams.put("idDelete", 0);
		Result articleTypeResult = articleTypeService.findArticleTypesByCondition(articleTypeParams, articleTypePagination);
		if(articleTypeResult.isSuccess()){
			model.addAttribute("articleTypeList", articleTypeResult.getData());
		}
		
		// 查询文章
		Pagination articlePagination = new Pagination();
		articlePagination.setCurrPage(page);
		Map<String,Object> articleParams = new HashMap<String,Object>();
		if(!StringUtil.isObjectNull(type)){
			articleParams.put("type", type);
		}
		if(!StringUtil.isStrEmpty(sq)){
			articleParams.put("title", sq);
		}
		articleParams.put("permission", 0);
		articleParams.put("isDelete", 0);
		Result articleResult= articleService.findArticlesByCondition(articleParams, articlePagination);
		if(articleTypeResult.isSuccess()){
			model.addAttribute("articleResult", articleResult);
		}
		
		model.addAttribute("type", type);
		model.addAttribute("search_content", sq);
		
		return "page/index/index";
	}
	
	/**
	 * 文章详情
	 */
	@RequestMapping(value="/p/article/detail/{articleId}", method=RequestMethod.GET)
	public String detail(@PathVariable Long articleId,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		try {
			
			Article article = articleService.findArticleById(articleId);
			model.addAttribute("article", article);
			
			// 文章内容
			List<ArticleContent> articleContentList = articleService.findArticleContentByArticleId(articleId);
			model.addAttribute("articleContentList", articleContentList);
			
			User author = userService.findUserById(article.getUserId());
			model.addAttribute("author", author);
			
			// 查询文章类型
			Pagination articleTypePagination = new Pagination();
			articleTypePagination.setPageSize(100);
			Map<String,Object> articleTypeParams = new HashMap<String,Object>();
			articleTypeParams.put("idDelete", 0);
			Result articleTypeResult = articleTypeService.findArticleTypesByCondition(articleTypeParams, articleTypePagination);
			if(articleTypeResult.isSuccess()){
				model.addAttribute("articleTypeList", articleTypeResult.getData());
			}
			
			List<ArticleComment> articleCommentList = articleCommentService.findArticleCommentByArticleId(articleId);
			model.addAttribute("articleCommentList", articleCommentList);

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return "page/article/detail";
	}

}
