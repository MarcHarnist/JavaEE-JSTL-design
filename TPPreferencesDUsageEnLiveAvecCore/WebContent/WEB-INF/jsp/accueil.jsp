<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body style="color:<%= session.getAttribute("couleurChoisie") %>">
<h1>Accueil</h1>
<form method="post" action="<%= request.getContextPath() %>/ServletAccueil">
	<select name="couleurs">
		<% for(String col : (List<String>)application.getAttribute("couleurs")) { %>
			<option <%= col.equals(session.getAttribute("couleurChoisie")) ? "selected" : "" %> value="<%= col %>"><%= col %></option>
		<% } %>
	</select>
	<input type="submit" value="Valider">
</form>
<p>Vous êtes venus <%= request.getAttribute("nbPassage") %> fois</p>
<a href="<%= request.getContextPath() %>/unejsp.jsp">Vers la jsp secondaire</a>
</body>
</html>