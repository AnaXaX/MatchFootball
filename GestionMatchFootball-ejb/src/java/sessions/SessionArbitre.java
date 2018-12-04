package sessions;

import entities.Arbitre;
import facades.ArbitreFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6170232
 */
@Stateless
public class SessionArbitre implements SessionArbitreLocal {

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @Override
    public Arbitre authentification(String login, String mdp) {
        return arbitreFacade.authentification(login, mdp);
    }

    
}
