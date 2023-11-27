package tn.esprit.test1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name ="Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeChambre;

    public static void setBloc(Bloc bloc) {
    }

    public  enum TypeChambre{
        Simple , Double , Triple
    }


    @ManyToOne
    private Bloc bloc;

    @OneToMany
    private Set<Reservation> reservations;
}