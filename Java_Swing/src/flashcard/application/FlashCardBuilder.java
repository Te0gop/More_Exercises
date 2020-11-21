package flashcard.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FlashCardBuilder {

    JTextArea question;
    JTextArea answer;
    private ArrayList<FlashCard> cardList;
    private JFrame frame;

    public FlashCardBuilder() {
        frame = new JFrame("Flash card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold everything
        JPanel mainPanel = new JPanel();

        // Create font
        Font font = new Font("Font", Font.BOLD, 21);
        question = new JTextArea(6, 20);
        question.setLineWrap(true); // sure that text fits when is too long
        question.setWrapStyleWord(true);
        question.setFont(font);

        // Question area
        JScrollPane questionJScrollPane = new JScrollPane(question);
        questionJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        questionJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Answer area
        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(font);

        // JScrollPane
        JScrollPane answerJScrollPane = new JScrollPane(answer);
        answerJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        answerJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");

        cardList = new ArrayList<FlashCard>();


        // Create a few labels
        JLabel questionLabel = new JLabel("Question");
        JLabel answerLabel = new JLabel("Answer");

        // Add components to mainPanel
        mainPanel.add(questionLabel);
        mainPanel.add(questionJScrollPane);
        mainPanel.add(answerLabel);
        mainPanel.add(answerJScrollPane);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        // MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        // Add Event Listeners
        newMenuItem.addActionListener(new NewMenuItemListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        // Set Menu Bar in our JFrame and make the menu visible when program starts
        frame.setJMenuBar(menuBar);

        // Add to the frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    public JTextArea getQuestion() {
        return question;
    }

    public void setQuestion(JTextArea question) {
        this.question = question;
    }

    public JTextArea getAnswer() {
        return answer;
    }

    public void setAnswer(JTextArea answer) {
        this.answer = answer;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardBuilder();
            }
        });
    }
    public class NextCardListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            // Create a flashCard
            FlashCard card = new FlashCard(question.getText(), answer.getText());
            cardList.add(card);
            System.out.println("Size of ArrayList: " + cardList.size());
            clearCard();
        }
    }
    public class NewMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New menu clicked");
        }
    }
    public class SaveMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           FlashCard card = new FlashCard(question.getText(), answer.getText());
           cardList.add(card);

           // Create a file dialog with file chooser
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
    private void saveFile(File selectedFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));

            Iterator<FlashCard> cardIterator = cardList.iterator();

            while(cardIterator.hasNext()) {
                FlashCard card = cardIterator.next();
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();

            // Second way to do that:
//            for (FlashCard card : cardList) {
//                writer.write(card.getQuestion() + "/");
//                writer.write(card.getAnswer() + "\n");
//
//            }
        } catch (Exception e) {
            System.out.println("Couldn't write to file.");
            e.printStackTrace();
        }
    }
 }


