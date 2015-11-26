<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<security:authorize access="hasRole('CONSUMER')">

	<display:table pagesize="5" class="displaytag" keepStatus="true"
		name="items" requestURI="${requestURI}" id="row">
	
		<display:column>
			<a href="shopping-cart/consumer/delete.do?itemId=${row.id}"
			onclick="javascript: return confirm('<spring:message code="item.confirm.delete" />')">
				<spring:message	code="item.delete" />
			</a>
		</display:column>
		
		<spring:message code="item.picture" var="pictureHeader" />
		<display:column property="picture" title="${pictureHeader}" sortable="false" />
		
		<spring:message code="item.name" var="nameHeader" />
		<display:column property="name" title="${nameHeader}" sortable="true" />
		
		<spring:message code="item.price" var="priceHeader" />
		<display:column property="price" title="${priceHeader}" sortable="true" />
		
		<input type="submit" name="add.content" value="<spring:message code = item.add.content var=addContentHeader/>"/>
		<display:column property="addContent" title="${addContentHeader}" sortable="false"/>
		
		<spring:message code="item.content" var="contentHeader" />
		<display:column property="content" title="${contentHeader}" sortable="true" />
		
		<input type="submit" name="substract.content" value="<spring:message code = item.substract.content var=substractContentHeader/>"/>
		<display:column property="substractContent" title="${var=substractContentHeader}" sortable="false"/>
	
	</display:table>
	
	<jstl:if test="${numberItems} >= 1">
		<a href="shopping-cart/consumer/checkout.do?consumerUsername=<security:authentication property=principal.username/>" 
			onclick="javascript: return confirm('<spring:message code="item.confirm.checkout" />')">
			<spring:message	code="item.checkout" />
		</a>
	</jstl:if>
	
</security:authorize>