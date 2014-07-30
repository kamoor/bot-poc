package com.bot.server;

import org.apache.log4j.Logger;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.properties.ServerProperties;
import org.springframework.http.HttpStatus;

/**
 * customize any server configuration
 * 
 * @author kamoorr
 * 
 */
public class ServerCustomization extends ServerProperties {

	static Logger logger = Logger.getLogger(ServerCustomization.class);

	

	/**
	 * This will override any properties loaded by application.properties. Be
	 * careful about this one
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainerFactory factory) {

		super.customize(factory);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
				"/~core/error.jsp"));
		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
				"/~core/error.jsp"));
		factory.addErrorPages(new ErrorPage("/~core/error.jsp"));
		logger.info("Server listening at port: " + factory.getPort());
	}

}
