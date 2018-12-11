package entities;

import entities.Equipe;
import entities.Faute;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-11T22:47:47")
@StaticMetamodel(Joueur.class)
public class Joueur_ { 

    public static volatile ListAttribute<Joueur, Faute> fautes;
    public static volatile ListAttribute<Joueur, Equipe> historiqueEquipes;
    public static volatile SingularAttribute<Joueur, Long> id;
    public static volatile SingularAttribute<Joueur, Equipe> equipe;
    public static volatile SingularAttribute<Joueur, String> prenom;
    public static volatile SingularAttribute<Joueur, String> nom;

}