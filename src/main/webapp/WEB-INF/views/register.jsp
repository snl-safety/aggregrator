<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
		<label for="name" class="ol-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" class="form-control" placeholder="Username" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="ol-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" placeholder="Email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="ol-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control" placeholder="Password" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Register" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>