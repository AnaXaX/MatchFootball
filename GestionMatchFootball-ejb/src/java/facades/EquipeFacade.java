/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Entraineur;
import entities.Equipe;
import entities.MatchFoot;
import java.sql.Timestamp;
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
        supprimerEntraineurEquipe(entraineur);//ancienne equipe de l'entraineur
        Equipe e = new Equipe(); 
        e.setNom(nom);  
        e.setPoints(0);
        if(!entraineur.getHistorique().contains(e)) /*Éviter erreur élément double, possibilité de faire clonage mais on perd la relation instance*/
            entraineur.addEquipeHistorique(e); /*Relation 1--1*/
        else{
            e.setEntraineur(entraineur); /*Relation 1--1*/
        }
       // entraineur.setEquipe(e); /*Relation 1--1*/
        em.persist(e);
        em.merge(entraineur);
    }
    
    @Override
    public void modifierEquipe(Equipe equipe, String newNom, Entraineur newEntraineur) {
        equipe.setNom(newNom);
        supprimerEntraineurEquipe(newEntraineur);
        if(!newEntraineur.getHistorique().contains(equipe))
            newEntraineur.addEquipeHistorique(equipe);
        else{
            equipe.setEntraineur(newEntraineur); 
        }
       // newEntraineur.setEquipe(equipe);
        em.merge(equipe);
        em.merge(newEntraineur);
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
    public Equipe rechercheEquipeParEntraineur(Entraineur entraineur) {
        Query requete = getEntityManager().createQuery("select e from Equipe as e where e.entraineur=:entraineur");
        requete.setParameter("entraineur", entraineur);
        if (!requete.getResultList().isEmpty()){
            return (Equipe) requete.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public List listEquipes() {
       Query requete = getEntityManager().createQuery("select e from Equipe as e"); 
       return requete.getResultList();
    }

    @Override
    public List listEquipesTransfert(Equipe equipeActuelle) {
        Query requete = getEntityManager().createQuery("select e from Equipe as e where e!=:equipe");
        requete.setParameter("equipe", equipeActuelle);
        return requete.getResultList();
    }


    @Override
    public boolean disponible(long id, Timestamp date) {
        boolean disponible = true;
        Equipe e = rechercheEquipe(id);
        long duration = ((120 * 60)/* + 00*/) * 1000;// On considère qu'un Match dure 2 heures
        Timestamp dateMin = ((Timestamp) date.clone());
        Timestamp dateMax = ((Timestamp) date.clone());
        dateMin.setTime(date.getTime() - duration);
        dateMax.setTime(date.getTime() + duration);
        for (MatchFoot match : e.getHistoriqueMatchs()) {
            if (match.getDate().before(dateMax) && match.getDate().after(dateMin)) {
                disponible = false;
                break; 
            }
        }
        return disponible;    
    }

    @Override
    public void supprimerEntraineurEquipe(Entraineur entraineur) {//Enlever l'entraineur d'une équipe en cherchant l'équipe par entraineur qui va quitter l'équipe
        Equipe e = rechercheEquipeParEntraineur(entraineur);
        if(e!=null){
            e.setEntraineur(null);
            em.merge(e);   
        }
    }

    @Override
    public List classement() {             
        Query requete = getEntityManager().createQuery("select e from Equipe as e order by e.points DESC");
        return requete.getResultList();
    }       

    @Override
    public void supprimerEquipe(Equipe equipe) {
       /* 
        if (!em.contains(equipe)) {
            equipe = em.merge(equipe);
        }*/
        em.remove(equipe);
    }
    
    
}
