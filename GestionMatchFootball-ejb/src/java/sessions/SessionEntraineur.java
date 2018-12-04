/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entraineur;
import facades.EntraineurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 6170232
 */
@Stateless
public class SessionEntraineur implements SessionEntraineurLocal {

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @Override
    public Entraineur authentification(String login, String mdp) {
        return entraineurFacade.authentification(login, mdp);
    }
    
    


}
