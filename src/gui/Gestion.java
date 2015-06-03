package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.LabelEtu;

/**
 * @author seysn
 */
public class Gestion extends JFrame {
    private static final long serialVersionUID = 4310703450531062748L;
    public static LabelEtu label;
    private JLabel title;
    private JButton valider, retour;
    private JPanel content, buttons;
    private JScrollPane scrollpane;
    public List<LabelEtu> list = new ArrayList<>();

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
        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(list.get(0).getStatut());
            }
        });
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
        
        for (int i = 0; i < 20; i++) {
            list.add(new LabelEtu("Jean-Pierre Roger"+i));
            addButton(list.get(i));
        }
    }
    
    private void addButton(LabelEtu label) {
        label.setBackground(Color.WHITE);
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
