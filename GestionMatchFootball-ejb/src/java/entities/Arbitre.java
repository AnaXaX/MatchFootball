package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Grind-Machine
 */
@Entity
public class Arbitre implements Serializable {
    
    @Column(nullable=false,unique=false)
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Column(nullable=false,unique=true)
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    @OneToMany(mappedBy = "arbitre")
    private List<Match> historiqueMatchs;

    public List<Match> getHistoriqueMatchs() {
        return historiqueMatchs;
    }
    
    /*Pour garder la synchronisation/relation des listes et BD*/
    public void addHistoriqueMatch(Match m) {
        historiqueMatchs.add(m);
        m.setArbitre(this);
    }
    
    public void removeHistoriqueMatch(Match m) {
        historiqueMatchs.remove(m);
        m.setArbitre(null);
    }
    /*Pour garder la synchronisation/relation des listes et BD*/
        
    @Column(nullable=false,unique=false)
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    @Column(nullable=false,unique=false)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Arbitre)) {
            return false;
        }
        Arbitre other = (Arbitre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Arbitre[ id=" + id + " ]";
    }
    
}
