<%--
 * header.jsp
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" alt="Event Manager Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="event/customer/list-registered.do"><spring:message code="master.page.customer.list.registered.events" /></a></li>					
					<li><a href="event/customer/list-not-registered.do"><spring:message code="master.page.customer.list.not.registered.events" /></a></li>
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('ORGANISER')">
			<li><a class="fNiv"><spring:message	code="master.page.organiser" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="event/organiser/list-organised.do"><spring:message code="master.page.organiser.list.organised.events" /></a></li>
					<li><a href="event/organiser/create.do"><spring:message code="master.page.organiser.create.event" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv" href="j_spring_security_logout">
					<spring:message code="master.page.logout" />						
					(<security:authentication property="principal.username" />)					 
				</a>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

