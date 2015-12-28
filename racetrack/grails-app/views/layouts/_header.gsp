<div id="header">
<div id="raceSearch">
	<g:form url="[action:'search', controller:'race']"
			name="raceSearchForm"
			method="get">
		<g:textField name="q" value="${params.q}"/>
		<input type="submit" value="Find a race">		
	</g:form>
</div>
	<p>
		<a class="header-main" href="${resource(dir:'')}">RaceTrack</a>
	</p>
	<p class="header-sub">When's your next race?</p>
	<div id="loginHeader">
		<g:loginControl />
	</div>
</div>