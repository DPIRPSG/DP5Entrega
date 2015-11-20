<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access = "hasRole('ADMIN')">
	<form:form action="category/edit.do" modelAttribute="category">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		
		<form:label path="name">
			<spring:message code = "category.edit.name"/>
		</form:label>
		<form:input path="name"/>
		<form:errors cssClass="error" path="name"/>
		<br />
		
		<form:label path="description">
			<spring:message code = "category.edit.description"/>
		</form:label>
		<form:textarea path="description"/>
		<form:errors cssClass="error" path="description"/>
		<br />
		
		<form:label path="picture">
			<spring:message code = "category.edit.picture"/>
		</form:label>
		<form:input path="picture"/>
		<form:errors cssClass="error" path="picture"/>
		<br />

	<!-- Selección de tasas ! ! ! ! -->
		
		
	</form:form>

</security:authorize>
