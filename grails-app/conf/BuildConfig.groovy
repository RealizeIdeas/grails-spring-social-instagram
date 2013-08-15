grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        mavenRepo 'http://maven.springframework.org/milestone/'
    }

    dependencies {
        compile "javax.inject:javax.inject:1"
        compile "org.codehaus.jackson:jackson-mapper-asl:1.9.9"
        compile 'org.springframework.security:spring-security-crypto:3.1.0.RC3', {
            excludes 'commons-logging', 'spring-core'
        }

        compile 'org.springframework.social:spring-social-core:1.1.0.M3', {
            excludes 'httpclient', 'spring-jdbc', 'spring-security-crypto', 'spring-web'
        }
        compile 'org.springframework.social:spring-social-web:1.1.0.M3', {
            excludes 'javax.servlet.jsp-api', 'servlet-api', 'spring-social-core', 'spring-web', 'spring-webmvc'
        }
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
