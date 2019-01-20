package sessions;

import entities.Entraineur;
import entities.Equipe;
import entities.Joueur;
import entities.MatchFoot;
import facades.EntraineurFacadeLocal;
import facades.EquipeFacadeLocal;
import facades.JoueurFacadeLocal;
import facades.MatchFacadeLocal;
import java.util.ArrayList;
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
    private MatchFacadeLocal matchFacade;

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
    public List rechercheJoueursSansEquipe() {
        return joueurFacade.listJoueurSansEquipe();
    }

    @Override
    public void affecterJoueur(long id, Equipe e) {
        joueurFacade.affecterEquipe(joueurFacade.rechercheJoueur(id), e);
    }  

    @Override
    public List listEquipesTransfert(Equipe equipeActuel) {
        return equipeFacade.listEquipesTransfert(equipeActuel);
    }

    @Override
    public void transfererJoueur(long idJoueur, Equipe ancienneEquipe, long nouvelleEquipe) {
        joueurFacade.transferJoueur(joueurFacade.rechercheJoueur(idJoueur), ancienneEquipe, equipeFacade.rechercheEquipe(nouvelleEquipe));
    }

    @Override
    public void supprimerContratJoueur(long idJoueur) {
        joueurFacade.supprimerContratJoueur(joueurFacade.rechercheJoueur(idJoueur));
    }

    @Override
    public List listMatchsTactique(Equipe equipe) {
        return matchFacade.afficherMatchsTactique(equipe);
    }

    @Override
    public MatchFoot rechercheMatchId(long id) {
        return matchFacade.rechercheMatchId(id);
    }

    @Override
    public void affecterMatch(String[] idJoueurs, long idMatch, Equipe e) {
        ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>();
        for(String j : idJoueurs){
            listJoueurs.add(joueurFacade.rechercheJoueur(Long.parseLong(j)));
        }
        
        matchFacade.affecterMatch(listJoueurs,matchFacade.rechercheMatchId(idMatch),e);
    }
    
    
    
}
