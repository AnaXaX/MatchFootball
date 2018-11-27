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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class MatchFacade extends AbstractFacade<Match> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Match.class);
    }

    @Override
    public void creerMatch(Date date, Equipe equipe1, Equipe equipe2, Arbitre arbitre) {
        Match m = new Match();
        m.setDate(date);
        m.setEquipeUne(equipe1);
        m.setEquipeDeux(equipe2);
        m.setArbitre(arbitre);
        em.persist(m);
    }
    
}
