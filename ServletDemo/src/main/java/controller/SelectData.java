package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import POJO.student;


public class SelectData {

    public static student getStudentByid(int id) {
        student s = new student();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/login";
            String username = "root";
            String password = "Akash@2002";

            // Establish the database connection
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement("select * from student where id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setPassword(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setAddress(rs.getString(5));
                s.setCity(rs.getString(6));
                s.setCountry(rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                // Close resources in the reverse order of their creation
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return s;
    }

    public static List<student> getAllStudents() {
        List<student> list = new ArrayList<student>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Connectiondata.getConnection();
            pst = con.prepareStatement("select * from student");
            rs = pst.executeQuery();

            while (rs.next()) {
                student s = new student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setPassword(rs.getString(3));
                s.setEmail(rs.getString(4));
                s.setAddress(rs.getString(5));
                s.setCity(rs.getString(6));
                s.setCountry(rs.getString(7));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                // Close resources in the reverse order of their creation
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }
}
