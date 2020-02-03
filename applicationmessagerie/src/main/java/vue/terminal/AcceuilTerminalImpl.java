package vue.terminal;

import controller.Controller;
import vue.Acceuil;

import java.util.Scanner;

public class AcceuilTerminalImpl implements Acceuil {

    Controller controller;

    AcceuilTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);

        int choix = -1;
        do{
            System.out.println("Application messagerie du futur");
            System.out.println("1 - S'inscrire");
            System.out.println("2 - Se connecter");
            System.out.println("Choix?");

            choix = scanner.nextInt();

        }while(choix<1|choix>2);

        controller.valivaliderChoixAcceuil(choix);




    }

    @Override
    public void erreur(String s) {

    }
}
