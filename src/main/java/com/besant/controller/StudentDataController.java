package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.StudentDataServiceImpl;
@WebServlet("/studentdata")
public class StudentDataController extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		StudentDataServiceImpl studentDataServiceImpl=new StudentDataServiceImpl();
        studentDataServiceImpl.studentData(req,res);
		
}
}
