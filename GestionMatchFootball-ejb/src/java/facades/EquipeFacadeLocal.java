/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Entraineur;
import entities.Equipe;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grind-Machine
 */
@Local
public interface EquipeFacadeLocal {

    void create(Equipe equipe);

    void edit(Equipe equipe);

    void remove(Equipe equipe);

    Equipe find(Object id);

    List<Equipe> findAll();

    List<Equipe> findRange(int[] range);

    int count();

    void creerEquipe(String nom, Entraineur entraineur);

    Equipe rechercheEquipe(String nom);

    List listEquipes();

    Equipe rechercheEquipe(long id);

    Equipe rechercheEquipeParEntraineur(Entraineur entraineur);

    List listEquipesTransfert(Equipe equipeActuelle);

    boolean disponible(long id, Timestamp date);

    void supprimerEntraineurEquipe(Entraineur entraineur);

    List classement();

    void modifierEquipe(Equipe equipe, String newNom, Entraineur newEntraineur);

    void supprimerEquipe(Equipe equipe);
    
}
