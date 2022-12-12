
<%--
  Created by IntelliJ IDEA.
  User: yoh
  Date: 06/10/2021
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Page du menu</title>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
    <jsp:useBean id="utilisateurs" scope="request" type="java.util.Collection<modele.Utilisateur>"/>

</head>
<body>

<h1>Bonjour ${user.pseudo}, voici le menu du jour</h1>
<ul>
    <li><a href="/authentification/deconnexion">Déconnexion</a> </li>
</ul>


Liste des utilisateurs inscrits
<ul>

    <c:forEach items="${utilisateurs}" var="x">

    <li>${x.pseudo}</li>

    </c:forEach>

</ul>



</body>
</html>
