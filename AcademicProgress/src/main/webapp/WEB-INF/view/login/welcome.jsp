<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html><html lang="en">
<head>
    <meta charset="utf-8">
    <title>FrontAcademic</title>
    <base href="/">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="icon" type="image/x-icon" href="/resources/favicon.ico">
    <link href="/resources/css/styles.bundle.css" rel="stylesheet"/>
</head>

<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h3><a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
    </c:if>
</div>

<app-root></app-root>
<script type="text/javascript" src="/resources/js/inline.bundle.js"></script>
<script type="text/javascript" src="/resources/js/polyfills.bundle.js"></script>
<script type="text/javascript" src="/resources/js/main.bundle.js"></script>
</body>

</html>