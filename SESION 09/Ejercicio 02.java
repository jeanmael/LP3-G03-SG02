import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

public class WordCountApp extends JFrame {
    private Panel controlPanel;
    private TextField txtFile;
    private Button btnCountWords;
    private Label lblLines;
    private Label lblWords;
    private Label lblChars;

    public WordCountApp() {
        super("Word Count");

        controlPanel = new Panel();
        txtFile = new TextField(30);
        btnCountWords = new Button("Count Words");
        lblLines = new Label("Lines: ");
        lblWords = new Label("Words: ");
        lblChars = new Label("Chars: ");

        controlPanel.add(new Label("File: "));
        controlPanel.add(txtFile);
        controlPanel.add(btnCountWords);

        add(controlPanel, BorderLayout.NORTH);
        add(new Label("Results: "), BorderLayout.SOUTH);

        btnCountWords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void countWords() {
        String fileName = "C:/Users/Usuario/Documents/tmp/" + txtFile.getText();
        try {
            String text = readFile(fileName);
            int lines = 0;
            int words = 0;
            int chars = 0;
            for (String line : text.split("\n")) {
                lines++;
                for (String word : line.split(" ")) {
                    if (isWord(word)) {
                        words++;
                    }
                }
                chars += line.length();
            }

            lblLines.setText("Lines: " + lines);
            lblWords.setText("Words: " + words);
            lblChars.setText("Chars: " + chars);
            controlPanel.add(lblLines);
            controlPanel.add(lblWords);
            controlPanel.add(lblChars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isWord(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String text = "";
        String line = reader.readLine();
        while (line != null) {
            text += line + "\n";
            line = reader.readLine();
        }
        reader.close();
        return text;
    }

    public static void main(String[] args) {
        new WordCountApp();
    }
}
