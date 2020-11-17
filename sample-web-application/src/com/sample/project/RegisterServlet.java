package com.sample.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String url = "jdbc:mysql://localhost:3306/southex_term6";
		String username = "root";
		String password = "pankaj";
		
		PrintWriter out = response.getWriter();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Start");
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into student (username, password, email, mobile) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("Connection");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setString(4, phone);

			int result = ps.executeUpdate();
             RequestDispatcher rd = null;
			if (result > 0) {
				rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
