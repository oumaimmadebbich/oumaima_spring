package tn.esprit.test1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
//changement du nom du table
//@Table(name = "table_bloc")
public class Bloc {
    @Id
//automatique id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    //changement des prop de la colonne nom bloc dans la base de donnees
    @Column(name = "nom_bloc",length = 50,unique = true)
    @NonNull
    private String nomBloc;
    private Long capaciteBloc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    private Set<Chambre>  chambres =new HashSet<>() ;

}
