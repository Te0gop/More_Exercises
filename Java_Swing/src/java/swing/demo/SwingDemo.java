package java.swing.demo;

import javax.swing.*;

public class SwingDemo {

    public SwingDemo() {
        // Create new JFrame container
        JFrame jFrame = new JFrame("First Swing Application");

        // Give it a size
        jFrame.setSize(275, 100);

        // Terminate the program when the user closes the application
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel
        JLabel jLabel = new JLabel("Add text to app.");

        // Add to the frame
        jFrame.add(jLabel);

        // Show it
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {  // create anonymous class
            @Override
            public void run() {
                new SwingDemo();
            }
        });

        // Another way is to replace with lambda:
        //SwingUtilities.invokeLater(() -> new SwingDemo());

        // Or method reference:
        //SwingUtilities.invokeLater(SwingDemo::new);
    }
}
