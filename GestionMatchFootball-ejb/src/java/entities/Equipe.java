package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Grind-Machine
 */
@Entity
public class Equipe implements Serializable {
    
    public int calculerPointsFromHistorique(){
        return matchsGagnes()*3+matchsEgalites()*1;
    }
    
    public int butsMarques(){
        int i = 0;
        for(MatchFoot m : getHistoriqueMatchs()){
            if(m.isPlayed()){
                int notreScore;
                
                if(this.equals(m.getEquipeInvitee()))
                    notreScore=m.getScoreEquipeInvitee();
                
                else{
                    notreScore=m.getScoreEquipeReceveuse();
                }
                
                i+=notreScore;
                         
            }
        }
        return i;
    }
    
       public int butsRecus(){
        int i = 0;
        for(MatchFoot m : getHistoriqueMatchs()){
            if(m.isPlayed()){
                int scoreAdversaire;
                
                if(this.equals(m.getEquipeInvitee()))
                    scoreAdversaire=m.getScoreEquipeReceveuse();
         
                else
                    scoreAdversaire=m.getScoreEquipeInvitee();
     
                i+=scoreAdversaire;
                         
            }
        }
        return i;
    }
    
       public int matchsJoues(){
           int i = 0;
           for(MatchFoot m : getHistoriqueMatchs()){
               if(m.isPlayed())
                   i++;
           }
           return i;
       }
       
    public int matchsGagnes(){
        int i = 0;
        for(MatchFoot m : getHistoriqueMatchs()){
            if(m.isPlayed()){
                int notreScore, scoreAdversaire;
                
                if(this.equals(m.getEquipeInvitee())){
                    notreScore=m.getScoreEquipeInvitee();
                    scoreAdversaire=m.getScoreEquipeReceveuse();                   
                }
                else{
                    notreScore=m.getScoreEquipeReceveuse();
                    scoreAdversaire=m.getScoreEquipeInvitee();
                }
                
                if(notreScore>scoreAdversaire)
                    i++;          
            }
        }
        return i;
    }
    
        public int matchsPerdus(){
        int i = 0;
        for(MatchFoot m : getHistoriqueMatchs()){
            if(m.isPlayed()){
                int notreScore, scoreAdversaire;
                
                if(this.equals(m.getEquipeInvitee())){
                    notreScore=m.getScoreEquipeInvitee();
                    scoreAdversaire=m.getScoreEquipeReceveuse();                   
                }
                else{
                    notreScore=m.getScoreEquipeReceveuse();
                    scoreAdversaire=m.getScoreEquipeInvitee();
                }
                
                if(notreScore<scoreAdversaire)
                    i++;             
            }
        }
        return i;
    }
        
    public int matchsEgalites(){
        int i = 0;
        for(MatchFoot m : getHistoriqueMatchs()){
            if(m.isPlayed()){
                int notreScore, scoreAdversaire;
                
                if(this.equals(m.getEquipeInvitee())){
                    notreScore=m.getScoreEquipeInvitee();
                    scoreAdversaire=m.getScoreEquipeReceveuse();                   
                }
                else{
                    notreScore=m.getScoreEquipeReceveuse();
                    scoreAdversaire=m.getScoreEquipeInvitee();
                }
                
                if(notreScore==scoreAdversaire)
                    i++;
            }
        }
        return i;
    }

    public List<MatchFoot> getHistoriqueMatchs() {
        List<MatchFoot> historiqueMatchs = new ArrayList<>();
        historiqueMatchs.addAll(historiqueMatchsRecus);
        historiqueMatchs.addAll(historiqueMatchsInvites);
        return historiqueMatchs;
    }

    @OneToMany(mappedBy = "equipeInvitee")
    private List<MatchFoot> historiqueMatchsInvites;

    public List<MatchFoot> getHistoriqueMatchsRecus() {
        return historiqueMatchsRecus;
    }

    public void setHistoriqueMatchsRecus(List<MatchFoot> historiqueMatchsRecus) {
        this.historiqueMatchsRecus = historiqueMatchsRecus;
    }

    @OneToMany(mappedBy = "equipeReceveuse")
    private List<MatchFoot> historiqueMatchsRecus;

    public List<MatchFoot> getHistoriqueMatchsInvites() {
        return historiqueMatchsInvites;
    }

    public void setHistoriqueMatchsInvites(List<MatchFoot> historiqueMatchsInvites) {
        this.historiqueMatchsInvites = historiqueMatchsInvites;
    }

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> effectif;

    public List<Joueur> getEffectif() {
        return effectif;
    }

    public void setEffectif(List<Joueur> effectif) {
        this.effectif = effectif;
    }
    
    public void viderEffectif(){
        effectif.clear();
    }

    /*Pour garder la synchronisation/relation des listes et BD*/
    public void addJoueurEffectif(Joueur joueur) {
        effectif.add(joueur);
        joueur.setEquipe(this);
    }
    
    public void removeJoueurEffectif(Joueur joueur) {
        effectif.remove(joueur);
        joueur.setEquipe(null);
    }
    
    public void addHistoriqueMatchRecus(MatchFoot m) {
        historiqueMatchsRecus.add(m);
        m.setEquipeReceveuse(this);
    }
    
    public void removeHistoriqueMatchRecus(MatchFoot m) {
        historiqueMatchsRecus.remove(m);
        m.setEquipeReceveuse(null);
    }
    
    public void addHistoriqueMatchInvites(MatchFoot m) {
        historiqueMatchsInvites.add(m);
        m.setEquipeInvitee(this);
    }
    
    public void removeHistoriqueMatchInvites(MatchFoot m) {
        historiqueMatchsInvites.remove(m);
        m.setEquipeInvitee(null);
    }
    /*Pour garder la synchronisation/relation des listes et BD*/  
    
    @ManyToOne
    @OneToOne(mappedBy = "equipe")
    private Entraineur entraineur;

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }
        
    @Column(nullable=false,unique=false)
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "entities.Equipe[ id=" + id + " ]";
    }
    
}
