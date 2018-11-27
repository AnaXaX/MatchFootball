/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashSet;
//import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Grind-Machine
 */
@Entity
public class Equipe implements Serializable {
    /*
    public Equipe(){
        effectif = new ArrayList<Joueur>();
        historiqueMatchs = new ArrayList<Match>();
    }
*/
    @OneToMany(mappedBy = "equipeUne")
    private List<Match> historiqueMatchs;

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> effectif;

    public List<Joueur> getEffectif() {
        return effectif;
    }

    public void setEffectif(List<Joueur> effectif) {
        this.effectif = effectif;
    }
    
    /*Pour garder la synchronisation/relation de la liste effectif*/
    public void addJoueurEffectif(Joueur joueur) {
        effectif.add(joueur);
        joueur.setEquipe(this);
    }
    
    public void removeJoueurEffectif(Joueur joueur) {
        effectif.remove(joueur);
        joueur.setEquipe(null);
    }
    
    /*Pour garder la synchronisation/relation de la liste effectif*/
  
    
    @ManyToOne
    private Entraineur entraineur;

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }
    
    @Column(unique=true,nullable=false)
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Equipe[ id=" + id + " ]";
    }
    
}
