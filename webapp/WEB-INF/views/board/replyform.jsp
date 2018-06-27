<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/example/assets/css/board.css" rel="stylesheet" type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="/example/add_answer?no=${no}&Bdepth=${depth}" enctype="multipart/form-data">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">이름</td>
							<td><input type="text" name="name" value=""></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="content"></textarea>
							</td>
						</tr>
					</table>
					<!-- group_no -->g<input type="text" name="groupNo" value="${replyboardVo.groupNo}"> <br/>
					<!-- order_no -->o<input type="text" name="orderNo" value="${replyboardVo.orderNo}"><br/>
					<!-- parent_no no를 parent_no로-->p<input type="text" name="parentNo" value="${replyboardVo.no}"><br/>
					<!-- depth -->d<input type="text" name="depth" value="${replyboardVo.depth}">
					<div class="bottom">
						<a href="/example/board">취소</a>
						<input type="submit" value="등록">
					</div>
				</form>				
			</div>
		</div>

		<div id="footer">
			<p>(c)opyright 2015,2016,2017</p>
		</div> 
		
	</div><!-- /container -->
</body>
</html>		
		
