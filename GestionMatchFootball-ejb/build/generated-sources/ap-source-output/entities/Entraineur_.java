package entities;

import entities.Equipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-28T17:42:59")
@StaticMetamodel(Entraineur.class)
public class Entraineur_ { 

    public static volatile SingularAttribute<Entraineur, String> mdp;
    public static volatile SingularAttribute<Entraineur, Long> id;
    public static volatile SingularAttribute<Entraineur, String> login;
    public static volatile SingularAttribute<Entraineur, String> prenom;
    public static volatile SingularAttribute<Entraineur, String> nom;
    public static volatile ListAttribute<Entraineur, Equipe> historique;

}