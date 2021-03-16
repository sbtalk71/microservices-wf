package com.shantanu.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@SpringBootApplication
public class Oauth2ClientApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Oauth2ClientApplication.class);

    @Value("#{ @environment['example.baseUrl'] }")
    private String serverBaseUrl;

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("example.oauth2.client")
    protected ClientCredentialsResourceDetails oAuthDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    protected OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(oAuthDetails());
    }

    @Override
    public void run(String... args) {
        logger.info("MOD: {}", restTemplate().getForObject(serverBaseUrl + "/test", String.class));
    }
}
