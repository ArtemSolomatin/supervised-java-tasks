<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CQM | Главная</title>

    <link href="<c:url value="${contextPath}/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="${contextPath}/resources/css/common.css"/>" rel="stylesheet">

</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <div class="container">
        <h2 align="center">Cafeteria Queues Monitoring</h2>
        <h4 class="form-heading" align="center">
            Cafeteria Queues Monitoring - сервис, обеспечивающий вас информацией о загруженности столовых Физтеха.
            Вы должны войти, чтобы использовать CQM
        </h4>
        <p class="lead" align="center">
        </p>
        <p align="center"> <a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Вход</a>
    </div>

</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <jsp:forward page="/profile"/>
</sec:authorize>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
