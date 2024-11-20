package codigo;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.*;
import javax.swing.*;

public class HighlightUtil {
    private static final StyleContext cont = StyleContext.getDefaultStyleContext();
    private static final AttributeSet attrKeyword = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.ORANGE);
    private static final AttributeSet attrVariable = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.PINK);

    public static void highlight(JTextPane textPane, String[] keywords, String[] variables) {
        StyledDocument doc = textPane.getStyledDocument();
        String text = textPane.getText();

        // Reset all text to default color first
        doc.setCharacterAttributes(0, text.length(), cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.WHITE), true);

        // Highlight keywords
        for (String keyword : keywords) {
            int pos = 0;
            while ((pos = text.indexOf(keyword, pos)) >= 0) {
                // Ensure only whole words are highlighted
                if ((pos == 0 || !Character.isLetterOrDigit(text.charAt(pos - 1))) &&
                    (pos + keyword.length() == text.length() || !Character.isLetterOrDigit(text.charAt(pos + keyword.length())))) {
                    doc.setCharacterAttributes(pos, keyword.length(), attrKeyword, false);
                }
                pos += keyword.length();
            }
        }

        // Highlight variables
        for (String variable : variables) {
            int pos = 0;
            while ((pos = text.indexOf(variable, pos)) >= 0) {
                // Ensure only whole words are highlighted
                if ((pos == 0 || !Character.isLetterOrDigit(text.charAt(pos - 1))) &&
                    (pos + variable.length() == text.length() || !Character.isLetterOrDigit(text.charAt(pos + variable.length())))) {
                    doc.setCharacterAttributes(pos, variable.length(), attrVariable, false);
                }
                pos += variable.length();
            }
        }
    }

    // Method to test the highlighting
    public static void main(String[] args) {
        JFrame frame = new JFrame("Highlight Example");
        JTextPane textPane = new JTextPane();
        textPane.setText("int relacion(){\n    int x = 2;\n\n    relacion(){\n        sdasd;\n    }\n}");

        // Define keywords and variables
        String[] keywords = {"int", "const"};
        String[] variables = {"relacion", "suma"};

        // Highlight in textPane
        highlight(textPane, keywords, variables);

        frame.add(new JScrollPane(textPane));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}