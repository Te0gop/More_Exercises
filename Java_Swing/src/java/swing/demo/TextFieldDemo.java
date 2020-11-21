package java.swing.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo implements ActionListener {
    JTextField jTextField;
    JButton reverseButton;
    JLabel promptLabel;
    JLabel contentLabel;

    public TextFieldDemo() {
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(300, 120);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a TextField
        jTextField = new JTextField(10);
        jTextField.setActionCommand("textField");

        // Create a Button
        reverseButton = new JButton("Reverse");

        // Add ActionListener (and implement ActionListener class)
        jTextField.addActionListener(this);
        reverseButton.addActionListener(this);

        // Create our label prompt
        promptLabel = new JLabel("Enter Text");
        contentLabel = new JLabel("");

        // Add to Frame
        jFrame.add(promptLabel);
        jFrame.add(jTextField);
        jFrame.add(reverseButton);
        jFrame.add(contentLabel);


        // Show things in the window
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reverse")) {
            // Reverse the String logic
            String originalString = jTextField.getText();
            String holder = "";

            for (int i = originalString.length() - 1; i >= 0 ; i--) {
                holder += originalString.charAt(i);
                contentLabel.setText(holder);
            }

        } else {
            // Enter was pressed while focus was in the textField
            contentLabel.setText("You pressed Enter. Text is: " + jTextField.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextFieldDemo();
            }
        });
    }


}
