package racetrack



import spock.lang.*

/**
 *
 */
class RaceIntegrationTestsSpec extends Specification {

	def race;
	
    def setup() {
		race = new Race();
    }

    def cleanup() {
    }

    void "Given race with date before today When it is validated, it sould raise errors"() {
		given:
			race.startDate = new Date() - 7;
		when:
			race.validate();
		then:
			race.hasErrors();
    }
	
}
