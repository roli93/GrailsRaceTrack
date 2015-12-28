package racetrack



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UsrController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Usr.list(params), model:[usrInstanceCount: Usr.count()]
    }
	
	def userChecker = this.&checkSession
	def beforeInterceptor = [action:this.userChecker, except:["login","logout","authenticate"]]
	
	def login(){}
	
	def logout(){
		redirect action:"login"
	}
	
	def authenticate(){
		def login = params.login
		def password = params.password
		def user = Usr.findByLoginAndPassword(login,password)
		
		if(user){
			session.user = user;
			userChecker = this.&checkRole()
			flash.message = "Hello, ${user.login}! Wanna win a race?";
			redirect(controller: "race")
		}
		else{
			flash.message = "Either the username or the password is incorrect"
			redirect(action:"login");		
		}
		
	}

    def show(Usr usrInstance) {
        respond usrInstance
    }

    def create() {
        respond new Usr(params)
    }

    @Transactional
    def save(Usr usrInstance) {
        if (usrInstance == null) {
            notFound()
            return
        }

        if (usrInstance.hasErrors()) {
            respond usrInstance.errors, view:'create'
            return
        }

        usrInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usr.label', default: 'Usr'), usrInstance.id])
                redirect usrInstance
            }
            '*' { respond usrInstance, [status: CREATED] }
        }
    }

    def edit(Usr usrInstance) {
        respond usrInstance
    }

    @Transactional
    def update(Usr usrInstance) {
        if (usrInstance == null) {
            notFound()
            return
        }

        if (usrInstance.hasErrors()) {
            respond usrInstance.errors, view:'edit'
            return
        }

        usrInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Usr.label', default: 'Usr'), usrInstance.id])
                redirect usrInstance
            }
            '*'{ respond usrInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Usr usrInstance) {

        if (usrInstance == null) {
            notFound()
            return
        }

        usrInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Usr.label', default: 'Usr'), usrInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usr.label', default: 'Usr'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
