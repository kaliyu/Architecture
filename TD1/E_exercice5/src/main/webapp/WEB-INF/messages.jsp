<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<h2>Micro App : Messages</h2>

<!-- Formulaire pour ajouter un message -->
<form method="post" action="messages">
    <input type="text" name="message" placeholder="Votre message ici..." required>
    <button type="submit" name="action" value="add">Ajouter</button>
</form>

<!-- Affichage message aléatoire -->
<form method="get" action="messages">
    <button type="submit" name="action" value="random">Afficher un message aléatoire</button>
</form>

<!-- Affichage de tous les messages -->
<form method="get" action="messages">
    <button type="submit" name="action" value="showAll">Afficher tous les messages</button>
</form>

<!-- Suppression des messages -->
<form method="post" action="messages">
    <input type="password" name="password" placeholder="Mot de passe">
    <button type="submit" name="action" value="clear">Tout effacer</button>
</form>

<hr>

<!-- Résultat aléatoire -->
<c:if test="${not empty randomMessage}">
    <p><strong>Message aléatoire :</strong> ${randomMessage}</p>
</c:if>

<!-- Résultat liste -->
<c:if test="${not empty allMessages}">
    <p><strong>Liste des messages :</strong></p>
    <ul>
        <c:forEach var="msg" items="${allMessages}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<!-- Messages d'erreur ou de succès -->
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>
<c:if test="${not empty success}">
    <p style="color: green">${success}</p>
</c:if>

</body>
</html>
