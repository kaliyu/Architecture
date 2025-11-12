<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Liste des employés</title>
</head>
<body>
<h1>Liste des employés</h1>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Détails</th>
    </tr>
    <c:forEach var="e" items="${employes}">
        <tr>
            <td>${e.idEmp}</td>
            <td>${e.prenom}</td>
            <td>${e.nom}</td>
            <td>
                <!-- lien vers /employes/{id} -->
                <a href="${pageContext.request.contextPath}/employes/${e.idEmp}">
                    Voir les détails
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

