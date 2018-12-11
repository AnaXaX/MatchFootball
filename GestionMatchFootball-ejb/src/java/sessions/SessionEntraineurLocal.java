/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entraineur;
import entities.Equipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 6170232
 */
@Local
public interface SessionEntraineurLocal {

    Entraineur authentification(String login, String mdp);

    Equipe rechercheEquipeParEntraineur(Entraineur entraineur);

    List rechercheJoueurs();

    void affecterJoueur(long id, Equipe e);
    
}
