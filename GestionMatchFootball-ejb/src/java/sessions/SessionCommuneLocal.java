/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Equipe;
import entities.MatchFoot;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface SessionCommuneLocal {

    Equipe rechercheEquipe(long id);

    Collection listEquipes();

    Collection listJoueurs();

    List listJoueursEquipe(Equipe equipe);

    List classement();

    java.util.List<entities.MatchFoot> listMatchs();

    List rechercheMatch(Timestamp date);

    List rechercheMatch(Timestamp dateD, Timestamp dateF);

    MatchFoot rechercheMatchId(long id);
}
