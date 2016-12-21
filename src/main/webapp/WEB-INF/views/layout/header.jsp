<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>

<link href="<c:url value="/resources/css/justified-nav.css"/>"
	rel='stylesheet' type='text/css' />

<div class="masthead">
	<nav>
		<ul class="nav nav-justified">
			<li class="active"><a href='<spring:url value="/"/>'>Home</a></li>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<spring:url value="/users"/>">Users</a></li>
			</security:authorize>
			<li><a href="<spring:url value="/register"/>">Register</a></li>
			<security:authorize access="! isAuthenticated()">
				<li><a href="<spring:url value="/login"/>">Login</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li><a href="<spring:url value="/logout"/>">Logout</a></li>
			</security:authorize>
			<li><a href="<spring:url value="/"/>">About</a></li>
			<li><a href="<spring:url value="/"/>">Contact</a></li>
		</ul>
	</nav>
</div>

