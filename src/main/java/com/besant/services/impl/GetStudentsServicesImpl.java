package com.besant.services.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.service.GetStudentsServices;
import com.besant.utils.JdbcConnection;

public class GetStudentsServicesImpl implements GetStudentsServices {

	@Override
	public void viewStudents(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();

		try {
			JdbcConnection.jdbc();

			PreparedStatement pre = JdbcConnection.con.prepareStatement("SELECT * FROM studentmanagement.studentdata");
			ResultSet rs = pre.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setStudentId(rs.getString("studentId"));
				student.setEmail(rs.getString("email"));
				student.setPhoneNumber(rs.getString("phoneNumber"));
				student.setDepartment(rs.getString("department"));
				student.setCourse(rs.getString("course"));
				student.setAddress(rs.getString("address"));
				student.setCreatorId(rs.getInt("creatorId"));
				student.setCreatedAt(rs.getTimestamp("created_at"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("students", students);
		req.getRequestDispatcher("students.jsp").forward(req, res);
	}

}
