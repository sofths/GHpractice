<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
myview/home
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src='/resources/h.gif'>
<img src='/resources2/h.gif'>
<img src='/ex/resources/h.gif'><!-- 됨 -->
<img src='/ex/resources2/h.gif'><!-- 됨 -->
<img src='../../resources/h.gif'><!-- 됨 -->
<img src='../../resources2/h.gif'><!-- 됨 -->
<img src='..resources/h.gif'>
<img src='..resources2/h.gif'>
<img src='ex/resources/h.gif'>
<img src='ex/resources2/h.gif'>
</body>
</html>
