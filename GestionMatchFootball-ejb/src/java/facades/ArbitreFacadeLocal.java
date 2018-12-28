/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface ArbitreFacadeLocal {

    void create(Arbitre arbitre);

    void edit(Arbitre arbitre);

    void remove(Arbitre arbitre);

    Arbitre find(Object id);

    List<Arbitre> findAll();

    List<Arbitre> findRange(int[] range);

    int count();

    void creerArbitre(String nom, String prenom, String login, String mdp);

    Arbitre authentification(String login, String mdp);

    List listArbitres();

    Arbitre rechercheArbitre(long id);
    
}
