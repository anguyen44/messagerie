package vue.terminal;

import controller.Controller;
import modele.UtilisateurDTO;
import modele.UtilisateurInexistantException;
import modele.UtilisateurNonConnecteException;
import vue.Acceuil;
import vue.EnvoieMessage;

import java.util.Collection;
import java.util.Scanner;

public class EnvoieMessageTerminalImpl implements EnvoieMessage {

    Controller controller;

    EnvoieMessageTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);
        Collection<UtilisateurDTO> utilisateurs = null;
        try {
            utilisateurs  = controller.getUtilisateur();
            System.out.println("Voici la liste des utilisateurs: ");

            for(UtilisateurDTO u: utilisateurs){
                System.out.println(u.getId()+" "+u.getLogin());
            }

            System.out.println("Saisir l'identifiant di destinataire");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Saisir votre messages");

            String message = scanner.nextLine();

            controller.envoyerMessage(id,message);
        }catch (UtilisateurNonConnecteException e){
            System.err.println("Bizarre...");
            controller.deconnexion();
        }catch (UtilisateurInexistantException e){
            System.err.println("Là aussi...Bizarre...");
            controller.deconnexion();
        }

    }

    @Override
    public void erreur(String s) {

    }

    @Override
    public void confirmation() {
    System.out.println("Les messages sont bien envoyés");
    }
}
