<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果页面</title>
</head>
<body>
	<h1 align="left">站内搜索查询结果</h1>

	<div align="left" style="padding: 32px;float:left;">
		<c:forEach var="article" items="${articles }">
			<div>
				<div>
					<label>文章编号： </label>${article.id }&nbsp;&nbsp;<label>文章标题：</label>&nbsp;&nbsp;${article.title }
				</div>
				<br>
				<div>
					<label>文章摘要信息：</label><br>
					<p>${article.content }</p>
				</div>
				<br>
				<div>
					<label>文章作者：</label>&nbsp;${article.author }&nbsp;&nbsp;<label>发布时间：</label>&nbsp;&nbsp;${article.publishDate }
				</div>
				<br>
			</div>
			<hr>
		</c:forEach>

	</div>

</body>
</html>