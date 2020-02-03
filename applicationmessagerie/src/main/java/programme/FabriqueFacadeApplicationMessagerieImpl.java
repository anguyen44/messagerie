package programme;

import modele.FabriqueFacadeApplicationMessagerie;
import modele.FacadeApplicationMessagerie;
import modele.FacadeApplicationMessagerieImpl;

public class FabriqueFacadeApplicationMessagerieImpl implements FabriqueFacadeApplicationMessagerie {
    @Override
    public FacadeApplicationMessagerie creer() {
        return new FacadeApplicationMessagerieImpl();
    }
}
