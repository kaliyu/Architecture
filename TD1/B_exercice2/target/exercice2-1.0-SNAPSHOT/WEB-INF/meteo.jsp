<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>METEO</title>
</head>
<body>

<h2>Choisissez la météo du jour :</h2>

<form method="post">
    <select name="meteo">
        <c:forEach items="${options}" var="opt">
            <option value="${opt}" <c:if test="${opt == selected}">selected</c:if>>${opt}</option>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

<h3>Statistiques :</h3>
<ul>
    <c:forEach items="${compteur}" var="entry">
        <li>${entry.key} : ${entry.value} fois</li>
    </c:forEach>
</ul>

</body>
</html>
