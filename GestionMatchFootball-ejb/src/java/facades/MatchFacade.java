/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Arbitre;
import entities.Effectif;
import entities.Equipe;
import entities.MatchFoot;
import entities.ReceveuseInvitee;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class MatchFacade extends AbstractFacade<MatchFoot> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(MatchFoot.class);
    }

    @Override
    public void creerMatch(Timestamp date, Equipe equipeReceveuse, Equipe equipeInvitee, Arbitre arbitre) {
        MatchFoot m = new MatchFoot();
        m.setDate(date);
        equipeReceveuse.addHistoriqueMatchInvites(m);
        equipeInvitee.addHistoriqueMatchRecus(m);
        //m.setEquipeInvitee(equipe2);
        arbitre.addHistoriqueMatch(m);
        m.setScoreEquipeInvitee(-1);
        m.setScoreEquipeReceveuse(-1);

        //m.setEffectifEquipeInvitee(equipeInvitee.getEffectif());
        //m.setEffectifEquipeReceveuse(equipeReceveuse.getEffectif());
        em.persist(m);
        em.merge(arbitre);
        em.merge(equipeReceveuse);
        em.merge(equipeInvitee);
    }
    
    
    @Override
    public void modifierMatch(Timestamp date, MatchFoot match) {
        match.setDate(date);
        em.merge(match);
    }

    @Override
    public void annulerMatch(MatchFoot match) {
        em.remove(match);
    }

    @Override
    public List afficherMatchsTactique(Equipe equipe) {
        Query requete = getEntityManager().createQuery("select m from MatchFoot as m where (m.equipeInvitee=:equipe OR m.equipeReceveuse=:equipe) AND CURRENT_TIMESTAMP <= m.dateMatch ");
        requete.setParameter("equipe", equipe);
        return requete.getResultList();
    }

    @Override
    public MatchFoot rechercheMatchId(long id) {
        MatchFoot m = null;
        Query requete = getEntityManager().createQuery("select m from MatchFoot as m where m.id=:id");
        requete.setParameter("id", id);
        List<MatchFoot> list = requete.getResultList();
        for (MatchFoot mm : list) {
            m = mm;
        }
        return m;
    }

    @Override
    public void affecterMatch(List joueurs, MatchFoot match, Equipe e) {
        if (match.getEquipeInvitee().equals(e)) {
            Effectif effectifASupprimer = null;
            for (Effectif effectif : match.getEffectif()) {
                if (effectif.getReceveuseInvitee().equals(ReceveuseInvitee.I)) {
                    effectifASupprimer = effectif;
                }
            }
            if (effectifASupprimer != null) {
                match.getEffectif().remove(effectifASupprimer);
                em.merge(match);
                em.remove(effectifASupprimer);
            }
            Effectif eI = new Effectif();
            eI.setListeJoueurs(joueurs);
            eI.setReceveuseInvitee(ReceveuseInvitee.I);
            match.getEffectif().add(eI);
            em.persist(eI);
            em.merge(match);
            //match.setEffectifEquipeInvitee(joueurs);
        } else {
            Effectif effectifASupprimer = null;
            for (Effectif effectif : match.getEffectif()) {
                if (effectif.getReceveuseInvitee().equals(ReceveuseInvitee.R)) {
                    effectifASupprimer = effectif;
                }
            }
            if (effectifASupprimer != null) {
                match.getEffectif().remove(effectifASupprimer);
                em.merge(match);
                em.remove(effectifASupprimer);
            }
            Effectif eR = new Effectif();
            eR.setListeJoueurs(joueurs);
            eR.setReceveuseInvitee(ReceveuseInvitee.R);
            match.getEffectif().add(eR);
            em.persist(eR);
            em.merge(match);
            //match.setEffectifEquipeReceveuse(joueurs);
        }
        em.merge(match);
    }

    @Override
    public List listMatchs() {
        return getEntityManager().createQuery("select m from MatchFoot as m order by m.dateMatch").getResultList();
    }

    @Override
    public List rechercheMatch(Timestamp date) {
        Timestamp dateMin = ((Timestamp) date.clone());
        Timestamp dateMax = ((Timestamp) date.clone());
        long duration = ((1380 * 60)/* + 00*/) * 1000; // rajout de 23 heures pour avoir toute la journée
        dateMin.setTime(date.getTime());
        dateMax.setTime(date.getTime() + duration);
        // journée de 00:00:00 à 23:00:00
        Query requete = getEntityManager().createQuery("select m from MatchFoot as m where  m.dateMatch>=:dateMin AND m.dateMatch<=:dateMax");
        requete.setParameter("dateMin", dateMin);
        requete.setParameter("dateMax", dateMax);
        return requete.getResultList();
    }

    @Override
    public List rechercheMatch(Timestamp dateD, Timestamp dateF) {
        Query requete = getEntityManager().createQuery("select m from MatchFoot as m where m.dateMatch>=:dateD AND m.dateMatch<=:dateF");
        requete.setParameter("dateD", dateD);
        long duration = ((1380 * 60)/* + 00*/) * 1000;
        dateF.setTime(dateF.getTime() + duration);
        requete.setParameter("dateF", dateF);
        return requete.getResultList();
    }


    @Override
    public List listMatchsArbitre(Arbitre arbitre) {
        Query requete = getEntityManager().createQuery("select m from MatchFoot as m where m.dateMatch<CURRENT_TIMESTAMP AND m.arbitre=:arbitre");
        requete.setParameter("arbitre", arbitre);
        return requete.getResultList();
    }

    @Override
    public void setScoreMatchArbitre(MatchFoot match, int scoreEquipeReceveuse, int scoreEquipeInvitee) {
        match.setScoreEquipeReceveuse(scoreEquipeReceveuse);
        match.setScoreEquipeInvitee(scoreEquipeInvitee);
        em.merge(match);
    }
}
