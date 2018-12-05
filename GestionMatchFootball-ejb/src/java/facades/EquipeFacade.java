/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Entraineur;
import entities.Equipe;
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
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }

    @Override
    public void creerEquipe(String nom, Entraineur entraineur) {
        Equipe e = new Equipe();
        e.setNom(nom);
        e.setPoints(0);
        entraineur.addEquipeHistorique(e);
        em.persist(e);
        em.merge(entraineur);
    }    

    @Override
    public Equipe rechercheEquipe(String nom) {
        Equipe e = null;
        Query requete = getEntityManager().createQuery("select e from Equipe as e where e.nom=:nom");
        requete.setParameter("nom", nom);
        List<Equipe> list =requete.getResultList();
        for(Equipe ee : list){
            e = ee;
        }
        return e;
    }

    @Override
    public List listEquipes() {
       Query requete = getEntityManager().createQuery("select e from Equipe as e"); 
       return requete.getResultList();
    }

    @Override
    public Equipe rechercheEquipe(long id) {
        Equipe e = null;
        Query requete = getEntityManager().createQuery("select e from Equipe as e where e.id=:id");
        requete.setParameter("id", id);
        List<Equipe> list =requete.getResultList();
        for(Equipe ee : list){
            e = ee;
        }
        return e;
    }

    @Override
    public Equipe rechercheEquipeParEntraineur(Entraineur entraineur) {
        Equipe e = null;
        Query requete = getEntityManager().createQuery("select e from Equipe as e where e.entraineur=:entraineur");
        requete.setParameter("entraineur", entraineur);
        List<Equipe> list =requete.getResultList();
        if (!requete.getResultList().isEmpty()){
            return (Equipe) requete.getSingleResult();
        } else {
            return null;
        }
    }
    
    
    
}
