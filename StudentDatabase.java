package ui;

import java.sql.*;
import java.io.FileWriter;
import javax.swing.*;

public class StudentDatabase {
    static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    static final String USER = "root";
    static final String PASS = "root"; 

    public static boolean insertStudent(String name, int marks, int attendance, int assignment) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "INSERT INTO students (name, marks, attendance, assignment_score) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, marks);
            pst.setInt(3, attendance);
            pst.setInt(4, assignment);
            pst.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Insert Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean exportToCSV() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            FileWriter fw = new FileWriter("student_data.csv");
            fw.write("ID,Name,Marks,Attendance,Assignment Score\n");

            while (rs.next()) {
                fw.write(rs.getInt("id") + "," + rs.getString("name") + "," + rs.getInt("marks") + ","
                        + rs.getInt("attendance") + "," + rs.getInt("assignment_score") + "\n");
            }

            fw.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ Export Error: " + e.getMessage());
            return false;
        }
    }
}
