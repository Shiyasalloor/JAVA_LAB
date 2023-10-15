/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION9;

/**
 *
 * @author cusat
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JFrame implements ActionListener {
    private final int GRID_SIZE = 3;
    private final JButton[][] gridButtons;
    private char currentPlayer = 'X';

    public TicTacToeGame() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
        initializeButtons();
        setVisible(true);
        setResizable(false);
    }

    private void initializeButtons() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridButtons[row][col] = new JButton("");
                gridButtons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                gridButtons[row][col].addActionListener(this);
                add(gridButtons[row][col]);
            }
        }
    }

    private boolean checkWinner() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            return true;
        }
        return false;
    }

    private boolean checkRows() {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (!gridButtons[row][0].getText().isEmpty()
                    && gridButtons[row][0].getText().equals(gridButtons[row][1].getText())
                    && gridButtons[row][0].getText().equals(gridButtons[row][2].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (!gridButtons[0][col].getText().isEmpty()
                    && gridButtons[0][col].getText().equals(gridButtons[1][col].getText())
                    && gridButtons[0][col].getText().equals(gridButtons[2][col].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (!gridButtons[0][0].getText().isEmpty()
                && gridButtons[0][0].getText().equals(gridButtons[1][1].getText())
                && gridButtons[0][0].getText().equals(gridButtons[2][2].getText())) {
            return true;
        }

        if (!gridButtons[0][2].getText().isEmpty()
                && gridButtons[0][2].getText().equals(gridButtons[1][1].getText())
                && gridButtons[0][2].getText().equals(gridButtons[2][0].getText())) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (gridButtons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }

    private void resetGame() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridButtons[row][col].setText("");
            }
        }
        currentPlayer = 'X';
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().isEmpty() && !checkDraw()) {
            clickedButton.setText(Character.toString(currentPlayer));
            if (checkWinner()) {
                displayMessage("Player " + currentPlayer + " wins!");
            } else if (checkDraw()) {
                displayMessage("It's a Draw!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            }
        }
    }

    public static void main(String[] args) {
        TicTacToe tic = new TicTacToe();
    }
}
