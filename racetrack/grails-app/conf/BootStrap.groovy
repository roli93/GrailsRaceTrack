import racetrack.Race
import racetrack.Registration
import racetrack.Runner
import grails.util.Environment

class BootStrap {

	def init = { servletContext ->
		switch(Environment.current){
			case Environment.DEVELOPMENT:
				def jane = new Runner(
				firstName:"Jane",
				lastName:"Doe",
				dateOfBirth:(new Date() - 365*30),
				gender:"F",
				address:"123 Main St",
				city:"Goose",
				state:"NC",
				zipcode:"12345",
				email:"jane@whereever.com"
				)
				jane.save()
				if(jane.hasErrors()){
					println jane.errors
				}
				def trot = new Race(
						name:"Turkey Trot",
						startDate:(new Date() + 90),
						city:"Duck",
						state:"NC",
						distance:5.0,
						cost:20.0,
						maxRunners:350
						)
				trot.save()
				if(trot.hasErrors()){
					println trot.errors
				}
				else{
					println "TROT SAVED"
				}
				def trot2 = new Race(
					name:"BsAs Trot",
					startDate:(new Date() + 90),
					city:"Duck",
					state:"NC",
					distance:5.0,
					cost:20.0,
					maxRunners:350
					)
			trot2.save()
			if(trot2.hasErrors()){
				println trot2.errors
			}
			else{
				println "TROT2 SAVED"
			}
				break
			case Environment.PRODUCTION : break
		}
	}
	def destroy = {
	}
}
