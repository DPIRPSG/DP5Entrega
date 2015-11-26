<%--
 * list.jsp
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

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="events" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->

	<security:authorize access="hasRole('ORGANISER')">
		<display:column>
			<a href="event/organiser/edit.do?eventId=${row.id}">
				<spring:message	code="event.edit" />
			</a>
		</display:column>		
	</security:authorize>
	
	<security:authorize access="hasRole('CUSTOMER')">
		<display:column>
			<jstl:choose>
				<jstl:when test="${registered}">
					<a href="event/customer/unregister.do?eventId=${row.id}" 
					   onclick="javascript: return confirm('<spring:message code="event.confirm.unregister" />')">
						<spring:message code="event.unregister" />
					</a>					
				</jstl:when>
				<jstl:otherwise>
					<a href="event/customer/register.do?eventId=${row.id}">
						<spring:message code="event.register" />
					</a>
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
	</security:authorize>


	
	<!-- Attributes -->
	
	<spring:message code="event.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" sortable="true" />

	<spring:message code="event.moment" var="momentHeader" />
	<display:column property="moment" title="${momentHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />

	<spring:message code="event.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" sortable="false" />
	
	<spring:message code="event.price" var="priceHeader" />
	<display:column property="price" title="${priceHeader}" sortable="false" />

</display:table>

<!-- Action links -->

<security:authorize access="hasRole('ORGANISER')">
	<div>
		<a href="event/organiser/create.do"> <spring:message
				code="event.create" />
		</a>
	</div>
</security:authorize>