<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CQM | Личный кабинет</title>

    <link href="<c:url value="${contextPath}/resources/css/site-style.css" />" rel="stylesheet">

</head>
<body BACKGROUND="${pageContext.request.contextPath}/resources/img/background.jpg"/>
<sec:authorize access="!isAuthenticated()">
    <jsp:forward page="/"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

    <div class="ProfileContent">
        <sec:authentication property="principal.username"/>,
        <br>
        Ваш рейтинг: <c:out value="${rating}"/>
        </div>
    </div>

    <div class="PageMenu">
        Вы зашли под именем <sec:authentication property="principal.username"/>
        <a href="<c:url value="/profile"/>">
            <div class="MenuButton"> Личный кабинет</div>
        </a>
        <a href="<c:url value="/reports"/>">
            <div class="MenuButton"> Отчеты</div>
        </a>
        <a href="<c:url value="/addreport"/>">
            <div class="MenuButton">Отправить отчет</div>
        </a>
        <a href="<c:url value="/cafeterias"/>">
            <div class="MenuButton"> Информация о столовых</div>
        </a>
        <a href="<c:url value="/users"/>">
            <div class="MenuButton"> Рейтинг Пользователей</div>
        </a>
        <a href="<c:url value="/logout"/>">
            <div class="MenuButton"> Выход</div>
        </a>
        </p>
    </div>
</sec:authorize>
</body>
</html>
