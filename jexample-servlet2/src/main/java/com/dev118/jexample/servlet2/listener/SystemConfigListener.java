package com.dev118.jexample.servlet2.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class SystemConfigListener
 *
 */
public class SystemConfigListener implements ServletContextListener {

	private final static String PARAM_KEY_SYSTEM_CONFIG = "SystemConfig";

	/**
	 * Default constructor.
	 */
	public SystemConfigListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("contextInitialized()");

		String systemConfigPath = sce.getServletContext().getInitParameter(
				PARAM_KEY_SYSTEM_CONFIG);

		InputStream ins = getClass().getResourceAsStream(systemConfigPath);
		Properties prop = new Properties();
		if (ins != null) {
			try {
				prop.load(ins);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Entry<Object, Object> entry : prop.entrySet()) {
			sce.getServletContext().setAttribute(
					String.valueOf(entry.getKey()), entry.getValue());
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");

	}

}
