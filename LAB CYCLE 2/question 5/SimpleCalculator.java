/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION5;

/**
 *
 * @author cusat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextField textField;
    private double firstOperand;
    private String operator;
    private boolean newCalculation;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        firstOperand = 0;
        operator = "";
        newCalculation = true;

        textField = new JTextField(10);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "1", "2", "3", "/",
                "4", "5", "6", "*",
                "7", "8", "9", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.matches("[0-9.]")) {
                handleDigit(command);
            } else if (command.matches("[+\\-*/=]")) {
                handleOperator(command);
            }
        }
    }

    private void handleDigit(String digit) {
        if (newCalculation) {
            textField.setText(digit);
            newCalculation = false;
        } else {
            textField.setText(textField.getText() + digit);
        }
    }

    private void handleOperator(String newOperator) {
        if (operator.isEmpty()) {
            firstOperand = Double.parseDouble(textField.getText());
        } else {
            double secondOperand = Double.parseDouble(textField.getText());
            firstOperand = calculate(firstOperand, secondOperand, operator);
            textField.setText(String.valueOf(firstOperand));
        }

        operator = newOperator;
        newCalculation = true;
    }

    private double calculate(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN; // Division by zero
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}

