<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Accueil 
</h1>



<input type="button" value="Page des matieres" onclick="window.location.href='http://localhost:8080/projet/matiere/listematiere'">
<input type="button" value="Page des étudiants" onclick="window.location.href='http://localhost:8080/projet/etudiant/listeetudiant'">  


</body>
</html>
