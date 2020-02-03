package vue.terminal;

import controller.Controller;
import vue.Connexion;

import java.util.Scanner;

public class ConnexionTerminalImpl implements Connexion {

    Controller controller;

    ConnexionTerminalImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);

        String login = null;
        String password = null;
        do{
            System.out.println("Application messagerie du futur");
            System.out.println("Saisir votre login");
            login = scanner.nextLine();
            System.out.println("Saisir votre mot de passe");
            password = scanner.nextLine();


        }while(login.length()<3||password.length()<3);

        controller.connexion(login,password);

    }

    @Override
    public void erreur(String s) {

    }
}
