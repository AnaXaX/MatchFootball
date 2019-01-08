package entities;

import entities.MatchFoot;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-08T01:06:07")
@StaticMetamodel(Arbitre.class)
public class Arbitre_ { 

    public static volatile SingularAttribute<Arbitre, String> mdp;
    public static volatile SingularAttribute<Arbitre, Long> id;
    public static volatile SingularAttribute<Arbitre, String> login;
    public static volatile SingularAttribute<Arbitre, String> prenom;
    public static volatile SingularAttribute<Arbitre, String> nom;
    public static volatile ListAttribute<Arbitre, MatchFoot> historiqueMatchs;

}