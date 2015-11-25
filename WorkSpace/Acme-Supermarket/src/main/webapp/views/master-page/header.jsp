<%--
 * header.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" alt="Acme-Supermarket Co., Inc." />
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('CONSUMER')">
			<li><a class="fNiv" href="consumer/item/list.do"><spring:message code="master.page.catalogue" /></a></li>
			<li><a class="fNiv" href="consumer/shopping-cart/list.do"><spring:message code="master.page.shopping-cart" /></a></li>
			<li><a class="fNiv" href="consumer/order/list.do"><spring:message code="master.page.orders" /></a></li>
			<li><a class="fNiv" href="consumer/folder/list.do"><spring:message code="master.page.messages" /></a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.manage" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/item/list.do"><spring:message code="master.page.manage.catalogue" /></a></li>
					<li><a href="administrator/taxe/list.do"><spring:message code="master.page.manage.taxes" /></a></li>			
					<li><a href="administrator/category/list.do"><spring:message code="master.page.manage.categories" /></a></li>	
					<li><a href="administrator/warehouse/list.do"><spring:message code="master.page.manage.warehouses" /></a></li>			
				</ul>
			</li>
			<li><a class="fNiv"><spring:message	code="master.page.list" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/consumer/list.do"><spring:message code="master.page.list.consumers" /></a></li>
					<li><a href="administrator/order/list.do"><spring:message code="master.page.list.orders" /></a></li>
				</ul>
			</li>
			<li><a class="fNiv" href="administrator/dashboard/list.do"><spring:message code="master.page.dashboard" /></a></li>
			<li><a class="fNiv" href="administrator/new-clerk/list.do"><spring:message code="master.page.new-clerk" /></a></li>
			<li><a class="fNiv" href="administrator/folder/list.do"><spring:message code="master.page.messages" /></a></li>
		</security:authorize>
		
		<security:authorize access="hasRole('CLERK')">
			<li><a class="fNiv" href="clerk/item/list.do"><spring:message code="master.page.catalogue" /></a></li>
			<li><a class="fNiv" href="clerk/warehouse/list.do"><spring:message code="master.page.warehouses" /></a></li>
			<li><a class="fNiv" href="clerk/order/list.do"><spring:message code="master.page.orders" /></a></li>
			<li><a class="fNiv" href="clerk/folder/list.do"><spring:message code="master.page.messages" /></a></li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="consumer/register.do"><spring:message code="master.page.register" /></a></li>
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" />(<security:authentication property="principal.username" />)</a></li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

