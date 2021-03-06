package com.gestionRDV.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionRDV.dao.DBRequests;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String account = request.getParameter("account");

		String page = "index.jsp";
		if (username.trim().length() >= 0 && username != null && password.trim().length() >= 0 && password != null) 
		{
			
			int result = DBRequests.login(username, password,account);
			System.out.print(result);
			if (result != -1) {
				System.out.println("Login success!!!");
				request.getSession().setAttribute("id", result);
				request.setAttribute("msg", "Login Success.....");
				page = "home.jsp";
			} else 
			{
				request.setAttribute("msg", "Assurez-vous que votre nom d'utilisateur et le mot de pass sont corrects !!!");
			}
			} else {
				request.setAttribute("msg", "entrez le nom d'utilisateur et le mot de pass ...");
			}
			request.getRequestDispatcher(page).include(request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
