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
        if(!j.getHistoriqueEquipes().contains(e))
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
            joueur.addHistoriqueEquipes(nouvelleEquipe);
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

    @Override
    public void supprimerContratJoueur(Joueur j) {
        Equipe e = j.getEquipe();
        e.removeJoueurEffectif(j);
        em.merge(j);/*Apparemment après mes tests les changements se font dans la table sans avoir besoin du merge car on travail directement sur la list OneToMany dans la ligne précèdente mais je le laisse comme meme*/
        em.merge(e);
    }

    @Override
    public void supprimerHistoriqueEquipe(Equipe equipe) {
       /* Query requete = em.createQuery("DELETE FROM JOUEUR_EQUIPE je WHERE je.historiqueEquipes_id =:equipe ");
        requete.setParameter("equipe", equipe.getId());
        int rowsDeleted = requete.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        em.getTransaction().commit();
        */

        List<Joueur> tousJoueurs = listJoueurs();
        for(Joueur j : tousJoueurs){
            if(j.getHistoriqueEquipes().contains(equipe)){
                System.out.println("je joue au barça, i am "+j);
                j.removeHistoriqueEquipes(equipe);               
                em.merge(j);
            }              
        }
        em.merge(equipe);
        em.clear();
    }
    
    
    
}
