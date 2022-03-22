package sample;

import java.util.Date;

public class emprunteur {
     private int etudiant;
     private int livre;
     private String retourLivre;

    public emprunteur(int etudiant, int livre, String retourLivre) {
        this.etudiant = etudiant;
        this.livre = livre;
        this.retourLivre = retourLivre;
    }

    public int getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(int etudiant) {
        this.etudiant = etudiant;
    }

    public int getLivre() {
        return livre;
    }

    public void setLivre(int livre) {
        this.livre = livre;
    }

    public String getRetourLivre() {
        return retourLivre;
    }



    public void setRetourLivre(String retourLivre) {
        this.retourLivre = retourLivre;
    }
}
