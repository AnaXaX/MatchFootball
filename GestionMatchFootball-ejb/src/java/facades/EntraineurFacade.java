/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Entraineur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class EntraineurFacade extends AbstractFacade<Entraineur> implements EntraineurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntraineurFacade() {
        super(Entraineur.class);
    }

    @Override
    public void creerEntraineur(String nom, String prenom, String login, String mdp) {
        Entraineur e = new Entraineur();
        e.setNom(nom);
        e.setPrenom(prenom);
        e.setLogin(login);
        e.setMdp(mdp);
        em.persist(e);
    }

    @Override
    public Entraineur rechercheEntraineur(long id) {
        Entraineur e = null;
        Query requete = getEntityManager().createQuery("select e from Entraineur as e where e.id=:id");
        requete.setParameter("id", id);
        List<Entraineur> list =requete.getResultList();
        for(Entraineur ee : list){
            e = ee;
        }
        return e;
    }

    @Override
    public List listEntraineurs() {
        Query requete = getEntityManager().createQuery("select e from Entraineur as e"); 
        return requete.getResultList();   
    
    }
}
