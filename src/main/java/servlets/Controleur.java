package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.*;

import java.io.IOException;


public class Controleur extends HttpServlet {

    private static final String HOME = "home";
    private static final String CONNEXION = "connexion";
    private static final String DECONNEXION = "deconnexion";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String[] parties = uri.split("/");
        String cleNavigation = parties[parties.length-1];
        String destination = "/WEB-INF/pages/accueil.jsp";

        FacadeGestionUtilisateurs facade = (FacadeGestionUtilisateurs)
                this.getServletContext().getAttribute("facade");

        if (HOME.equals(cleNavigation)) {
            destination  = "/WEB-INF/pages/accueil.jsp";
        }


        if (DECONNEXION.equals(cleNavigation)) {
            String cle = (String)req.getSession().getAttribute("cleAuthentification");
            try {
                facade.deconnexion(cle);
                req.getSession().invalidate();


            } catch (CleInexistanteException e) {
                String erreur = "Erreur inattendue liée à la clé d'authentification !";
                req.setAttribute("erreur",erreur);
            }

            destination  = "/WEB-INF/pages/accueil.jsp";
        }


        this.getServletContext().getRequestDispatcher(destination).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        String[] parties = uri.split("/");
        String cleNavigation = parties[parties.length-1];
        String destination = "/WEB-INF/pages/accueil.jsp";

        FacadeGestionUtilisateurs facade = (FacadeGestionUtilisateurs)
                this.getServletContext().getAttribute("facade");

        if (CONNEXION.equals(cleNavigation)) {
            String pseudo = req.getParameter("pseudo");
            String password = req.getParameter("password");
            try {
                String cle = facade.connexion(pseudo,password);
                Utilisateur utilisateur = facade.getUtilisateurParCle(cle);
                req.getSession().setAttribute("user",utilisateur);
                req.getSession().setAttribute("cleAuthentification",cle);
                req.setAttribute("utilisateurs",facade.getTousLesUtilisateurs(cle));
                destination = "/WEB-INF/pages/menu.jsp";


            } catch (IdentifiantsNonValidesException e) {
                destination = "/WEB-INF/pages/accueil.jsp";
                String erreur = "Identifiants non valides";
                req.setAttribute("erreur",erreur);
            } catch (UtilisateurDejaConnecteException e) {
                String erreur = "L'utilisateur "+pseudo + " est déjà connecté !";
                req.setAttribute("erreur",erreur);
                destination = "/WEB-INF/pages/accueil.jsp";
            } catch (CleInexistanteException e) {
                String erreur = "Erreur inattendue liée à la clé d'authentification !";
                req.setAttribute("erreur",erreur);
                destination = "/WEB-INF/pages/accueil.jsp";
            }



        }

        this.getServletContext().getRequestDispatcher(destination).forward(req,resp);
    }
}
