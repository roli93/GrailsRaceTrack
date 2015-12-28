package racetrack

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Race)
class RaceSpec extends Specification {
	
	def race;

    def setup() {
		race = new Race(distance:1000);
    }

    def cleanup() {
    }

    void "Given distance is 1000km Then it should be 600 miles"() {
		expect:
			race.inMiles() == 600;
    }
	
	void "Given distance is 1000km When you add 60 miles Then it should be 610 miles"(){
		when:
			race.addMiles(60);
		then:
			race.inMiles() == 660;
	}
}
