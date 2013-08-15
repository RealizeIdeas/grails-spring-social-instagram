package net.realizeideas.springconfig.instagram;

import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.instagram.api.Instagram;
import org.springframework.social.instagram.api.impl.InstagramTemplate;
import org.springframework.social.instagram.connect.InstagramConnectionFactory;
import org.springframework.util.Assert;

import java.util.Map;

// Spring configuration for connection to instagram profile
@Configuration
public class InstagramConfig {

    @Autowired
    GrailsApplication grailsApplication;
    @Autowired
    ConnectionRepository connectionRepository;

    @Bean
    @DependsOn(value = {"grailsApplication"})
    ConnectionFactory instagramConnectionFactory() {
        System.out.println("Configuring SpringSocial Instagram...");

        String clientId = (String) ((Map) grailsApplication.getConfig().get("instagram")).get("clientId");
        String clientSecret = (String) ((Map) grailsApplication.getConfig().get("instagram")).get("clientSecret");

        Assert.hasText(clientId, "The Instagram clientId is necessary, please add to the Config.groovy as follows: instagram.clientId='yourClientId'");
        Assert.hasText(clientSecret, "The Instagram clientSecret is necessary, please add to the Config.groovy as follows: instagram.clientSecret='yourClientSecret'");
        return new InstagramConnectionFactory(clientId, clientSecret);
    }

    @Bean
    @DependsOn(value = {"grailsApplication"})
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    Instagram instagram() {
        Connection<Instagram> instagram = connectionRepository.findPrimaryConnection(Instagram.class);
        String clientId = (String) ((Map) grailsApplication.getConfig().get("instagram")).get("clientId");
        return instagram != null ? instagram.getApi() : new InstagramTemplate(clientId);
    }

}
