package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Group extends JFrame implements ActionListener {

	private JPanel header;
	private JLabel txtHeader;

	public Group(String text) {
		this.init();
		
		this.buildHeader();
		add(header, BorderLayout.NORTH);
		
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(Login.WIDTH, Login.HEIGHT));
	}
	
	private void buildHeader() {
		header = new JPanel();
		txtHeader = new JLabel("Selection du groupe");
		txtHeader.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 24));
		txtHeader.setHorizontalAlignment(JLabel.CENTER);
		header.add(txtHeader);
	}

}
