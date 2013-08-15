class SpringSocialInstagramGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    Map dependsOn = ['springSocialCore': '0.1.31 > *']
    def title = "Spring Social Instagram Plugin" // Headline display name of the plugin
    def author = "Michael Astreiko"
    def authorEmail = "michael.astreiko@realizeideas.net"
    def description = '''\
Grails plugin to use Instagram via Spring Social API.
'''
    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/spring-social-instagram"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "REID Consulting", url: "http://realizeideas.net/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Michael Astreiko", email: "michael.astreiko@realizeideas.net" ],
                        [ name: "Vladimir Moroz", email: "moroz@realizeideas.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub", url: "https://github.com/RealizeIdeas/grails-spring-social-instagram/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/RealizeIdeas/grails-spring-social-instagram" ]


    def doWithSpring = {
        xmlns context: "http://www.springframework.org/schema/context"
        context.'component-scan'('base-package': "net.realizeideas.springconfig.instagram")
    }
}
