package entities;

import entities.Arbitre;
import entities.Equipe;
import entities.Faute;
import entities.Joueur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-13T16:38:30")
@StaticMetamodel(Match.class)
public class Match_ { 

    public static volatile SingularAttribute<Match, Integer> scoreEquipeReceveuse;
    public static volatile SingularAttribute<Match, Date> date;
    public static volatile ListAttribute<Match, Joueur> effectifEquipeReceveuse;
    public static volatile SingularAttribute<Match, Equipe> equipeInvitee;
    public static volatile ListAttribute<Match, Faute> fautes;
    public static volatile SingularAttribute<Match, Integer> scoreEquipeInvitee;
    public static volatile SingularAttribute<Match, Arbitre> arbitre;
    public static volatile ListAttribute<Match, Joueur> effectifEquipeInvitee;
    public static volatile SingularAttribute<Match, Long> id;
    public static volatile SingularAttribute<Match, Equipe> equipeReceveuse;

}