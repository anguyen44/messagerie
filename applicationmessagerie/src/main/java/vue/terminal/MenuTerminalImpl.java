package vue.terminal;

import controller.Controller;
import vue.Inscription;
import vue.Menu;

import java.util.Scanner;

public class MenuTerminalImpl implements Menu {

    Controller controller;

    MenuTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);

        int choix = -1;
        do{
            System.out.println("Menu principal");
            System.out.println("1 - envoyer un message");
            System.out.println("2 - Se déconnecter");
            System.out.println("Choix?");
            choix = scanner.nextInt();


        }while(choix<1||choix>2);

        controller.validerChoixMenu(choix);

    }

    @Override
    public void erreur(String s) {

    }
}
