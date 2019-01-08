package sessions;

import entities.Arbitre;
import facades.ArbitreFacadeLocal;
import entities.Entraineur;
import facades.EntraineurFacadeLocal;
import entities.Equipe;
import facades.EquipeFacadeLocal;
import entities.Helpers;
import entities.Joueur;
import entities.MatchFoot;
import facades.JoueurFacadeLocal;
import facades.MatchFacadeLocal;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
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
    private MatchFacadeLocal matchFacade;

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
        if (mdp != null) {
            try {
                if (Helpers.sha1(mdp).equals("5BAA61E4C9B93F3F0682250B6CF8331B7EE68FD8")) //Mot de Passe : password
                {
                    acces = true;
                }
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
    public void creerMatch(Timestamp date, long equipeReceveuse, long equipeInvitee, long arbitre) {
        if(arbitreFacade.disponible(arbitre,date) && equipeFacade.disponible(equipeInvitee,date) && equipeFacade.disponible(equipeReceveuse,date)  )
            matchFacade.creerMatch(date, equipeFacade.rechercheEquipe(equipeReceveuse), equipeFacade.rechercheEquipe(equipeReceveuse), arbitreFacade.rechercheArbitre(arbitre));
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
    public List listJoueurs() {
        return joueurFacade.listJoueurs();
    }

    @Override
    public Entraineur rechercheEntraineur(long id) {
        return entraineurFacade.rechercheEntraineur(id);
    }

    @Override
    public Equipe rechercheEquipe(long id) {
        return equipeFacade.rechercheEquipe(id);
    }

    @Override
    public List listArbitres() {
        return arbitreFacade.listArbitres();
    }

    @Override
    public void modifierEquipe(long idEquipe, String nom, long idEntraineur) {
        equipeFacade.modifierEquipe(equipeFacade.rechercheEquipe(idEquipe), nom, entraineurFacade.rechercheEntraineur(idEntraineur));
    }

    @Override
    public void supprimerEquipe(long idEquipe) {
        /*Pour ne pas violer la contrainte de joueur dans équipe il faut supprimer tous les contrats des joueurs qui est le lien avec l'équipe*/
        Equipe e = equipeFacade.rechercheEquipe(idEquipe);
        
        System.out.println(e);
        
        /* DELETE on table 'EQUIPE' caused a violation of foreign key constraint 'JOUEUR_EQUIPE_ID'*/
        /*Donc je dois supprimer l'équipe de l'historique*/
        //joueurFacade.supprimerHistoriqueEquipe(e);
        
        /*Rompre la relation ce qui mettera a null l'attribut équipe chez tous les joueurs de cette équipe*/
        if(e.getEffectif()!=null && !e.getEffectif().isEmpty()){
            e.viderEffectif();
        }      
        
        /*Annuler tous les matchs de l'équipe non joués*/
        for(MatchFoot m : e.getHistoriqueMatchs()){
            matchFacade.annulerMatch(m);
        } 
        
        equipeFacade.supprimerEquipe(e);/*merge entraineur*/
    }
    
    


}
