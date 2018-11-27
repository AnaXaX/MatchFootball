package entities;

import entities.Equipe;
import entities.Joueur;
import entities.Match;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T09:39:22")
@StaticMetamodel(Effectif.class)
public class Effectif_ { 

    public static volatile SingularAttribute<Effectif, Joueur> joueur;
    public static volatile SingularAttribute<Effectif, Match> match;
    public static volatile SingularAttribute<Effectif, Long> id;
    public static volatile SingularAttribute<Effectif, Equipe> equipe;

}