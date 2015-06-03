package utils;

import javax.swing.JLabel;

public class LabelEtu extends JLabel {
    public static final int PRESENT = 0;
    public static final int RETARD = 1;
    public static final int ABSENT = 2;
    private String nom;
    private int statut;
    
    public LabelEtu(String nom) {
        super(nom);
        this.nom = nom;
        this.statut = 0;
    }
    
    public int getStatut() {
        return statut % 3;
    }
    
    public void increment(){
        this.statut += 1;
    }
}
