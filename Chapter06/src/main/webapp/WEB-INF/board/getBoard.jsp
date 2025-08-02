<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>게시글 상세</h1>
	<hr/>
	<form action="updateBoard.do" method="post">
	<input name="seq" type="hidden" value="${board.seq }"/>
		<table border="1" cellpadding="0" cellspacing="0" width="400">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td><input name="title" type="text" value="${board.title }"/></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">작성자</td>
				<td><input name="writer" type="text" value="${board.writer }" disabled/></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">내용</td>
				<td><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">등록일</td>
				<td><input name="writer" type="text" value="${board.regDate }" disabled/></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">조회수</td>
				<td><input name="writer" type="text" value="${board.cnt }" disabled/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="글 수정 요청"/></td>
			</tr>
		</table>
	</form>
	<a href="deleteBoard.do?seq=${board.seq }">${board.seq }번 게시글 삭제</a>
</center>

</body>
</html>