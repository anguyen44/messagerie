package controller;

import modele.*;
import vue.*;

import java.util.Collection;

public class Controller {

    FabriqueVues fabriqueVues;

    FacadeApplicationMessagerie facadeApplicationMessagerie;

    Inscription vueInscription;

    Acceuil vueAcceuil;

    Menu vueMenu;

    Connexion vueConnexion;

    EnvoieMessage vueEnvoieMessage;

    private long identifiant;

    public Controller(FabriqueFacadeApplicationMessagerie fabriqueFacadeApplicationMessagerie,
                      FabriqueVues fabriqueVues){
        this.fabriqueVues = fabriqueVues;

        this.facadeApplicationMessagerie = fabriqueFacadeApplicationMessagerie.creer();

        fabriqueVues.setController(this);

    }



    public void run(){

        Acceuil acceuil =this.fabriqueVues.creerAcceuil();
        acceuil.afficher();

    }

    public void valivaliderChoixAcceuil(int choix){
        switch (choix){
            case 1: {
                vueInscription = fabriqueVues.creerInscription();
                vueInscription.afficher();
                break;
            }
            case 2: {
                vueConnexion = fabriqueVues.creerConnexion();
                vueAcceuil = fabriqueVues.creerAcceuil();
                vueConnexion.afficher();
                break;
            }

        }
    }

    public void inscription(String login, String password){
        try{
            facadeApplicationMessagerie.inscription(login,password);
            this.fabriqueVues.creerAcceuil().afficher();
        }catch (LoginDejaPrisException e){
            vueInscription.erreur("Le login "+login + " est déjà connecté");
        }catch (InformationsNonConformesException e){
            vueInscription.erreur("Les informations saisies ne sont pas valide!!");
        }

        finally {
            vueInscription.afficher();
        }
    }

    public void connexion(String login, String password){
        try{
            this.identifiant = facadeApplicationMessagerie.connexion(login,password);
            this.vueMenu = this.fabriqueVues.creerMenu();
            this.vueMenu.afficher();
        }catch (LoginDejaPrisException e){
            this.vueConnexion.erreur("Le login "+login + " est déjà pris");
            this.vueAcceuil.afficher();
        }catch (InformationsNonConformesException e){
            this.vueConnexion.erreur("Les informations saisies ne sont pas valide!!");
            this.vueAcceuil.afficher();
        }catch (UtilisateurDejaConnecteException e){
            this.vueConnexion.erreur("L'utilisateur "+login+" est déjà connecté");
            this.vueAcceuil.afficher();
        }


    }

    public void deconnexion(){
        try{
            this.facadeApplicationMessagerie.deconnexion(this.identifiant);
            this.vueAcceuil.afficher();
        }catch (InformationsNonConformesException e){

        }
    }

    public void envoyerMessage(long id, String message){
        try{
            this.facadeApplicationMessagerie.envoyerUnMessage(this.identifiant,id,message);
            this.vueEnvoieMessage.confirmation();
        }catch (UtilisateurNonConnecteException e){
            this.vueEnvoieMessage.erreur("L'utilisateur n'est pas connecté");
            this.deconnexion();
        }catch (UtilisateurInexistantException e){
            this.vueEnvoieMessage.erreur("La destinataire spécifié n'est exitte pas ("+id+")");
        }

    }

    public void validerChoixMenu(int choix){
        switch (choix){
            case 1: {
                this.vueEnvoieMessage = fabriqueVues.creerEnvoiMessage();
                this.vueEnvoieMessage.afficher();
                this.vueMenu.afficher();
                break;
            }
            case 2: {
                this.deconnexion();
                this.vueAcceuil.afficher();
                break;
            }
        }
    }

    public Collection<UtilisateurDTO> getUtilisateur() throws UtilisateurNonConnecteException,UtilisateurInexistantException{
        return this.facadeApplicationMessagerie.getListeDesInscrits(this.identifiant);
    }


}
