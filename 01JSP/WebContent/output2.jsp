<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name[]= request.getParameterValues("name");
	String price[]= request.getParameterValues("price");
	String sale[]= request.getParameterValues("sale");
	String gender= request.getParameter("gender");
	
	double total=0;
	
	for (int i =0;i<name.length;i++){
		out.println(name[i]+":"+price[i]+"<BR>");
		total +=Integer.parseInt(price[i]);
	}
	String result ="";
	if(gender.equals('w')){
		result="여성";
	}else{
		result="남성";
	}
	out.println (""+":"+result+"<BR>");
	int totalSale=0;
	if (sale!=null){
	for (int i =0; i<sale.length;i++){
		totalSale+=Integer.parseInt(sale[i]);
	}
	}
	out.println("총 할인률"+":"+result+"<br>");
	total=total-total*(totalSale/100.);
	out.println("총격"+":"+total+"<br>");
	
%>
</body>
</html>