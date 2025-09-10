
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Pendu</title>
</head>
<body>
<p>bienvenu dans le jeu de pendu...</p>
Quel mot proposez-vous ?
<form method="post">
    <input type="text" name="lemot">
    <button type="submit" name="TODO" value="mot">Envoyer</button>

</form>
${perdu}
</body>
</html>
