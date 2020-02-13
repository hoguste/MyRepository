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
<title>Page des étudiants</title>
</head>
<body>
	<form action="ajoutetudiant" method="post">
		<table>
			<tr>
				<td>Introduire l'identifiant de l'étudiant</td>
				<td><input type="text" placeholder="IdEtudiant" name="idEtudiant"></td>
			</tr>
			<tr>
				<td>Introduire le nom de l'étudiant</td>
				<td><input type="text" placeholder="NomEtudiant"
					name="nomEtudiant"></td>
			</tr>
			<tr>
				<td>Introduire le prénom de l'étudiant</td>
				<td><input type="text" placeholder="PrenomEtudiant"
					name="prenomEtudiant"></td>
			</tr>
			<tr>
				<td><input type="submit" value="AjouterEtudiant" name="action"></td>
			</tr>

		</table>
	</form>
	<form action="supprimeretudiant" method="post">
		<table>
			<tr>
				<td>Introduire l'identifiant de l'étudiant</td>
				<td><input type=text placeholder=IdEtudiant name=idEtudiant></td>
			</tr>

			<tr>
				<td><input type=submit value=SupprimerEtudiant name=action></td>
			</tr>

		</table>
	</form>
	<form action="listeetudiant" method="get">
		<table class="table table-striped">
			<tr>
				<th>IdEtudiant</th>
				<th>NomEtudiant</th>
				<th>PrenomEtudiant</th>
			</tr>
			<c:forEach items="${lstetu}" var="etu">
				<tr>
					<td>${etu.idEtudiant}</td>
					<td>${etu.nomEtudiant}</td>
					<td>${etu.prenomEtudiant}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type=submit value=ListeEtudiants name=action></td>
			</tr>
		</table>

	</form>

	<!-- <f:view> -->

	<!-- </f:view> -->
</body>
</html>