
<%@ page import="racetrack.Usr" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usr.label', default: 'Usr')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>ex
	<body>
		<a href="#list-usr" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-usr" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="login" title="${message(code: 'usr.login.label', default: 'Login')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'usr.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="role" title="${message(code: 'usr.role.label', default: 'Role')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usrInstanceList}" status="i" var="usrInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usrInstance.id}">${fieldValue(bean: usrInstance, field: "login")}</g:link></td>
					
						<td>${fieldValue(bean: usrInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: usrInstance, field: "role")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usrInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
