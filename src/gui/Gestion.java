package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author seysn
 */
public class Gestion extends JFrame {
    private JLabel title;
    private JButton valider, retour;
    private JPanel content, buttons;

    public Gestion() {
        init();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setTitle("Gestion");
        setLayout(new BorderLayout());
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("Bonjour Machin");
        addButtons();
        add(title, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
        buttons.add(valider);
        buttons.add(retour);
        add(buttons, BorderLayout.SOUTH);
    }

    private void addButtons() {
        // TODO
    }
}
