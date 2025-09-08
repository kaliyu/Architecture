<%--
Cette JSP accueillera un form avec les deux champs login et password
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <form method="post">
        <label> Identifiant
            <input type="text" name="id">
        </label>
        <br/>
        <label> Mot de passe
            <input type="text" name="mdp">
        </label>
        <br/>
        <button type="submit">Envoyer</button>
    </form>
</body>
</html>
