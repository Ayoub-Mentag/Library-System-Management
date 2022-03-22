package sample;

public class book {
    private int code;
    private String titre;
    private String auteur;
    private String edition;
    private int nbExemplaire;


    public book(int code, String titre, String auteur, String edition, int nbExemplaire) {
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.nbExemplaire = nbExemplaire;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getNbExemplaire() {
        return nbExemplaire;
    }

    public void setNbExemplaire(int nbExemplaire) {
        this.nbExemplaire = nbExemplaire;
    }


}
