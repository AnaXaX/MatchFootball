package entities;

import entities.Entraineur;
import entities.Joueur;
import entities.Match;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-27T09:39:22")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile ListAttribute<Equipe, Joueur> effectif;
    public static volatile SingularAttribute<Equipe, Entraineur> entraineur;
    public static volatile SingularAttribute<Equipe, Long> id;
    public static volatile SingularAttribute<Equipe, String> nom;
    public static volatile ListAttribute<Equipe, Match> historiqueMatchs;

}