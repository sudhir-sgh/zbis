package com.zopper.bsi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
/**
 * Created by sudhir on 18/5/16.
 */
/**
 */
@Configuration
public class MailSenderConfig {

    private @Value("${spring.email.protocal}") String protocol;
    private @Value("${spring.email.host}") String host;
    private @Value("${spring.email.port}") int port;
    private @Value("${spring.email.username}") String user;
    private @Value("${spring.email.password}") String pwd;

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl javaMailSenderImpl=new JavaMailSenderImpl();
        javaMailSenderImpl.setProtocol(this.protocol);
        javaMailSenderImpl.setHost(this.host);
        javaMailSenderImpl.setPort(this.port);
        String isAuthenticated = "true";
        String isStarttlsEnable = "true";

        if (Boolean.valueOf(isAuthenticated)) {
            javaMailSenderImpl.setUsername(this.user);
            javaMailSenderImpl.setPassword(this.pwd);
            Properties props=new Properties();
            props.setProperty("mail.smtp.auth",isAuthenticated);
            props.setProperty("mail.smtp.starttls.enable",isStarttlsEnable);
            javaMailSenderImpl.setJavaMailProperties(props);
        }
        return javaMailSenderImpl;
    }
}
