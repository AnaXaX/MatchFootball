package entities;

import entities.Arbitre;
import entities.Equipe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T09:39:22")
@StaticMetamodel(Match.class)
public class Match_ { 

    public static volatile SingularAttribute<Match, Date> date;
    public static volatile SingularAttribute<Match, String> score;
    public static volatile SingularAttribute<Match, Equipe> equipeUne;
    public static volatile SingularAttribute<Match, Arbitre> arbitre;
    public static volatile SingularAttribute<Match, Long> id;
    public static volatile SingularAttribute<Match, Equipe> equipeDeux;

}