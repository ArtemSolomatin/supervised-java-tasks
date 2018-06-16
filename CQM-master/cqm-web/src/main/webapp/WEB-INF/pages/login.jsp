<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<sec:authorize access="isAuthenticated()">
    <jsp:forward page="/"/>
</sec:authorize>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CQM | Вход </title>

    <link href="<c:url value="${contextPath}/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="${contextPath}/resources/css/common.css"/>" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<div class="container">
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <h2 class="form-heading" align="center">Пожалуйста, войдите</h2>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input type="text" class="form-control" name="j_username" placeholder="Имя пользователя">
            <input type="password" class="form-control" name="j_password" placeholder="Пароль">
            <span>${error}</span>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
            <h4 class="text-center"><a href="<c:url value="/signup"/>">Зарегистрироваться</a></h4>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
