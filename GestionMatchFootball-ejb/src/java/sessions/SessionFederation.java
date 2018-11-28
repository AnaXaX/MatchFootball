/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import facades.ArbitreFacadeLocal;
import entities.Entraineur;
import facades.EntraineurFacadeLocal;
import entities.Equipe;
import facades.EquipeFacadeLocal;
import entities.Helpers;
import entities.Joueur;
import facades.JoueurFacadeLocal;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anas
 */
@Stateless
public class SessionFederation implements SessionFederationLocal {

    @EJB
    private JoueurFacadeLocal joueurFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade; 

    @Override
    public Boolean authentification(String mdp) {
        boolean acces = false;
        if(mdp!=null){
            try {
                if(Helpers.sha1(mdp).equalsIgnoreCase("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8"))
                    acces=true;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SessionFederation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return acces;
    }

    @Override
    public void creerEntraineur(String nom, String prenom, String login, String mdp) {
        entraineurFacade.creerEntraineur(nom, prenom, login, mdp);
    }

    @Override
    public void creerEquipe(String nom, Entraineur entraineur) {
        equipeFacade.creerEquipe(nom, entraineur);

    }

    @Override
    public void creerArbitre(String nom, String prenom, String login, String mdp) {
        arbitreFacade.creerArbitre(nom, prenom, login, mdp);
    }

    @Override
    public void creerJoueur(String nom, String prenom) {
        joueurFacade.creerJoueur(nom, prenom);
    }    

    @Override
    public Entraineur rechercheEntraineur(long id) {
        return entraineurFacade.rechercheEntraineur(id);
    }

    @Override
    public List listEntraineur() {
        return entraineurFacade.listEntraineurs();
    }

    @Override
    public List listEquipes() {
        return equipeFacade.listEquipes();
    }

    @Override
    public Equipe rechercheEquipe(long id) {
        return equipeFacade.rechercheEquipe(id);
    }

    @Override
    public List listJoueurs() {
        return joueurFacade.listJoueurs();
    }   
}
