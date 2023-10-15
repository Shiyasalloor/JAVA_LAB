import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarAnimation extends JFrame implements ActionListener {
    private int carX, carY; // Car's current position
    private int carSpeed = 5; // Car's speed
    private Timer timer;
    private boolean isMoving = false;
    private JPanel buttonPanel;
    private int carWidth = 60; // Width of the car
    private Color carColor = Color.RED; // Car's color

    public CarAnimation() {
        setTitle("Car Animation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        carX = 0;
        carY = 100;

        // Create buttons
        JButton startButton = new JButton("Start");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pauseAnimation();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        });

        // Add buttons to the frame
        buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);

        // Create and start the timer for animation
        timer = new Timer(100, this);

        // Set layout to null to position buttons manually
        setLayout(null);
        buttonPanel.setBounds(0, 0, getWidth(), 40);
        add(buttonPanel);
    }

    public void startAnimation() {
        isMoving = true;
        timer.start();
    }

    public void pauseAnimation() {
        isMoving = false;
        timer.stop();
    }

    public void stopAnimation() {
        isMoving = false;
        carX = 0; // Reset car's position
        repaint();
        timer.stop();
    }

    public void paint(Graphics g) {
        // Draw the road
        g.setColor(Color.GRAY);
        g.fillRect(0, 130, getWidth(), 50);

        // Draw the car as a colored rectangle
        g.setColor(carColor);
        g.fillRect(carX, carY, carWidth, 30);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            if (isMoving) {
                carX += carSpeed;
                if (carX > getWidth()) {
                    carX = -carWidth; // Reset car's position when it goes off the screen
                }
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CarAnimation app = new CarAnimation();
                app.setVisible(true);
            }
        });
    }
}
