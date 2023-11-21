package tn.esprit.test1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Universite implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private  Long idUniversite;
    @Getter
    private String nomUniversite;
    @Getter
    private String adresse ;


    @OneToOne
    @JoinColumn(name = "idFoyer")
    private Foyer foyer;
}
