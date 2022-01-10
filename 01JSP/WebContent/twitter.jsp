<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*" %>
    <%//java.utll.* 는 ArrayList를 사용하기 위한 유틸을 임포트하였음 .
   	//java.text.* 은 SimpleDateFormat 을 사용하기 위해 임포트함
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 한글 캐릭터셋 변환
	request.setCharacterEncoding("UTF-8");

//HTML 폼에서 전달된 msg 값을 가지고 옴
String msg = request.getParameter("msg");

//세션에 저장된 로그인 사용자 이름을 가지고 옴
Object username = session.getAttribute("user");

//메시지 저장을 위해 application 에서 msgs 로 저장된 ArrayList 가지고 옴
ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
//null 인경우 새로운 ArrayList 객체를 생성한다.
if(msgs==null){
	msgs = new ArrayList<String>();
	//application 에 ArrayList 저장
	application.setAttribute("msgs",msgs);
}
// 사용자 이름, 메시지, 날짜 정보를 포함하여 ArrayList에 추가
Date date=new Date();
SimpleDateFormat f = new SimpleDateFormat("E MMM dd HH:mm",Locale.KOREA);
msgs.add(username+"::"+msg+","+f.format(date));

//톰켓 콘솔을 통한 로깅
application.log(msg+"추가됨");
//목록 화면으로 리다이렉팅
response.sendRedirect ("twitter_list.jsp");





%>
</body>
</html>