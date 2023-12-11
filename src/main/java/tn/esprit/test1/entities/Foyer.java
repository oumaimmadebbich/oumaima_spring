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

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idFoyer;
    @Column(unique = true)
    @NonNull
    private String nomFoyer;
    private Long capaciteFoyer;
    //relationship entre foyer et universite(1to1)
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "universite_id")
    private Universite universite;
    @OneToMany(mappedBy = "foyer",fetch = FetchType.LAZY)
    private Set<Bloc> Blocs=new HashSet<>();
    private boolean archived=false;
}
