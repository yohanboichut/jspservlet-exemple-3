package modele;

public class Utilisateur {

    private String pseudo;
    private String motDePasse;


    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String motDePasse) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public boolean checkMotDePasse(String mdp) {
        return this.motDePasse.equals(mdp);
    }

}
