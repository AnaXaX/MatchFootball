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
    
}
