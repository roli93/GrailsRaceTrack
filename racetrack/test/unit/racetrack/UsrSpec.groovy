package racetrack

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usr)
class UsrSpec extends Specification {
	
	def roli,pirulo

    def setup() {
		mockForConstraintsTests(Usr)
		roli = new Usr(role: "admin",login:"roli",password:"password")
		pirulo = new Usr(role: "admin",login:"pirulo",password:"pirulote")
		mockDomain(Usr,[roli,pirulo])
    }

    def cleanup() {
    }

    void "User role is valid"() {
		given: "a user with a wrong role" 
			roli.role = "pirulo"
		when: "it is validated"
			roli.validate()
		then: "it has errors"
			roli.hasErrors()
    }
	
	void "user can be retrieved"() {
		when: "a user is searched for"
			def retrievedRoli = Usr.findByLogin("roli")
		then: "it exists"
			retrievedRoli.password == "password"
	}
	
}
