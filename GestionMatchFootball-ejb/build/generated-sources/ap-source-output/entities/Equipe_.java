package entities;

import entities.Entraineur;
import entities.Joueur;
import entities.MatchFoot;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-08T01:06:07")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile ListAttribute<Equipe, Joueur> effectif;
    public static volatile SingularAttribute<Equipe, Entraineur> entraineur;
    public static volatile ListAttribute<Equipe, MatchFoot> historiqueMatchsInvites;
    public static volatile SingularAttribute<Equipe, Long> id;
    public static volatile ListAttribute<Equipe, MatchFoot> historiqueMatchsRecus;
    public static volatile SingularAttribute<Equipe, String> nom;
    public static volatile SingularAttribute<Equipe, Integer> points;

}