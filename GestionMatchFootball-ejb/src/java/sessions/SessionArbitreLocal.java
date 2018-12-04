/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Arbitre;
import javax.ejb.Local;

/**
 *
 * @author 6170232
 */
@Local
public interface SessionArbitreLocal {

    Arbitre authentification(String login, String mdp);
    
}
