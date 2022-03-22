package sample;

public class member {
    private int id_member;
    private String user_name ;
    private String password;
    private String prenom;
    private String nom;
    private String ncart;
    private String adresse;
    private String ville;
    private String pays;
    private String email;
    private String telephone;
    private String profession;
    private String anne_etude;
    private String specialite;

    public member(int id_member, String user_name, String password, String prenom, String nom, String ncart,  String adresse, String ville, String pays, String email, String telephone, String profession, String anne_etude, String specialite) {
        this.id_member = id_member;
        this.user_name = user_name;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.ncart = ncart;
        this.adresse = adresse;
        this.ville = ville;
        this.pays = pays;
        this.email = email;
        this.telephone = telephone;
        this.profession = profession;
        this.anne_etude = anne_etude;
        this.specialite = specialite;
    }

    public int getId_member() {
        return id_member;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getNcart() {
        return ncart;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getProfession() {
        return profession;
    }

    public String getAnne_etude() {
        return anne_etude;
    }

    public String getSpecialite() {
        return specialite;
    }
}
