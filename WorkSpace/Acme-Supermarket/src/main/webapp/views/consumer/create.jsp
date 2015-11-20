<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


	<!-- Definir variable -->
	<jstl:set 
		var = "name"
		value = "${exp}" />
	<!-- Mostrar un mensaje -->
	<spring:message
		code = "hace Referencia Al codigo en la traduccion"
		var = "en esta variable se guarda el resultado (en caso de no ponerla lo muestra automáticamente)" />
	<!-- Seguridad -->
	<security:authorize
		access = "isAnonymous()">
		<!-- código a ejecutar o mostrar -->
	</security:authorize>
	
	
	
	<security:authorize access = "isAnonymous()">
	
		<form:form action="consumer/create.do" modelAttribute="consumer">
		
		</form:form>
	
	</security:authorize>
	
	
	
	


<p><spring:message code="customer.action.1" /></p>
