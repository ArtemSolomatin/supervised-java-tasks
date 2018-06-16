<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <title>CQM | Столовые</title>

        <link href="<c:url value="${contextPath}/resources/css/site-style.css" />" rel="stylesheet">
    </head>

    <body BACKGROUND="${pageContext.request.contextPath}/resources/img/background.jpg"/>
    <div class="CafeContent">
        <c:if test="${!empty cafeterias}">
        <c:forEach items="${cafeterias}" var="cafeteria">
        <table width="98%" align="center" class="CafeTable">
            <tr class="cafeTr">
                <th width="35%"></th>
                <th width="40%"></th>
                <th width="25%"></th>
            </tr>
            <tr class="cafeTr">
                <td height="200px">
                    <img class="CafePhoto" src="data:image/jpg;base64,<c:out value='${cafeteria.base64DataString}'/>"/>
                </td>
                <td>
                    <div class="CafeName"><c:out value="${cafeteria.cafeName}"/></div>
                </td>
                <td rowspan="2">
                    <div class="CafeLoad"><c:out value="${cafeteria.workHours}"/></div>
                </td>
            </tr>
            <tr class="cafeTr">
                <td colspan="2">
                    <div class="CafeAddress"><c:out value="${cafeteria.cafeAddress}"/></div>
                </td>
            </tr>
            </c:forEach>
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
