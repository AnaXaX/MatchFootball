/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class ArbitreFacade extends AbstractFacade<Arbitre> implements ArbitreFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArbitreFacade() {
        super(Arbitre.class);
    }

    @Override
    public void creerArbitre(String nom, String prenom, String login, String mdp) {
        Arbitre a = new Arbitre();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setLogin(login);
        a.setMdp(mdp);
        em.persist(a);
    }
   
}
