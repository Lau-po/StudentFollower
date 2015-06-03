package utils;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelEtu extends JLabel {
  public static final int ABSENT = 2;
  public static final int PRESENT = 0;
  public static final int RETARD = 1;
  private String nom;
  private int statut;

  public LabelEtu(String nom) {
    super(nom);
    this.setNom(nom);
    this.statut = 0;
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        increment();
        if (getStatut() == RETARD) {
          setBackground(Color.CYAN);
        } else if (getStatut() == ABSENT) {
          setBackground(Color.RED);
        } else {
          setBackground(Color.WHITE);
        }
        repaint();
      }
    });
  }

  public String getNom() {
    return nom;
  }

  public int getStatut() {
    return statut % 3;
  }

  public void increment() {
    this.statut += 1;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
