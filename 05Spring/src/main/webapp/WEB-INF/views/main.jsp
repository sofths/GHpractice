<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script>
	function listAll(){
		self.location = "/ex/board/list"
	}
	</script>
</head>
<body>
<input type="button" onclick="listAll()" value="학생목록"/>
</body>
</html>
