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

    List listJoueursEquipe(Equipe equipe);

    void affecterEquipe(Joueur j, Equipe e);

    void creerJoueur(String nom, String prenom);

    Joueur rechercheJoueur(long id);

    List listJoueurSansEquipe();

    void transferJoueur(Joueur joueur, Equipe ancienneEquipe, Equipe nouvelleEquipe);

    void supprimerContratJoueur(Joueur j);

    void supprimerHistoriqueEquipe(Equipe equipe);
}
