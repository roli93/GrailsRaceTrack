<%@ page import="racetrack.Usr"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName"
			value="${message(code: 'race.label', default: 'Race')}" />
		<title>Race search</title>
		<asset:stylesheet href="application.css"/>
    	<asset:javascript src="application.js"/> 
	</head>
	<body>
	<div class="container-fluid">
		<table class="table table-hover">
			<thead>
				<th>Name</th>
				<th>City</th>
			</thead>
			<tbody>
				<g:each in="${raceInstanceList}" status="i" var="raceInstance">
					<tr>
						<td>
							${fieldValue(bean: raceInstance, field: "name")}
						</td>
						<td>
							${fieldValue(bean: raceInstance, field: "city")}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
</html>
