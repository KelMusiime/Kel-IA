import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Flashcard {
    private String term;
    private String definition;

    public Flashcard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}

class FlashcardApp extends JFrame implements ActionListener {
    private List<Flashcard> flashcards;
    private JTextField termField;
    private JTextField definitionField;
    private JTextArea displayArea;

    public FlashcardApp() {
        flashcards = new ArrayList<>();

        JLabel termLabel = new JLabel("Term:");
        termField = new JTextField(20);

        JLabel definitionLabel = new JLabel("Definition:");
        definitionField = new JTextField(20);

        JButton addButton = new JButton("Add Flashcard");
        addButton.addActionListener(this);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(termLabel);
        inputPanel.add(termField);
        inputPanel.add(definitionLabel);
        inputPanel.add(definitionField);
        inputPanel.add(addButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Flashcard App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String term = termField.getText();
        String definition = definitionField.getText();
        if (!term.isEmpty() && !definition.isEmpty()) {
            Flashcard card = new Flashcard(term, definition);
            flashcards.add(card);
            updateDisplay();
            termField.setText("");
            definitionField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both term and definition.");
        }
    }

    private void updateDisplay() {
        displayArea.setText("");
        for (Flashcard card : flashcards) {
            displayArea.append("Term: " + card.getTerm() + "\n");
            displayArea.append("Definition: " + card.getDefinition() + "\n\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlashcardApp();
            }
        });
    }
}



