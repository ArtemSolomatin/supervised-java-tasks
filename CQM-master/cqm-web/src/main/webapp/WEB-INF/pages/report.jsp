<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        <title>CQM | Отчеты</title>

        <link href="<c:url value="${contextPath}/resources/css/site-style.css" />" rel="stylesheet">
    </head>
    <body BACKGROUND="${pageContext.request.contextPath}/resources/img/background.jpg"/>


    <div class="ProfileContent">
        <table width="98%" align="center" class="CafeTable">
            <c:if test="${!empty reports}">
                <c:forEach items="${reports}" var="report">
                    <tr class="cafeTr">
                        <th width="35%"></th>
                        <th width="40%"></th>
                        <th width="25%"></th>
                    </tr>
                    <tr>
                        <td>ID отчета: <c:out value="${report.reportId}"/></td>
                        <td>Прислал: <c:out value="${report.author}"/>(<c:out value="${report.authorRating}"/>)</td>
                        <c:if test="${!report.isVoted && !report.isAuthor}">
                            <td align="center"><a href="<c:url value="/reports/positive/${report.reportId}"/>">
                                <div class="MenuButton">Согласен</div>
                            </a>
                            </td>
                        </c:if>
                        <c:if test="${report.isVoted || report.isAuthor}">
                            <td align="center">
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Столовая: <c:out value="${report.cafeName}"/></td>
                        <td><c:out value="${report.date}"/></td>
                        <td align="center"><c:out value="${report.rating}"/></td>
                    </tr>
                    <tr>
                        <td>Загруженность: <c:out value="${report.load}"/></td>
                        <td></td>
                        <c:if test="${!report.isVoted && !report.isAuthor}">
                            <td align="center"><a href="<c:url value="/reports/negative/${report.reportId}"/>">
                                <div class="MenuButton">Не согласен</div>
                            </a>
                            </td>
                        </c:if>
                        <c:if test="${report.isVoted}">
                            <td align="center">Вы уже голосовали
                            </td>
                        </c:if>
                        <c:if test="${report.isAuthor}">
                            <td align="center">Нельзя голосовать за свои отчеты
                            </td>
                        </c:if>
                    </tr>
                    <tr bgcolor="#3cb371">
                        <td>
                        </td>
                        <td>
                        </td>
                        <td>
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
        </p>
    </div>
    </body>
</sec:authorize>
</html>
