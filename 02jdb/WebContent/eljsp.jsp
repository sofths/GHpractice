<%@page import="com.human.dto.HumanDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
문자열${"test" }
문자열${'test' }
정수:${20}
boolean:${true }
null:${null }


<%	
	HumanDto dto=new HumanDto();
	pageContext.setAttribute("human1",dto);
	pageContext.setAttribute("human2",15);
	pageContext.setAttribute("human3",new int[]{10,20,30,40});
	pageContext.setAttribute("human5",4);
	request.setAttribute("human5",5);
	session.setAttribute("human6",6);
	application.setAttribute("human7",7);
%>
	${human1.name }	${human1["name"] }	${pageScope.human1.name }
	${human2 }${pageScope.human2 }
	${human3 }${human3[2] }
	<br>
	${human5 }${requestScope.human5 }
	${human6 }${sessionScope.human6 }
	${human7 }${applicationScope.human7 }
	<br>
	servlet
	${requestScope.servlet2}${sessionScope.servlet3}${applicationScope.servlet4}
	${10+20}
	${10-20 }
	${10*20 }
	${10div20}
	
	사용자 입력
	${param.id }
	${paramValues.hobby }
	${paramValues.hobby[0] }
	
</body>
</html>