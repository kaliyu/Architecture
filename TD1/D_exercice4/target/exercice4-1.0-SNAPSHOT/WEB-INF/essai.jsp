
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Essai</title>
</head>
<br>
<p>Il est temps de deviner...</p>
Quel caractère proposez-vous ?
<form method="post">
    <input type="text" name="lecaractere">
    <button type="submit" name="TODO" value="char">Envoyer</button> <!-- TODO compléter le bouton -->
</form>

Pour l'instant vous avez trouvé : ${devine}
</br>
Nombre d'essai restant : ${nbessai}

</body>
</html>
