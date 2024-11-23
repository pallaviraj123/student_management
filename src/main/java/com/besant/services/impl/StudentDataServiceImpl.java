package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besant.model.Student;
import com.besant.service.StudentDataService;
import com.besant.utils.JdbcConnection;

public class StudentDataServiceImpl implements StudentDataService {

	@Override
	public void studentData(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
//			invoking JDBC Connection
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "insert into studentmanagement.studentdata  (name,studId,email,phnNo,department,course,address,passYear,dob,create_id) values(?,?,?,?,?,?,?,?,?,?	)";
			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();

			Student student = new Student();
			student.setName(req.getParameter("name"));
			student.setStudentId(req.getParameter("studId"));
			student.setEmail(req.getParameter("email"));
			student.setPhoneNumber(req.getParameter("phnNo"));
			student.setDepartment(req.getParameter("department"));
			student.setCourse(req.getParameter("course"));
			student.setAddress(req.getParameter("address"));
			student.setPassout(req.getParameter("passYear"));
			student.setDob(req.getParameter("fffffffffffffffff"));

			pre.setString(1, student.getName());
			pre.setString(2, student.getStudentId());
			pre.setString(3, student.getEmail());
			pre.setString(4, student.getPhoneNumber());
			pre.setString(5, student.getDepartment());
			pre.setString(6, student.getCourse());
			pre.setString(7, student.getAddress());
			pre.setString(8, student.getPassout());
			pre.setString(9, student.getDob());
			HttpSession session = req.getSession();

			pre.setInt(10, (int) session.getAttribute("userId"));

			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("login.html");
				out.println("<h2>Success: Data successfully inserted into the database.</h2>");
			} else {
				out.println("<h2>Error: No rows inserted.</h2>");
			}
			out.println("<p>This is a basic servlet example in Java EE.</p>");
			out.println("</body></html>");
			// Close resources
			pre.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
