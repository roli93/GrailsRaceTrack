<%@ page import="racetrack.Usr" %>



<div class="fieldcontain ${hasErrors(bean: usrInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="usr.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" required="" value="${usrInstance?.login}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usrInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usr.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="password" name="password" required="" value="${usrInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usrInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="usr.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="role" from="${usrInstance.constraints.role.inList}" required="" value="${usrInstance?.role}" valueMessagePrefix="usr.role"/>

</div>

