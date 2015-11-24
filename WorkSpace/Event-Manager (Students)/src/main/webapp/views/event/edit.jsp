<%--
 * edit.jsp
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="event/organiser/edit.do" modelAttribute="event">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="organiser" />
	<form:hidden path="customers"/>

	<form:label path="title">
		<spring:message code="event.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />

	<form:label path="moment">
		<spring:message code="event.moment" />:
	</form:label>
	<form:input path="moment" />
	<form:errors cssClass="error" path="moment" />
	<br />

	<form:label path="description">
		<spring:message code="event.description" />:
	</form:label>
	<form:input path="description" />
	<form:errors cssClass="error" path="description" />
	<br />

	<form:label path="price">
		<spring:message code="event.price" />:
	</form:label>
	<form:input path="price" />
	<form:errors cssClass="error" path="price" />
	<br />

	
	<%-- <form:errors cssClass="error" path="reviewer" /> --%>
	<br />

	<input type="submit" name="save"
		value="<spring:message code="event.save" />" />&nbsp; 
	<jstl:if test="${event.id != 0}">
		<input type="submit" name="delete"
			value="<spring:message code="event.delete" />"
			onclick="return confirm('<spring:message code="event.confirm.delete" />')" />&nbsp;
	</jstl:if>
	<input type="button" name="cancel"
		value="<spring:message code="event.cancel" />"
		onclick="javascript: relativeRedir('event/organiser/list-organised.do');" />
	<br />



</form:form>