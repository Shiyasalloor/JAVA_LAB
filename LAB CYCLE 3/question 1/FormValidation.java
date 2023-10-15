/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

/**
 *
 * @author ganes
 */
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class FormValidation {
    private final JFrame frame;
    private final JTextField numericField;
    private final JTextField charField;
    private final JTextField phoneField;
    private final JTextField emailField;
    private final JButton submitButton;

    public FormValidation() {
        frame = new JFrame("Form Validation Example");
        frame.setLayout(new GridLayout(5, 2));

        JLabel numericLabel = new JLabel("Numeric Field:");
        numericField = new JTextField();
        JLabel charLabel = new JLabel("Character Field:");
        charField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email Address:");
        emailField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateForm();
            }
        });

        frame.add(numericLabel);
        frame.add(numericField);
        frame.add(charLabel);
        frame.add(charField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(new JLabel()); // Empty space
        frame.add(submitButton);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void validateForm() {
        String numericInput = numericField.getText();
        String charInput = charField.getText();
        String phoneInput = phoneField.getText();
        String emailInput = emailField.getText();

        boolean numericValid = isNumeric(numericInput);
        boolean charValid = isAlphabetic(charInput);
        boolean phoneValid = isValidPhoneNumber(phoneInput);
        boolean emailValid = isValidEmail(emailInput);

        if (numericValid && charValid && phoneValid && emailValid) {
            JOptionPane.showMessageDialog(frame, "Form is valid!");
        } else {
            StringBuilder errorMessage = new StringBuilder("Form validation errors:\n");

            if (!numericValid) {
                errorMessage.append("- Numeric field is not valid.\n");
            }
            if (!charValid) {
                errorMessage.append("- Character field is not valid.\n");
            }
            if (!phoneValid) {
                errorMessage.append("- Phone number is not valid.\n");
            }
            if (!emailValid) {
                errorMessage.append("- Email address is not valid.\n");
            }

            JOptionPane.showMessageDialog(frame, errorMessage.toString(), "Validation Errors", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isNumeric(String input) {
        return Pattern.matches("\\d+", input);
    }

    private boolean isAlphabetic(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }

    private boolean isValidPhoneNumber(String input) {
        return Pattern.matches("^\\d{10}$", input);
    }

    private boolean isValidEmail(String input) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,4}$", input);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormValidation();
            }
        });
    }
}
