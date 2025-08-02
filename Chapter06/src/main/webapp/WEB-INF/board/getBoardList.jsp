<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>게시글 목록(JSP)</h1>
	<hr/>
	<table border="1" cellpadding="0" cellspacing="0" width="800">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="400">제목</th>
			<th bgcolor="orange" width="100">작성자</th>
			<th bgcolor="orange" width="100">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<a href="insertBoardView.do">글 등록 화면으로 이동</a>
</center>

</body>
</html>