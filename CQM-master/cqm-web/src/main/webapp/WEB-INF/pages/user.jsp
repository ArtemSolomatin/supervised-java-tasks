<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<sec:authorize access="!isAuthenticated()">
    <jsp:forward page="/"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>CQM | Пользователи</title>

        <link href="<c:url value="${contextPath}/resources/css/site-style.css" />" rel="stylesheet">

    </head>
    <body BACKGROUND="${pageContext.request.contextPath}/resources/img/background.jpg"/>
    <div class="CafeContent">
        <h2 align="center">Топ-5 пользователей CQM</h2>
        <table align="center" class="CafeTable" width="98%">
            <tr>
                <th width="18%" align="left">
                    <div class="UserRatingHeader"> Место
                </th>
                <th width="25%" align="left">
                    <div class="UserRatingHeader"> Рейтинг
                </th>
                <th width="55%">
                    <div class="UserLoginHeader">Имя пользователя</div>
                </th>
            </tr>
            <c:if test="${!empty users}">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            <div class="UserRating"><c:out value="${user.rank}"/></div>
                        </td>
                        <td>
                            <div class="UserRating"><c:out value="${user.rating}"/></div>
                        </td>
                        <td>
                            <div class="UserLogin"><c:out value="${user.login}"/></div>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <div class="UserRating">...</div>
                    </td>
                    <td>
                        <div class="UserRating">...</div>
                    </td>
                    <td>
                        <div class="UserRating">...</div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="UserRating"><c:out value="${currentRank}"/></div>
                    </td>
                    <td>
                        <div class="UserRating"><c:out value="${currentRating}"/></div>
                    </td>
                    <td>
                        <div class="UserRating"><c:out value="${currentName}"/></div>
                    </td>
                </tr>
            </c:if>
        </table>
    </div>

    <div class="PageMenu">
        Вы зашли под именем <sec:authentication property="principal.username"/>
        <a href="<c:url value="/"/>">
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
    </div>
    </body>
</sec:authorize>
</html>

