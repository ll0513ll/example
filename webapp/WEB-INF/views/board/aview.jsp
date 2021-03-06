<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="/example/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${Acontent.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${Acontent.content}
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="/example/board">글목록</a>
					<a href="">글수정</a>
					<a href="/example/reply?no=${Acontent.group_no}&depth=${Acontent.depth}">댓글</a>
				</div>
			</div>
		</div>

		<div id="footer">
			<p>(c)opyright 2015,2016,2017</p>
		</div> <!-- /footer -->
	</div>
</body>
</html>