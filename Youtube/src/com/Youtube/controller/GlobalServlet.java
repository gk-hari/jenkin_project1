package com.Youtube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Youtube.entity.YoutubeEmployee;
import com.Youtube.service.YoutubeService;
import com.Youtube.service.YoutubeServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
@WebServlet("/GlobalServlet")
public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String option=request.getParameter("ac");
		if(option.equals("register"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			
			YoutubeEmployee ye=new YoutubeEmployee();
			ye.setName(name);
			ye.setPassword(password);
			ye.setEmail(email);
			ye.setAddress(address);
			
			YoutubeServiceInterface ys=YoutubeService.createServiceObject();
			int i=ys.createProfile(ye);
			
			if(i>0)
			{
				out.println("Profile created");
			}
			else
			{
				out.println("Profile not created");
			}
			
		}
		out.println("</body></html>");
	}

}
