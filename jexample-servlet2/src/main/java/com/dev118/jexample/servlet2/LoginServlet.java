package com.dev118.jexample.servlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.dev118.jexample.servlet2.util.ServletUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210097499047861148L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doLogin(request, response);

		// doLoginAdmin(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 只验证用户名和密码是否相同
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtils.isNoneBlank(username, password)
				&& username.equalsIgnoreCase(password)) {
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_KEY_USERNAME, username);

			// response.sendRedirect(basePath + "index.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			// response.sendRedirect(basePath + "login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 验证用户名和密码是否为配置文件中的默认数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void doLoginAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String defaultUserName = ServletUtils.getValue(request,
				KEY_DEFAULT_USERNAME);

		String defaultUserPassword = ServletUtils.getValue(request,
				KEY_DEFAULT_PASSWORD);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean userNameEq = defaultUserName.equals(username);
		boolean passwordEq = defaultUserPassword.equals(password);

		// String basePath = ServletUtils.getBasePath(request);
		if (userNameEq && passwordEq) {
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_KEY_USERNAME, username);

			// response.sendRedirect(basePath + "index.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else {
			// response.sendRedirect(basePath + "login.jsp");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	private final static String KEY_DEFAULT_USERNAME = "default.user.name";

	private final static String KEY_DEFAULT_PASSWORD = "default.user.password";

	public final static String SESSION_KEY_USERNAME = "USER_NAME";

}
