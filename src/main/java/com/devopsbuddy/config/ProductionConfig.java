package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.SmtpEmailService;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.devopsbuddy/application-prod.properties")
public class ProductionConfig {

//    @Value("${stripe.prod.private.key}")
//    private String stripeProdKey;

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
    
//    @Bean
//    public ServletRegistrationBean h2ConsoleServletRegistration() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
//        bean.addUrlMappings("/console/*");
//        return bean;
//    }

//    @Bean
//    public String stripeKey() {
//        return stripeProdKey;
//    }
}