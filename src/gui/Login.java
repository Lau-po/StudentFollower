package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.Util;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

  public final static int HEIGHT = 480;
  public final static int WIDTH = 320;

  private JButton btnLogin, btnPwdForgot;
  private JPanel header, body, footer;
  private JLabel txtHeader, lbPassword, lbUsername;
  private JPasswordField txtPassword;
  private JTextField txtUsername;

  public Login() {
    this.init();

    this.buildHeader();
    add(header, BorderLayout.NORTH);

    lbUsername = new JLabel("Identifiant : ");
    txtUsername = new JTextField(15);

    lbPassword = new JLabel("Mot de passe :");
    txtPassword = new JPasswordField(15);

    this.buildBody();
    add(body, BorderLayout.CENTER);

    this.buildFooter();
    add(footer, BorderLayout.SOUTH);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  @SuppressWarnings("deprecation")
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.btnLogin) {
      if (Util.isAllowedToConnect(txtUsername.getText(), txtPassword.getText())) {
        setVisible(false);
        new Group();
      } else {
        JOptionPane.showMessageDialog(this, "Veuillez recommencer. ", "Connexion",
            JOptionPane.ERROR_MESSAGE);
      }
    } else if (e.getSource() == this.btnPwdForgot) {
      String email =
          JOptionPane.showInputDialog(this, "Entrez votre addresse mail : ", "exemple@domain.com",
              JOptionPane.INFORMATION_MESSAGE);
      if (Util.getLostPasswordByEmail(email) != null) {
        JOptionPane.showMessageDialog(this,
            "Votre mot de passe est " + Util.getLostPasswordByEmail(email));
      } else {
        JOptionPane.showMessageDialog(this, "Veuillez recommencer. ", "Mot de passe perdu",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void buildBody() {
    body = new JPanel();
    body.add(lbUsername);
    body.add(txtUsername);
    body.add(lbPassword);
    body.add(txtPassword);
  }

  private void buildFooter() {
    footer = new JPanel();
    btnLogin = new JButton("Connexion");
    btnLogin.addActionListener(this);
    btnPwdForgot = new JButton("Mot de passe, oublié?");
    btnPwdForgot.addActionListener(this);
    footer.add(btnLogin);
    footer.add(btnPwdForgot);
  }

  private void buildHeader() {
    header = new JPanel();
    txtHeader = new JLabel("Login");
    txtHeader.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 24));
    txtHeader.setHorizontalAlignment(JLabel.CENTER);
    header.add(txtHeader);
  }

  private void init() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }
}
