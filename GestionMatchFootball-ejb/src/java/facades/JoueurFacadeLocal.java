/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Equipe;
import entities.Joueur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface JoueurFacadeLocal {

    void create(Joueur joueur);

    void edit(Joueur joueur);

    void remove(Joueur joueur);

    Joueur find(Object id);

    List<Joueur> findAll();

    List<Joueur> findRange(int[] range);

    int count();
    
    List listJoueurs();    

    void creerJoueur(String nom, String prenom, Equipe equipe);

    List listJoueursEquipe(Equipe equipe);
}
