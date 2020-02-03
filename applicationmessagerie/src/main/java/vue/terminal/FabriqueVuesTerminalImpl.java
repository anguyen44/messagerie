package vue.terminal;

import controller.Controller;
import vue.*;

public class FabriqueVuesTerminalImpl  implements FabriqueVues {
    Controller controller;

    public FabriqueVuesTerminalImpl(){

    }

    public FabriqueVuesTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void setController(Controller controller){
        this.controller = controller;
    }

    @Override
    public Inscription creerInscription() {
        return new InscriptionTerminalImpl(controller);
    }

    @Override
    public Acceuil creerAcceuil(){
        return new AcceuilTerminalImpl(controller);
     }

    @Override
    public Connexion creerConnexion(){ return  new ConnexionTerminalImpl(controller);}

    @Override
    public Menu creerMenu() {
        return new MenuTerminalImpl(controller);
    }

    @Override
    public EnvoieMessage creerEnvoiMessage() {
        return new EnvoieMessageTerminalImpl(controller);
    }

}
