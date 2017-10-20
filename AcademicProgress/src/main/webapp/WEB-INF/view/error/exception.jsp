<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>
    <jsp:body>
        <div class="container">
                <div class="col-lg-12">

                    <h2>Exception</h2>
                    <p>Something went wrong</p>
                    <font color="red"><b>${exceptionMsg}</b></font>
                </div>
        </div>
    </jsp:body>
</page:template>