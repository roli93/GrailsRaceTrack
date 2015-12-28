package racetrack



import spock.lang.*

/**
 *
 */
class UsrControllerIntegrationTestsSpec extends Specification {

	def roli,pirulo,controller
	
    def setup() {
		roli = new Usr(role: "admin",login:"roli",password:"password")
		pirulo = new Usr(role: "admin",login:"pirulo",password:"pirulote")
		controller = new UsrController()
		roli.save()
		pirulo.save()
	}

    def cleanup() {
    }

    void "Test authenticate works well"(){
		given:
			controller.params.login = "roli"
			controller.params.password = "password"
		when:
			controller.authenticate()
		then:
			controller.session.user.login == "roli"
			controller.response.redirectedUrl == '/race/index'
		
	}
	
}