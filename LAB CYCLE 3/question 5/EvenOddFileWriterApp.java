import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class EvenOddFileWriterApp extends JFrame {
    private JTextField numberField;
    private JButton startButton;
    private JButton openEvenButton;
    private JButton openOddButton;

    public EvenOddFileWriterApp() {
        setTitle("Even and Odd File Writer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel numberLabel = new JLabel("Enter a number:");
        numberField = new JTextField(10);
        startButton = new JButton("Start");
        openEvenButton = new JButton("Open EVEN.txt");
        openOddButton = new JButton("Open ODD.txt");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(numberField.getText());

                Thread evenThread = new Thread(new FileWriterRunnable(number, "EVEN.txt", true));
                Thread oddThread = new Thread(new FileWriterRunnable(number, "ODD.txt", false));

                evenThread.start();
                oddThread.start();
            }
        });

        openEvenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile("EVEN.txt");
            }
        });

        openOddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile("ODD.txt");
            }
        });

        add(numberLabel);
        add(numberField);
        add(startButton);
        add(openEvenButton);
        add(openOddButton);
    }

    private void openFile(String filename) {
        try {
            Desktop.getDesktop().open(new java.io.File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EvenOddFileWriterApp().setVisible(true);
            }
        });
    }

    class FileWriterRunnable implements Runnable {
        private int maxNumber;
        private String fileName;
        private boolean isEven;

        public FileWriterRunnable(int maxNumber, String fileName, boolean isEven) {
            this.maxNumber = maxNumber;
            this.fileName = fileName;
            this.isEven = isEven;
        }

        public void run() {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (int i = 0; i < maxNumber; i++) {
                    if ((i % 2 == 0 && isEven) || (i % 2 != 0 && !isEven)) {
                        writer.write(Integer.toString(i) + "\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(EvenOddFileWriterApp.this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
