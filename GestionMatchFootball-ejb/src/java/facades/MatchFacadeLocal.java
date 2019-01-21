/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import entities.Equipe;
import entities.MatchFoot;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface MatchFacadeLocal {

    void create(MatchFoot match);

    void edit(MatchFoot match);

    void remove(MatchFoot match);

    MatchFoot find(Object id);

    List<MatchFoot> findAll();

    List<MatchFoot> findRange(int[] range);

    int count();

    void creerMatch(Timestamp date, Equipe equipeReceveuse, Equipe equipeInvitee, Arbitre arbitre);

    void annulerMatch(MatchFoot match);

    List afficherMatchsTactique(Equipe equipe);

    MatchFoot rechercheMatchId(long id);

    void affecterMatch(List joueurs, MatchFoot match, Equipe e);

    java.util.List<entities.MatchFoot> listMatchs();

    List rechercheMatch(Timestamp date);

    List rechercheMatch(Timestamp dateD, Timestamp dateF);


    List listMatchsArbitre(Arbitre arbitre);

    void setScoreMatchArbitre(MatchFoot match, int scoreEquipeReceveuse, int scoreEquipeInvitee);

    void modifierMatch(Timestamp date, MatchFoot match);


}
