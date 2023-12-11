package tn.esprit.test1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Reservation {
    @Id

    private String idReservation;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private Boolean estValide;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;
    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiants=new HashSet<>();

    public void setEtudiant(Etudiant etudiant) {
    }
}

