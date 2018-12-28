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
import entities.Helpers;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

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
        try {
            a.setMdp(Helpers.sha1(mdp));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ArbitreFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(a);
    }

    @Override
    public Arbitre authentification(String login, String mdp) {
        Arbitre a = null;
        Query requete = getEntityManager().createQuery("select a from Arbitre as a where a.login=:login and a.mdp=:mdp");
        requete.setParameter("login", login);
        try {
            requete.setParameter("mdp", Helpers.sha1(mdp));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ArbitreFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!requete.getResultList().isEmpty())
            a = (Arbitre) requete.getSingleResult();
        return a;
        
        /*  List<Arbitre> list =requete.getResultList();
        for(Arbitre aa : list){
            a = aa;
        }
        */
    }

    @Override
    public List listArbitres() {
        Query requete = getEntityManager().createQuery("select a from Arbitre as a");
        return requete.getResultList();
    }

    @Override
    public Arbitre rechercheArbitre(long id) {
      Arbitre a = null;
        Query requete = getEntityManager().createQuery("select a from Arbitre as a where a.id=:id");
        requete.setParameter("id", id);
        List<Arbitre> list =requete.getResultList();
        for(Arbitre aa : list){
            a = aa;
        }
        return a;    }

}
