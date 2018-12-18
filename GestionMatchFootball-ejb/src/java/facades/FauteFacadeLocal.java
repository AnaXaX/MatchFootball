/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Faute;
import entities.Joueur;
import entities.MatchFoot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 6170232
 */
@Local
public interface FauteFacadeLocal {

    void create(Faute faute);

    void edit(Faute faute);

    void remove(Faute faute);

    Faute find(Object id);

    List<Faute> findAll();

    List<Faute> findRange(int[] range);

    int count();

    void creerFaute(MatchFoot match, Joueur joueur, boolean cartonJaune, boolean cartonRouge);
    
}
