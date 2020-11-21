package java.swing.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener{

    JLabel myLabel;

    public ButtonDemo() {

        // Create JFrame
        JFrame jFrame = new JFrame("Button");

        // Specify FlowLayout for the layout manager
        jFrame.setLayout(new FlowLayout());

        // Give a size to our frame
        jFrame.setSize(300, 100);

        // Exit on close
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a buttons
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");

        // Label
        myLabel = new JLabel("Press Button");

        // Add EventListener
        upButton.addActionListener(this);
        downButton.addActionListener(this);

        // Other way without implement ActionListener to this class
//        upButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                // Do the action needed
//                System.out.println("Up button clicked.");
//            }
//        });
//
//        // Same thing with down button, but replaced with lambda instead anonymous class
//        downButton.addActionListener(x -> System.out.println("Down button clicked."));


        // Add the buttons
        jFrame.add(upButton);
        jFrame.add(downButton);
        jFrame.add(myLabel);

        // Make it visible
        jFrame.setVisible(true);



    }

    public static void main(String[] args) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Add actions
        if(e.getActionCommand().equals("Up")) {
            myLabel.setText("You pressed Up");
        } else if (e.getActionCommand().equals("Down")) {
            myLabel.setText("You pressed Down");
        }
    }
}
