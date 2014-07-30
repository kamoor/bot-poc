package com.bot.server;

import javax.servlet.MultipartConfigElement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultiPartConfigFactory;
import org.springframework.boot.context.embedded.properties.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring boot to start server on the fly and run an app. Parameters: --debug to
 * start in debug mode nube-portal-custom.properties: should be used for custom
 * properties
 * 
 * @author kamoorr
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource(ignoreResourceNotFound = true, value = {
		"classpath:application.properties", "classpath:nube-core.properties",
		"classpath:nube-portal.properties",
		"classpath:nube-portal-custom.properties", "classpath:admin.properties" })
@ImportResource(value = { "classpath*:spring/*.xml" })
public class Server {

	static Logger logger = Logger.getLogger(Server.class);

	public static void main(String[] args) {

		System.out.println("Start application manager");
		ApplicationContext ctx = SpringApplication.run(Server.class, args);
	}

	/**
	 * Server configuration customization
	 * 
	 * @return
	 */
	@Bean
	public ServerProperties getServerProperties() {
		return new ServerCustomization();
	}

	/**
	 * Create a MultiPart config to upload files. set max file size
	 * 
	 * @return
	 */
	@Bean
	MultipartConfigElement multipartConfigElement() {

		MultiPartConfigFactory factory = new MultiPartConfigFactory();
		factory.setMaxFileSize("15MB");
		factory.setMaxRequestSize("15MB");
		return factory.createMultipartConfig();
	}

}
