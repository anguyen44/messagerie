package vue.terminal;

import controller.Controller;
import vue.Acceuil;
import vue.Inscription;

import java.util.Scanner;

public class InscriptionTerminalImpl implements Inscription {

    Controller controller;

    InscriptionTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);

        String login = null;
        String password = null;
        do{
            System.out.println("Application messagerie du futur");
            System.out.println("Saisir un login");
            login = scanner.nextLine();
            System.out.println("Saisir un mot de passe");
            password = scanner.nextLine();


        }while(login.length()<3||password.length()<3);

        controller.inscription(login,password);

    }

    @Override
    public void erreur(String s) {

    }
}
