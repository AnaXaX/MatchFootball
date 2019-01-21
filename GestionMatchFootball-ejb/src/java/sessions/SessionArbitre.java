package sessions;

import entities.Arbitre;
import entities.Joueur;
import entities.MatchFoot;
import facades.ArbitreFacadeLocal;
import facades.FauteFacadeLocal;
import facades.JoueurFacadeLocal;
import facades.MatchFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6170232
 */
@Stateless
public class SessionArbitre implements SessionArbitreLocal {

    @EJB
    private FauteFacadeLocal fauteFacade;

    @EJB
    private JoueurFacadeLocal joueurFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @Override
    public Arbitre authentification(String login, String mdp) {
        return arbitreFacade.authentification(login, mdp);
    }

    @Override
    public List listMatchsResultat(Arbitre arbitre) {
        return matchFacade.listMatchsArbitre(arbitre);
    }

    @Override
    public MatchFoot rechercheMatch(long idMatch) {
        return matchFacade.rechercheMatchId(idMatch);
    }

    @Override
    public void setScoreMatch(long idMatch, int scoreEquipeReceveuse, int scoreEquipeInvitee) {
        matchFacade.setScoreMatchArbitre(matchFacade.rechercheMatchId(idMatch),scoreEquipeReceveuse,scoreEquipeInvitee);
    }

    @Override
    public Joueur rechercheJoueur(long idJoueur) {
        return joueurFacade.rechercheJoueur(idJoueur);
    }

    @Override
    public void setFauteJoueurMatch(long idJoueur, long idMatch, boolean cartonJaune, boolean cartonRouge) {
        fauteFacade.creerFaute(rechercheMatch(idMatch),rechercheJoueur(idJoueur),cartonJaune,cartonRouge);
    }
    
    
    

    
}
