<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%> --%>
<%-- <%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page des matières</title>
</head>
<body>
	<form action="ajoutmatiere" method="post">
		<table>
			<tr>
				<td>Introduire l'identifiant de la matiere</td>
				<td><input type="text" placeholder="IdMatiere" name="idMatiere"></td>
			</tr>
			<tr>
				<td>Introduire le nom de de la matiere</td>
				<td><input type="text" placeholder="NomMatiere"
					name="nomMatiere"></td>
			</tr>
			<tr>
				<td><input type="submit" value="AjouterMatiere" name="action"></td>
			</tr>

		</table>
	</form>
	<form action="supprimermatiere" method="post">
		<table>
			<tr>
				<td>Introduire l'identifiant de la matiere</td>
				<td><input type=text placeholder=IdMatiere name=idMatiere></td>
			</tr>

			<tr>
				<td><input type=submit value=SupprimerMatiere name=action></td>
			</tr>

		</table>
	</form>
	<form action="listematiere" method="get">
		<table class="table table-striped">
			<tr>
				<th>IdMatiere</th>
				<th>NomMatiere</th>
			</tr>
			<c:forEach items="${lstmat}" var="mat">
				<tr>
					<td>${mat.idMatiere}</td>
					<td>${mat.nomMatiere}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type=submit value=ListeMatieres name=action></td>
			</tr>
		</table>

	</form>

	<!-- <f:view> -->

	<!-- </f:view> -->
</body>
</html>