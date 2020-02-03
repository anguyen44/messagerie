package programme;

import controller.Controller;
import modele.FabriqueFacadeApplicationMessagerie;
import vue.FabriqueVues;
import vue.terminal.FabriqueVuesTerminalImpl;

public class Main {
    public static void main(String[] args){

        FabriqueVues fabriqueVues = new FabriqueVuesTerminalImpl();
        FabriqueFacadeApplicationMessagerie fabriqueFacadeApplicationMessagerie = new FabriqueFacadeApplicationMessagerieImpl();

        try{
            Controller controller = new Controller(fabriqueFacadeApplicationMessagerie,fabriqueVues);
            controller.run();
        }catch (NullPointerException e){
            e.printStackTrace();
        }




    }
}
