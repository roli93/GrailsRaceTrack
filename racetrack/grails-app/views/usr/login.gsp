<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usr.label', default: 'Usr')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />  
		<asset:stylesheet href="application.css"/>
    	<asset:javascript src="application.js"/> 
	</head>
	<body>
		
		<div class="container">
		    <div class="row">
		        <form action="authenticate"  method="post">
		            <div class="row">
		                <fieldset class="contact-fieldset">
		                    <legend style="margin:0px 0px 20px 100px">Login</legend>
							<g:if test="${flash.message}">
								<div class="message">${flash.message}</div>
							</g:if>
		                    <div class="col-sm-5 col-sm-offset-1 form-column">
		                        <div class="form-group">
		                            <label>Username</label>
		                            <input type="text" class="form-control" id="login" name="login" autofocus maxlength="20">
		                        </div>
		                        <div class="form-group">
		                            <label>Password</label>
		                            <input type="password" class="form-control" id="password" name="password" maxlength="20">
		                        </div>
		                        <button type="submit" class="btn btn-primary">Login</button>
		                    </div>
		                </fieldset>
		            </div>
		        </form>
		    </div>
		</div>
	</body>
</html>
