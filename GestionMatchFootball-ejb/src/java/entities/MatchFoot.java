package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Grind-Machine
 */
@Entity
public class MatchFoot implements Serializable {
    
    public boolean isPlayed(){
        if(scoreEquipeInvitee<0 || scoreEquipeReceveuse<0)
            return false;
        else
            return true;
    }
    /*
    @OneToMany
    private List<Joueur> effectifEquipeInvitee;

    public List<Joueur> getEffectifEquipeInvitee() {
        return effectifEquipeInvitee;
    }

    public void setEffectifEquipeInvitee(List<Joueur> effectifEquipeInvitee) {
        this.effectifEquipeInvitee = effectifEquipeInvitee;
    }
    @OneToMany
    private List<Joueur> effectifEquipeReceveuse;

    public List<Joueur> getEffectifEquipeReceveuse() {
        return effectifEquipeReceveuse;
    }

    public void setEffectifEquipeReceveuse(List<Joueur> effectifEquipeReceveuse) {
        this.effectifEquipeReceveuse = effectifEquipeReceveuse;
    }*/
    
    @OneToMany
    private List<Effectif> effectif;

    public List<Effectif> getEffectif() {
        return effectif;
    }

    public void setEffectif(List effectif) {
        this.effectif = effectif;
    }

    
    @OneToMany(mappedBy = "match")
    private List<Faute> fautes;

    public List<Faute> getFautes() {
        return fautes;
    }

    public void setFautes(List<Faute> fautes) {
        this.fautes = fautes;
    }
    
    /*Pour garder la synchronisation/relation des listes et BD*/
    public void addFaute(Faute f) {
        fautes.add(f);
        f.setMatch(this);
    }
    
    public void removeFaute(Faute f) {
        fautes.remove(f);
        f.setMatch(null);
    }
    /*Pour garder la synchronisation/relation des listes et BD*/
        
    @ManyToOne
    private Equipe equipeInvitee;

    public Equipe getEquipeInvitee() {
        return equipeInvitee;
    }

    public void setEquipeInvitee(Equipe equipeInvitee) {
        this.equipeInvitee = equipeInvitee;
    }

    @ManyToOne
    private Equipe equipeReceveuse;

    public Equipe getEquipeReceveuse() {
        return equipeReceveuse;
    }

    public void setEquipeReceveuse(Equipe equipeReceveuse) {
        this.equipeReceveuse = equipeReceveuse;
    }
    
    @Column(nullable=true,unique=false)
    private int scoreEquipeReceveuse;

    public int getScoreEquipeReceveuse() {
        return scoreEquipeReceveuse;
    }

    public void setScoreEquipeReceveuse(int scoreEquipeReceveuse) {
        this.scoreEquipeReceveuse = scoreEquipeReceveuse;
    }

    @Column(nullable=true,unique=false)
    private int scoreEquipeInvitee;

    public int getScoreEquipeInvitee() {
        return scoreEquipeInvitee;
    }

    public void setScoreEquipeInvitee(int scoreEquipeInvitee) {
        this.scoreEquipeInvitee = scoreEquipeInvitee;
    }

    @ManyToOne
    private Arbitre arbitre;

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)//Date enleve time, timestamp regroupe date & time
    private Date dateMatch;

    public Date getDate() {
        return dateMatch;
    }

    public void setDate(Date date) {
        this.dateMatch = date;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatchFoot)) {
            return false;
        }
        MatchFoot other = (MatchFoot) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "entities.Match[ id=" + id + " ]";
    }
    
}
