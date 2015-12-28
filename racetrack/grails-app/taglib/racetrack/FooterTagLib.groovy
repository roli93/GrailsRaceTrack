package racetrack

class FooterTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	
	def grailsApplication;
	
	
	def thisYear = {
		out << new Date().format("yyyy")
	}
	
	def copyright = {attributes,body ->
		out << " © " + grailsApplication.config.myVariable + attributes.startDate+ " - "
		out << thisYear() + " " + body();
    }
	
}
