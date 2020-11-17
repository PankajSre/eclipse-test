package com.sample.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/southex_term6";
		String user = "root";
		String pass = "pankaj";
		RequestDispatcher rd = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Start");
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			
			String sql = "select username, password from student where username='"+username+"' and password='"+password+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser", username);
				rd = req.getRequestDispatcher("welcome.jsp");
				rd.forward(req, resp);
			}
			else {
				out.println("<h2 style='color: red;'>Username or password does not match, try again</h2>");
				rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
