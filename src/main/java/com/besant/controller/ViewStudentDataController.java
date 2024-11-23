package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view")
public class ViewStudentDataController extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("controller working");
//		System.out.println( req.getParameter("name"));
//		System.out.println( req.getParameter("studId"));
//		System.out.println( req.getParameter("email"));
//		System.out.println( req.getParameter("phnNo"));
//		System.out.println( req.getParameter("department"));
//		System.out.println( req.getParameter("course"));
//		System.out.println( req.getParameter("address"));
//		System.out.println( req.getParameter("passYear"));
//		System.out.println( req.getParameter("dob"));
}
}
