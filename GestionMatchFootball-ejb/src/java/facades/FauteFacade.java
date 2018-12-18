/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Faute;
import entities.Joueur;
import entities.MatchFoot;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 6170232
 */
@Stateless
public class FauteFacade extends AbstractFacade<Faute> implements FauteFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FauteFacade() {
        super(Faute.class);
    }

    @Override
    public void creerFaute(MatchFoot match, Joueur joueur, boolean cartonJaune, boolean cartonRouge) {
        Faute f = new Faute();
        f.setJoueur(joueur);
        f.setMatch(match);
        f.setCartonJaune(cartonJaune);
        f.setCartonRouge(cartonRouge);
        joueur.addFaute(f);
        match.addFaute(f);
        em.persist(f);
        /*Synchro*/
        em.merge(joueur);
        em.merge(match);
    }
    
    
    
}
