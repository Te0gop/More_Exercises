package flashcard.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class FlashCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<FlashCard> cardList;
    private Iterator cardIterator;
    private FlashCard currentCard;
    private int currentCardIndex;
    private JButton showAnswer;
    private JFrame frame;
    private boolean isShowAnswer;

    public FlashCardPlayer() {
        // Build User Interface
        frame = new JFrame("Flash Card Player");
        JPanel mainPanel = new JPanel();
        Font mFont = new Font("Font", Font.BOLD, 22);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextArea(10, 20);
        display.setFont(mFont);

        JScrollPane questionJScrollPane = new JScrollPane(display);
        questionJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        questionJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        showAnswer = new JButton("Show answer");

        mainPanel.add(questionJScrollPane);
        mainPanel.add(showAnswer);
        showAnswer.addActionListener(new NextCardListener());

        // Add Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
        loadMenuItem.addActionListener(new OpenMenuListener());

        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        // Add to frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardPlayer();
            }
        });
    }
    class NextCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isShowAnswer) {
                display.setText(currentCard.getAnswer());
                showAnswer.setText("Next Card");
                isShowAnswer = false;
            } else {
                // Show next question
                if(cardIterator.hasNext()) {
                    showNextCard();
                } else {
                    // No more cards
                    display.setText("That was the last card.");
                    showAnswer.setEnabled(false);
                }
            }
        }
    }
    class OpenMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File selectedFile) {
        cardList = new ArrayList<FlashCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String line = null;

            while((line = reader.readLine()) != null) {
                makeCard(line);
            }

        } catch (Exception e) {
            System.out.println("Couldn't read file");
            e.printStackTrace();
        }

        // Show first card
        cardIterator = cardList.iterator();
        showNextCard();
    }

    private void makeCard(String lineParse) {
        String[] result = lineParse.split("/"); // [question, answer]
        if(result.length > 1) {
            FlashCard card = new FlashCard(result[0], result[1]);
            cardList.add(card);
            System.out.println("Made a card");
        }

          //Second way to do that:
//        StringTokenizer result = new StringTokenizer(lineParse, "/");
//        if(result.hasMoreTokens()) {
//            FlashCard card = new FlashCard(result.nextToken(), result.nextToken());
//            cardList.add(card);
//            System.out.println("Made a card");
//        }

    }
    private void showNextCard() {
        currentCard = (FlashCard) cardIterator.next();
        display.setText(currentCard.getQuestion());
        showAnswer.setText("Show Answer");
        isShowAnswer = true;
    }
}
