<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>郭璞在线论坛</title>
</head>
<body>
	<h1>欢迎来到郭璞在线聊天论坛</h1>
	<hr>
	<div>
		<div>
			<fieldset>
				<legend>查询文章</legend>
				<form
					action="${pageContext.request.contextPath }/servlet/SearchServlet"
					method="post">
					<input type="text" placeholder="请输入任意查询，支持模糊匹配哦"
						name="article_search"> <input type="submit" value="查找">
				</form>
			</fieldset>
		</div>
		<hr>
		<fieldset>
			<legend>论坛文章摘要</legend>
			<div>
				<table>
					<thead>文章简略信息
					</thead>
					<tr>
						<th>ID</th>
						<th>标题</th>
						<th>作者</th>
						<th>发布时间</th>
					</tr>
					<tbody>
						<tr>
							<c:forEach var="article" items="${articles }">
								<th>${article.id }</th>
								<th>${article.title }</th>
								<th>${article.author }</th>
								<th>${article.publishDate }</th>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>

		</fieldset>





		<fieldset>
			<legend>发帖</legend>
			<div>
				<form
					action="${pageContext.request.contextPath }/servlet/PublishArticleServlet"
					method="post">
					<label>文章号码：</label><input type="text" name="article_id"><br>
					<label>文章标题：</label><input type="text" name=article_title"><br>
					<label>文章作者：</label><input type="text" name="article_author"><br>
					<label>文章内容：</label><br>
					<textarea rows="12" cols="37" name="article_content"></textarea>
					<br> <input type="reset" value="取消发布">&nbsp;&nbsp;<input
						type="submit" value="发表文章">
				</form>
			</div>
		</fieldset>
	</div>
</body>
</html>