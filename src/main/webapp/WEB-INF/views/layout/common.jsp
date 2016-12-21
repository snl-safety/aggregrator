<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.9/angular.min.js"></script>

<title><tiles:getAsString name="title" /></title>
</head>
<body>
<tilesx:useAttribute name="current" />
	<div class="container">
		<tiles:insertAttribute name="header" />
		<br>
		<tiles:insertAttribute name="body" />
		<br>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>