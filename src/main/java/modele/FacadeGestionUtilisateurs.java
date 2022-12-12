package modele;

import java.util.Collection;

public interface FacadeGestionUtilisateurs {

    void inscription(String pseudo, String motDePasse) throws PseudoDejaExistantException, DonneesNonValidesException;

    String connexion(String pseudo, String motDePasse) throws IdentifiantsNonValidesException,
            UtilisateurDejaConnecteException;

    void deconnexion(String cle) throws CleInexistanteException;

    Utilisateur getUtilisateurParCle(String cle) throws CleInexistanteException;


    Collection<Utilisateur> getTousLesUtilisateurs(String cle) throws CleInexistanteException;

}
