package ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class StudentForm {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("🎓 Student Performance Predictor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 300);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(6, 2, 12, 12));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JTextField nameField = new JTextField();
            JTextField marksField = new JTextField();
            JTextField attendanceField = new JTextField();
            JTextField assignmentField = new JTextField();

            JButton submitButton = new JButton("Submit");
            JButton exportButton = new JButton("Export to CSV");

            submitButton.setBackground(new Color(66, 135, 245));
            submitButton.setForeground(Color.WHITE);
            exportButton.setBackground(new Color(40, 180, 99));
            exportButton.setForeground(Color.WHITE);

            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Marks (out of 100):"));
            panel.add(marksField);
            panel.add(new JLabel("Attendance (%):"));
            panel.add(attendanceField);
            panel.add(new JLabel("Assignment Score (out of 100):"));
            panel.add(assignmentField);
            panel.add(submitButton);
            panel.add(exportButton);

            submitButton.addActionListener(e -> {
                String name = nameField.getText().trim();
                int marks = Integer.parseInt(marksField.getText().trim());
                int attendance = Integer.parseInt(attendanceField.getText().trim());
                int assignment = Integer.parseInt(assignmentField.getText().trim());

                boolean success = StudentDatabase.insertStudent(name, marks, attendance, assignment);
                JOptionPane.showMessageDialog(frame, success ? "Data inserted!" : "Error inserting data.");
            });

            exportButton.addActionListener(e -> {
                boolean success = StudentDatabase.exportToCSV();
                JOptionPane.showMessageDialog(frame, success ? "Exported to CSV!" : "Error exporting to CSV.");
            });

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
