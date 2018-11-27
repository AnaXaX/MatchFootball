/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Grind-Machine
 */
@Entity
public class Match implements Serializable {
        
    @Column(unique=false,nullable=true)
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
 
    @ManyToOne
    private Equipe equipeDeux;

    public Equipe getEquipeDeux() {
        return equipeDeux;
    }

    public void setEquipeDeux(Equipe equipeDeux) {
        this.equipeDeux = equipeDeux;
    }
    
    @ManyToOne
    private Equipe equipeUne;

    public Equipe getEquipeUne() {
        return equipeUne;
    }

    public void setEquipeUne(Equipe equipeUne) {
        this.equipeUne = equipeUne;
    }
    
    @ManyToOne
    private Arbitre arbitre;

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Match[ id=" + id + " ]";
    }
    
}
