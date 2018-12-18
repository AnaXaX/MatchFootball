package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Meiji
 */
@Entity
public class Faute implements Serializable {

    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinInterdiction;

    public Date getDateFinInterdiction() {
        return dateFinInterdiction;
    }

    public void setDateFinInterdiction(Date dateFinInterdiction) {
        this.dateFinInterdiction = dateFinInterdiction;
    }

    @Column(nullable=true,unique=false)
    private boolean cartonRouge;

    public boolean isCartonRouge() {
        return cartonRouge;
    }

    public void setCartonRouge(boolean cartonRouge) {
        this.cartonRouge = cartonRouge;
    }
    
    @Column(nullable=true,unique=false)
    private boolean cartonJaune;

    public boolean isCartonJaune() {
        return cartonJaune;
    }

    public void setCartonJaune(boolean cartonJaune) {
        this.cartonJaune = cartonJaune;
    }
    
    @ManyToOne
    private Joueur joueur;

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
       
    @ManyToOne
    private MatchFoot match;

    public MatchFoot getMatch() {
        return match;
    }

    public void setMatch(MatchFoot match) {
        this.match = match;
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
        if (!(object instanceof Faute)) {
            return false;
        }
        Faute other = (Faute) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "entities.Faute[ id=" + id + " ]";
    }
    
}
