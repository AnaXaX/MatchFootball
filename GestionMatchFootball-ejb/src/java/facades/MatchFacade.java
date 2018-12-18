/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import entities.Equipe;
import entities.MatchFoot;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class MatchFacade extends AbstractFacade<MatchFoot> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(MatchFoot.class);
    }

    @Override
    public void creerMatch(Date date, Equipe equipe1, Equipe equipe2, Arbitre arbitre) {
        MatchFoot m = new MatchFoot();
        m.setDate(date);
        m.setEquipeReceveuse(equipe1);
        m.setEquipeInvitee(equipe2);
        m.setArbitre(arbitre);
        em.persist(m);
    }
    
}
