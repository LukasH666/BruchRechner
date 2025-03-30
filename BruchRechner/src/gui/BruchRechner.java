
package gui;

import logic.Bruch;

import javax.swing.*;

public class BruchRechner {
    private JTextField zaehler1Field;
    private JTextField nenner1Field;
    private JTextField zaehler2Field;
    private JTextField nenner2Field;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JLabel ergebnisLabel;
    private JLabel fehlerLabel;
    private JPanel mainPanel;

    public BruchRechner() {
        addButton.addActionListener(e -> rechnen("add"));
        subButton.addActionListener(e -> rechnen("sub"));
        mulButton.addActionListener(e -> rechnen("mul"));
        divButton.addActionListener(e -> rechnen("div"));
    }

    private void rechnen(String operation) {
        try {
            Bruch a = new Bruch(
                    Integer.parseInt(zaehler1Field.getText()),
                    Integer.parseInt(nenner1Field.getText()));
            Bruch b = new Bruch(
                    Integer.parseInt(zaehler2Field.getText()),
                    Integer.parseInt(nenner2Field.getText()));

            Bruch ergebnis;
            switch (operation) {
                case "add" -> ergebnis = a.add(b);
                case "sub" -> ergebnis = a.sub(b);
                case "mul" -> ergebnis = a.mul(b);
                case "div" -> ergebnis = a.div(b);
                default -> throw new IllegalStateException("Unbekannte Operation");
            }
            ergebnisLabel.setText("Ergebnis: " + ergebnis);
            fehlerLabel.setText("");
        } catch (Exception ex) {
            fehlerLabel.setText("Fehler: " + ex.getMessage());
            ergebnisLabel.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BruchRechner");
        frame.setContentPane(new BruchRechner().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
