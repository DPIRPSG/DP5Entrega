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
	name="items-category" requestURI="item/list-category.do" id="row">
	
	<spring:message code="item.category" var="categoryHeader" />
	<display:column property="category" title="${categoryHeader}" sortable="true" />
	
	<spring:message code="item.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="false" />

	<spring:message code="item.price" var="priceHeader" />
	<display:column property="price" title="${priceHeader}" sortable="false" />

	<spring:message code="item.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" sortable="false" />
		
</display:table>

<form:form action="item/list-category.do" modelAttribute="item">
	
	<form:input path="search-word"/>
	
	<input type="submit" name="search-button" value="<spring:message code="search.button"/>"/>
	
</form:form>