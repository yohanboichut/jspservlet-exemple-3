package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import modele.DonneesNonValidesException;
import modele.FacadeGestionUtilisateurs;
import modele.FacadeGestionUtilisateursImpl;
import modele.PseudoDejaExistantException;


@WebListener
public class InitialisationFacade implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        FacadeGestionUtilisateurs facadeGestionUtilisateurs = new FacadeGestionUtilisateursImpl();
        servletContextEvent.getServletContext().setAttribute("facade",facadeGestionUtilisateurs);

        try {
            facadeGestionUtilisateurs.inscription("Yoh4n","video");
            facadeGestionUtilisateurs.inscription("Fred","pasvideo");
        } catch (PseudoDejaExistantException e) {
            e.printStackTrace();
        } catch (DonneesNonValidesException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
