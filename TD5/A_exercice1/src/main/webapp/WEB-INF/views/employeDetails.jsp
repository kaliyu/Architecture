<%--
  Created by IntelliJ IDEA.
  User: o22100171@campus.univ-orleans.fr
  Date: 12/11/2025
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Détails de l'employé</title>
</head>
<body>
<h1>Détails de l'employé</h1>

<p><strong>Nom :</strong> ${employe.nom}</p>
<p><strong>Prénom :</strong> ${employe.prenom}</p>

<c:if test="${not empty employe.adresse}">
  <p><strong>Adresse :</strong> ${employe.adresse.rue}, ${employe.adresse.ville}</p>
</c:if>

<h3>Téléphones</h3>
<ul>
  <c:forEach var="tel" items="${employe.telephones}">
    <li>${tel.numero}</li>
  </c:forEach>
</ul>

<h3>Projets en cours</h3>
<ul>
  <c:forEach var="p" items="${employe.projetsEnCours}">
    <li>${p.nomProjet}</li>
  </c:forEach>
</ul>

<p><a href="${pageContext.request.contextPath}/employes">Retour à la liste</a></p>

</body>
</html>

