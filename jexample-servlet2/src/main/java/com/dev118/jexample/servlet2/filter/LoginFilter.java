package com.dev118.jexample.servlet2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev118.jexample.servlet2.LoginServlet;
import com.dev118.jexample.servlet2.util.ServletUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	private HttpServletRequest request;

	private HttpServletResponse response;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		this.request = (HttpServletRequest) request;
		this.response = (HttpServletResponse) response;

		HttpSession session = this.request.getSession();

		if (session.getAttribute(LoginServlet.SESSION_KEY_USERNAME) == null) {

			String loginPageUrl = ServletUtils.getBasePath(this.request)
					+ "login.jsp";

			this.response.sendRedirect(loginPageUrl);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
