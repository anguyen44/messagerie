package vue;

import controller.Controller;

public interface FabriqueVues {

    void setController(Controller controller);

    Inscription creerInscription();

    Acceuil creerAcceuil();

    Connexion creerConnexion();

    Menu creerMenu();

    EnvoieMessage creerEnvoiMessage();
}
