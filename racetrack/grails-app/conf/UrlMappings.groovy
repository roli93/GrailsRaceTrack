class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/newRace" (controller:"race", action:"create")

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
