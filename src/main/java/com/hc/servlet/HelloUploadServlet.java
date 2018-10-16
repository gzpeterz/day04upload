package com.hc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username is " + username);
		ServletInputStream in = request.getInputStream();
		byte[] buff = new byte[10240];
		int len = 0;
		while( (len = in.read(buff) ) != -1) {
			String str = new String(buff, 0, len);
			System.out.println(str);
		}
		String header = request.getHeader("content-type");
		int iii = 100;
		System.out.println(iii);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
