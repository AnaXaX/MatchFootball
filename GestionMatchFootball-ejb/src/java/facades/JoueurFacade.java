/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Equipe;
import entities.Joueur;
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
public class JoueurFacade extends AbstractFacade<Joueur> implements JoueurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueurFacade() {
        super(Joueur.class);
    }

    @Override
    public void creerJoueur(String nom, String prenom) {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);
        em.persist(j);
    }

    @Override
    public void affecterEquipe(Joueur j, Equipe e) {
        j.getHistoriqueEquipes().add(e);
        //  Bidirectionnel il suffit de l'ajouter dans la liste d'effectif  pour que l'équipe du joueur change : j.setEquipe(e);
        e.addJoueurEffectif(j);
        em.merge(j);
        em.merge(e);
    }
   
    
    @Override
    public void transferJoueur(Joueur joueur, Equipe ancienneEquipe, Equipe nouvelleEquipe) {
        ancienneEquipe.removeJoueurEffectif(joueur);
        nouvelleEquipe.addJoueurEffectif(joueur);
        if(!joueur.getHistoriqueEquipes().contains(nouvelleEquipe))
            joueur.getHistoriqueEquipes().add(nouvelleEquipe);
        em.merge(joueur);
        em.merge(ancienneEquipe);
        em.merge(nouvelleEquipe);
    }


    @Override
    public List listJoueurs() {
        Query requete = getEntityManager().createQuery("select j from Joueur as j");
        return requete.getResultList();
    }

    @Override
    public List listJoueursEquipe(Equipe equipe) {
        Query requete = getEntityManager().createQuery("select j from Joueur as j where j.equipe=:equipe");
        requete.setParameter("equipe", equipe);
        return requete.getResultList();
    }

    @Override
    public Joueur rechercheJoueur(long id) {
        Query requete = getEntityManager().createQuery("select j from Joueur as j where j.id=:id");
        requete.setParameter("id", id);
        if (!requete.getResultList().isEmpty()) {
            return (Joueur) requete.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public List listJoueurSansEquipe() {
        Query requete = getEntityManager().createQuery("select j from Joueur as j where j.equipe is null");
        return requete.getResultList();    
    }


 

    
}
