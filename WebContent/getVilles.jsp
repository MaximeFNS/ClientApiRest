<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Villes</title>
</head>
<body>
	<tbody id="AffichageVilles">
		Les communes :
		
		<c:forEach var="v" items="${villes}" varStatus="loop">
			
			<c:out value="${v}" />
			
		</c:forEach>
	</tbody>


</body>
</html>