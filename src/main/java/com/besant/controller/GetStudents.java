package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.GetStudentsServicesImpl;

@WebServlet("/GetStudents")
public class GetStudents extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GetStudentsServicesImpl getStudentServicesImpl = new GetStudentsServicesImpl();
		getStudentServicesImpl.viewStudents(req, res);
	}
}
