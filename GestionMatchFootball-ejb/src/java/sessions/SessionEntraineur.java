/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entraineur;
import entities.Equipe;
import facades.EntraineurFacadeLocal;
import facades.EquipeFacadeLocal;
import facades.JoueurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6170232
 */
@Stateless
public class SessionEntraineur implements SessionEntraineurLocal {

    @EJB
    private JoueurFacadeLocal joueurFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;
    

    @Override
    public Entraineur authentification(String login, String mdp) {
        return entraineurFacade.authentification(login, mdp);
    }

    @Override
    public Equipe rechercheEquipeParEntraineur(Entraineur entraineur) {
        return equipeFacade.rechercheEquipeParEntraineur(entraineur) ;
    }

    @Override
    public List rechercheJoueurs() {
        return joueurFacade.listJoueurSansEquipe();
    }



    @Override
    public void affecterJoueur(long id, Equipe e) {
        joueurFacade.affecterEquipe(joueurFacade.rechercheJoueur(id), e);
    }  

}
