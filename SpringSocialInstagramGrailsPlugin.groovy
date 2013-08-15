class SpringSocialInstagramGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def title = "Spring Social Instagram Plugin"
    def description = 'Uses Instagram via Spring Social API.'
    def documentation = "http://grails.org/plugin/spring-social-instagram"

    def license = "APACHE"
    def organization = [name: "REID Consulting", url: "http://realizeideas.net/"]
    def developers = [
        [name: "Michael Astreiko", email: "michael.astreiko@realizeideas.net"],
        [name: "Vladimir Moroz", email: "moroz@realizeideas.net"]]

    def issueManagement = [system: "GitHub", url: "https://github.com/RealizeIdeas/grails-spring-social-instagram/issues"]
    def scm = [url: "https://github.com/RealizeIdeas/grails-spring-social-instagram"]

    def doWithSpring = {
        xmlns context: "http://www.springframework.org/schema/context"
        context.'component-scan'('base-package': "net.realizeideas.springconfig.instagram")
    }
}
