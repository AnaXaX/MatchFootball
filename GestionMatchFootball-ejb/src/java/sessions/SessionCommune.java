/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Equipe;
import facades.EquipeFacadeLocal;
import facades.JoueurFacadeLocal;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class SessionCommune implements SessionCommuneLocal {

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private JoueurFacadeLocal joueurFacade;


    

    @Override
    public Equipe rechercheEquipe(long id) {
        return equipeFacade.rechercheEquipe(id);
    }  

    @Override
    public Collection listEquipes() {
        return equipeFacade.listEquipes();
    }

    @Override
    public Collection listJoueurs() {
        return joueurFacade.listJoueurs();
    }    

    @Override
    public List listJoueursEquipe(Equipe equipe) {
        return joueurFacade.listJoueursEquipe(equipe);
    }

    
}
