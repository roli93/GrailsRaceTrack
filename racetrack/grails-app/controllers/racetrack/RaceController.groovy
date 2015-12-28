package racetrack

class RaceController {	
	def scaffold = true;
	
	def search(){
		respond Race.search(params.q,params).results
	}
}
