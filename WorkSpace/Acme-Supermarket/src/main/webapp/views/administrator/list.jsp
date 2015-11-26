<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('ADMIN')">

	<!-- Dashboard 1 -->
	<spring:message code="administrator.consumerMoreOrders"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="consumers" requestURI="${requestURI}" id="row">
		
		<spring:message code="consumer.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	 
	<!-- Dashboard 2 -->
	<spring:message code="administrator.consumerSpentMoreMoney"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="consumers" requestURI="${requestURI}" id="row">
		
		<spring:message code="consumer.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	 
	<!-- Dashboard 3 -->
	<spring:message code="administrator.bestSellingItem"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="items" requestURI="${requestURI}" id="row">
		
		<spring:message code="item.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 4 -->
	<spring:message code="administrator.worstSellingItem"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="items" requestURI="${requestURI}" id="row">
		
		<spring:message code="item.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 5 -->
	<spring:message code="administrator.clerkMoreOrders"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="clerks" requestURI="${requestURI}" id="row">
		
		<spring:message code="ckerk.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 6 -->
	<spring:message code="administrator.clerkLessOrders"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="clerks" requestURI="${requestURI}" id="row">
		
		<spring:message code="ckerk.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 7 -->
	<spring:message code="administrator.consumerCancelledMoreOrders"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="consumers" requestURI="${requestURI}" id="row">
		
		<spring:message code="consumer.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 8 -->
	<spring:message code="administrator.consumerCancelledLessOrders"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="consumers" requestURI="${requestURI}" id="row">
		
		<spring:message code="consumer.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 9 -->
	<spring:message code="administrator.ratioCancelledCurrentMonth"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="ratioCancelledCurrentMonth" requestURI="${requestURI}" id="row">
		
		<spring:message code="ratio.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>
	
	<!-- Dashboard 10 -->
	<spring:message code="administrator.itemMoreComment"/>
	
	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="items" requestURI="${requestURI}" id="row">
		
		<spring:message code="item.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="false" />
	
	</display:table>


</security:authorize>