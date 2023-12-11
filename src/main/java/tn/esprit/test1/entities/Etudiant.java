package tn.esprit.test1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEtudiant;
    @NonNull
    private  String nomEt;
    @NonNull
    private String prenomEt;
    @Column(length = 8, unique = true)
    @NonNull
    private  Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    //lazy le cahrgement se fait a la demande au moment d l'execution et eager avec les autres colonnes

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "etudiants_reservations",
            joinColumns = @JoinColumn(name = "etudiant_id",referencedColumnName = "idEtudiant"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id",referencedColumnName = "idReservation"))
    private Set<Reservation> reservations=new HashSet<>();
}

