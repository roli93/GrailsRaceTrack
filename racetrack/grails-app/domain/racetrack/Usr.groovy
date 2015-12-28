package racetrack

class Usr {
	
	String login
	String password = "1234"
	String role = "user"
	
	static constraints = {
		login(blank:false, nullable:false, unique:true)
		password(blank:false, password:true)
		role(inList:["admin", "user"])
	}
	
	static transients = ['admin']
	
	boolean isAdmin(){
		role == "admin";
	}
	
	String toString(){
		login
	}
	
}
