package tn.esprit.test1.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idUniversite;
    @Column(unique = true)
    @NonNull
    private String nomUniversite;
    private String adresse;
    @OneToOne(mappedBy = "universite")
    private Foyer foyer;
}

