package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Group extends JFrame implements ActionListener {

	private JLabel title;
	private JPanel content;
	private JButton deconnexion;

	public Group(String text) {
		this.init();
		
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void init() {
	    setLayout(new BorderLayout());
	    title = new JLabel("Selection du Groupe");
	    title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setPreferredSize(new Dimension(320,50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 24));
        add(title, BorderLayout.NORTH);
        content = new JPanel();
        content.setLayout(new GridLayout(0, 1));
        addGroups();
        add(content, BorderLayout.CENTER);
        deconnexion = new JButton("Se deconnecter");
        add(deconnexion, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(Login.WIDTH, Login.HEIGHT));
	}
	
	private void addGroups() {
	    for (int i = 0; i < 4; i++) {
	        JButton b = new JButton("Groupe "+i);
	        content.add(b);
        }
    }

    public static void main(String[] args) {
        new Group("Machin");
    }
}
