package racetrack

import racetrack.RoliCodec

import grails.test.mixin.*
import spock.lang.*
import grails.test.mixin.domain.DomainClassUnitTestMixin

@TestFor(UsrController)
@TestMixin(DomainClassUnitTestMixin)
class UsrControllerSpec extends Specification {

	def roli,pirulo
	
	def setup() {
			mockDomain(Usr)
			def jdoe = new Usr(login:"jdoe",
			password:"password")
			jdoe.save(flush:true)
	}

	def cleanup() {
	}
	
	void "Test authenticate works well"(){
		given:
	
			controller.params.login = "jdoe"
			controller.params.password = "password"	
		when:
			controller.authenticate()
		then:
			controller.session.user.login == "jdoe"
			response.redirectedUrl == '/race'
		
	}
	
}
