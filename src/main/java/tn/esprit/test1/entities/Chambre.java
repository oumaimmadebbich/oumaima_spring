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

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    @NonNull
    private Long numeroChambre;
    //traduire sous forme de chaine de caratere
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;
    @OneToMany(mappedBy = "chambre")
    private Set<Reservation> reservations=new HashSet<>();

    public class TypeChambre {
    }
}
