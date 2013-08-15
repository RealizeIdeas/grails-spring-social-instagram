grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        compile "javax.inject:javax.inject:1"
        compile "org.codehaus.jackson:jackson-mapper-asl:1.9.9"
		  compile("org.springframework.security:spring-security-crypto:3.1.0.RC3") { transitive = false }
    }

    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }

        compile(":spring-security-core:1.2.7.3") {
            export = false
        }

        compile ":spring-social-core:0.1.31"
    }
}
