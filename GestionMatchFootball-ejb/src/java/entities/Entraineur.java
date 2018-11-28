/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Entraineur implements Serializable {

    @OneToMany(mappedBy = "entraineur")
    private List<Equipe> historique;

    public List<Equipe> getHistorique() {
        return historique;
    }
    
        /*Pour garder la synchronisation/relation des listes et BD*/
    public void addEquipeHistorique(Equipe e) {
        historique.add(e);
        e.setEntraineur(this);
    }
    
    public void removeEquipeHistorique(Equipe e) {
        historique.remove(e);
        e.setEntraineur(null);
    }
        /*Pour garder la synchronisation/relation des listes et BD*/

   
    @Column(nullable=false,unique=true)
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(nullable=false,unique=false)
    private String mdp;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    @Column(unique=false,nullable=false)
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    @Column(unique=false,nullable=false)
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
        if (!(object instanceof Entraineur)) {
            return false;
        }
        Entraineur other = (Entraineur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entraineur[ id=" + id + " ]";
    }
    
}
