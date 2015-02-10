package com.dev118.jexample.servlet2.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public final class ServletUtils {

	private ServletUtils() {
	}

	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String serverHost = request.getServerName();
		String basePath = request.getScheme() + "://" + serverHost + ":"
				+ request.getServerPort() + path + "/";
		return basePath;
	}

	public static String getValue(HttpServletRequest request, String key) {
		ServletContext sc = request.getSession().getServletContext();
		String value = String.valueOf(sc.getAttribute(key));
		return value;
	}

}
