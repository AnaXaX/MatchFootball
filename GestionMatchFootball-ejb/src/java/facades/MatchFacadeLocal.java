/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import entities.Equipe;
import entities.Match;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface MatchFacadeLocal {

    void create(Match match);

    void edit(Match match);

    void remove(Match match);

    Match find(Object id);

    List<Match> findAll();

    List<Match> findRange(int[] range);

    int count();

    void creerMatch(Date date, Equipe equipe1, Equipe equipe2, Arbitre arbitre);
    
}
