/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Arbitre;
import entities.Joueur;
import entities.MatchFoot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 6170232
 */
@Local
public interface SessionArbitreLocal {

    Arbitre authentification(String login, String mdp);

    List listMatchsResultat(Arbitre arbitre);

    MatchFoot rechercheMatch(long idMatch);

    void setScoreMatch(long idMatch, int scoreEquipeReceveuse, int scoreEquipeInvitee);

    Joueur rechercheJoueur(long idJoueur);

    void setFauteJoueurMatch(long idJoueur, long idMatch, boolean cartonJaune, boolean cartonRouge);
    
}
