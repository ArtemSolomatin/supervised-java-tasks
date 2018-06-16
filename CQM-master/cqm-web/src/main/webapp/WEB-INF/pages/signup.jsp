<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CQM | Регистрация</title>

    <link href="<c:url value="${contextPath}/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="${contextPath}/resources/css/common.css"/>" rel="stylesheet">
    <link href="<c:url value="${contextPath}/resources/css/jumbotron-narrow.css" />" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<div class="container">
    <form:form method="POST" modelAttribute="userForm">
    <h2 class="form-signin-heading" align="center">Регистрация в CQM</h2>
    <spring:bind path="login">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="login" class="form-control" placeholder="Имя пользователя"
                        autofocus="true"></form:input>
            <form:errors path="login"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="email" class="form-control" placeholder="e-mail"
                        autofocus="true"></form:input>
            <form:errors path="email"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Пароль"></form:input>
            <form:errors path="password"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="confirmPassword">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="confirmPassword" class="form-control"
                        placeholder="Подтверждение пароля"></form:input>
            <form:errors path="confirmPassword"></form:errors>
        </div>

    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Регистрация</button>
</form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
