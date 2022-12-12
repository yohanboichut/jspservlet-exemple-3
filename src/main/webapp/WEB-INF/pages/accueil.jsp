<%--
  Created by IntelliJ IDEA.
  User: yoh
  Date: 06/10/2021
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de connexion</title>
    <jsp:useBean id="erreur" type="java.lang.String"
                 class="java.lang.String"
                 scope="request"/>
</head>
<body>

<span style="color: red; ">
    ${erreur}
</span>


<form method="post" action="/authentification/connexion">
  <label for="field:pseudo">Saisir votre pseudo</label>  <input name="pseudo" id="field:pseudo" type="text">
    <label for="field:password">Saisir votre mot de passe </label>
    <input name="password" id="field:password" type="password">
    <input type="submit">

</form>

</body>
</html>
