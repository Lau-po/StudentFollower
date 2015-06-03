package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author seysn
 */
public class Gestion extends JFrame {
    private static final long serialVersionUID = 4310703450531062748L;
    public static JLabel label;
    private JLabel title;
    private JButton valider, retour;
    private JPanel content, buttons;
    private JScrollPane scrollpane;

    public Gestion() {
        init();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        title = new JLabel();
        valider = new JButton("Valider");
        retour = new JButton("Retour");
        content = new JPanel();
        buttons = new JPanel();
        scrollpane = new JScrollPane(content);
        setPreferredSize(new Dimension(320, 480));
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setPreferredSize(new Dimension(320,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("Bonjour Adolf Hitler");
        title.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 24));
        valider.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 16));
        retour.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 16));
        setTitle("Gestion");
        setLayout(new BorderLayout());
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.add(Box.createRigidArea(new Dimension(10,0)));
        addButtons();
        add(title, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
        buttons.add(valider);
        buttons.add(retour);
        add(buttons, BorderLayout.SOUTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addButtons() {
        for (int i = 0; i < 30; i++) {            
            addButton("Jean-Pierre Roger"+i);
            content.getComponent(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO FAIRE FONCTIONNER CA
                    if (content.getComponent(content.getComponentCount()-1).getBackground() == Color.GREEN) {
                        content.getComponent(content.getComponentCount() - 1).setBackground(Color.BLACK);
                    }
                    revalidate();
                }
            });
        }
    }
    
    private void addButton(String nom) {
        label = new JLabel(nom);
        label.setBackground(Color.GREEN);
        label.setOpaque(true);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 16));
        label.setMinimumSize(new Dimension(250,40));
        label.setMaximumSize(new Dimension(250,40));
        label.setPreferredSize(new Dimension(250,40));
        content.add(label);
        content.add(Box.createVerticalStrut(10));
    }
    
    public static void main(String[] args) {
        new Gestion();
    }
}
