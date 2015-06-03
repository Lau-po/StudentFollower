package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.Util;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
  private JButton btnLogin, btnPwdForgot;
  private Container cp;
  private Panel inputs, btns;
  private JLabel lbUsername, lbPassword;
  private JTextField txtUsername, txtPassword;

  public Login() {
    cp = getContentPane();
    lbUsername = new JLabel("Identifiant :");
    lbPassword = new JLabel("Mot de passe :");
    txtUsername = new JTextField(25);
    txtPassword = new JTextField(25);
    txtPassword = new JPasswordField(10);
    inputs = new Panel();
    inputs.setLayout(new GridLayout(3, 5));
    inputs.add(lbUsername);
    inputs.add(txtUsername);
    inputs.add(lbPassword);
    inputs.add(txtPassword);
    btnLogin = new JButton("Connexion");
    btnLogin.addActionListener(this);
    btnLogin.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 16));
    btnPwdForgot = new JButton("Mot de passe, oublié ?");
    btnPwdForgot.addActionListener(this);
    btnPwdForgot.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 16));
    btns = new Panel();
    btns.setLayout(new FlowLayout());
    btns.add(btnLogin);
    btns.add(btnPwdForgot);
    cp.add(inputs, BorderLayout.PAGE_START);
    cp.add(btns, BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(320, 480);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.btnLogin) {
      if (Util.isAllowedToConnect(txtUsername.getText(), txtPassword.getText())) {
        // TODO
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
}
