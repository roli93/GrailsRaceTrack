package racetrack

class Race {
	
	String name
	Date startDate
	String city
	String state
	BigDecimal distance
	BigDecimal cost
	Integer maxRunners = 100000
	static Closure dateValidator = {it >= new Date()}
	static searchable = true

    static constraints = {
		name(blank:false,maxLength:50)
		startDate(validator: Race.dateValidator)
		city()
		state(inList:["GA","NC","SC","VA"])
		distance(max:5.0)
		cost()
		maxRunners(max:100000)
    }
	
	static hasMany = [registrations:Registration]
	
	BigDecimal inMiles(){
		return distance*0.6;
	}
	
	void addMiles(BigDecimal miles){
		distance += miles/0.6;
	}
	
	String toString(){
		name
	}
	
}
