package sessions;

import entities.Equipe;
import facades.EquipeFacadeLocal;
import facades.JoueurFacadeLocal;
import facades.MatchFacadeLocal;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class SessionCommune implements SessionCommuneLocal {

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private JoueurFacadeLocal joueurFacade;
    
    

    @Override
    public Equipe rechercheEquipe(long id) {
        return equipeFacade.rechercheEquipe(id);
    }  

    @Override
    public Collection listEquipes() {
        return equipeFacade.listEquipes();
    }

    @Override
    public Collection listJoueurs() {
        return joueurFacade.listJoueurs();
    }    

    @Override
    public List listJoueursEquipe(Equipe equipe) {
        return joueurFacade.listJoueursEquipe(equipe);
    }

    @Override
    public List classement() {
        return equipeFacade.classement();
    }

    @Override
    public java.util.List<entities.MatchFoot> listMatchs() {
        return matchFacade.listMatchs();
    }
    
    
    
    
    
}
