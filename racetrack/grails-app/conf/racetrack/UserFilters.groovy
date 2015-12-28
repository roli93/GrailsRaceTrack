package racetrack

class UserFilters {

    def filters = {
        all(controller:'usr|registration|runner', action:'*', actionExclude: 'login|logout|athenticate') {
            before = {
				if(!session?.user?.admin){
					flash.message = "Sorry, admin only"
					redirect(controller:"race", action:"index")
					return false
				}
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
