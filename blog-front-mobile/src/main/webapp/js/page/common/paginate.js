$(function() {

	var $paginate = $("#paginate_id");
	var pageNumber = Number($paginate.attr("pageNumber"));
	var totalPage = Number($paginate.attr("totalPage"));
	var totalRow = Number($paginate.attr("totalRow"));
	var params = $paginate.attr("params");
	var url = $paginate.attr("url");

	if(params == undefined){
		params = "";
	}
	
	var config = {
		target : $paginate,
		url : url,
		page : pageNumber,
		total : totalRow,
		totalPage : totalPage,
		params : params,
		offsetPage : 3
	}

	Paginate(config);
});

/**
 * config
 * @param target 目标对象
 * @param page 当前页
 * @param total 总条数
 * @param totalPage 总页数
 * @param params 参数集
 * @param offsetPage 页码偏移量
 */
function Paginate(config) {

	var page = config.page;
	var total = config.total;
	var totalPage = config.totalPage;
	var params = config.params;
	var url = config.url;
	var offsetPage = config.offsetPage;
	var target = config.target;
	
	if(offsetPage == undefined){
		offsetPage = 3;
	}

	var pageContent = '';
	// 上一页
	if (page <= 1) {
		pageContent += '<li><a href="javascript:;">上一页</a></li>';
	} else {
		pageContent += '<li><a href="' + url + (page - 1) + params + '">上一页</a></li>';
	}

	// 页码前
	if (page - offsetPage > 1) {
		pageContent += '<li><a href=""+url+"1">1</a></li>';
		if (page - offsetPage != 2) {
			pageContent += '<li><a href="' + url + '1' + params + '">...</a></li>';
		}
		for ( var i = offsetPage; i >= 1; i--) {
			pageContent += '<li><a href="' + url + (page - i) + params + '">' + (page - i) + '</a></li>';
		}
	} else {
		for ( var i = 1; i < page; i++) {
			pageContent += '<li><a href="' + url + i + params + '">' + i + '</a></li>';
		}
	}

	// curr page
	pageContent += '<li class="active"><a href="' + url + page + params + '">' + page + '</a></li>';

	// 页码后
	if (page + offsetPage < totalPage) {
		for ( var i = 1; i <= offsetPage; i++) {
			pageContent += '<li><a href="' + url + (page + i) + params + '">' + (page + i) + '</a></li>';
		}
		if (page + offsetPage != totalPage - 1) {
			pageContent += '<li><a href="' + url + (totalPage) + params + '">...</a></li>';
		}
		pageContent += '<li><a href="' + url + (totalPage) + params + '">' + (totalPage) + '</a></li>';
	} else {
		for ( var i = page + 1; i <= totalPage; i++) {
			pageContent += '<li><a href="' + url + i + params + '">' + (i) + '</a></li>';
		}
	}

	// 下一页
	if (page >= totalPage) {
		pageContent += '<li><a href="javascript:;">下一页</a></li>';
	} else {
		pageContent += '<li><a href="' + url + (page + 1) + params + '">下一页</a></li>';
	}

	$(target).html(pageContent);
}
