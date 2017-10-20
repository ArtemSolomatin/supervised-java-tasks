<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 22.09.17
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:body>
        <c:url value="/addStudent/studentId/newStudentId/facultyId/newFacultyId/recordbookNum/newRecordbookNum/fullName/newFullName/groupNum/newGroupNum" var="addStudent" />

        <!-- Content Column -->
        <div class="col-md-9">
            <c:if test="${not empty resultObject}">
                Result:
                <c:if test="${resultObject == 'true' or resultObject == 'Object was added successfully'}">
                    <font color="green"><b>${resultObject}</b></font>
                </c:if>
                <c:if test="${resultObject == 'false' or resultObject == 'Object was added unsuccessfully'}">
                    <font color="red"><b>${resultObject}</b></font>
                </c:if>
                <c:if test="${resultObject !='true' and resultObject != 'Object was added successfully' and resultObject != 'false' and resultObject != 'Object was added unsuccessfully'}">
                    <p>${resultObject}</p>
                </c:if>
            </c:if>
        </div>
    </jsp:body>
</page:template>
