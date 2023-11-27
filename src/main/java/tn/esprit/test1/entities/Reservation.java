package tn.esprit.test1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Reservation implements Serializable {
    @Id


    private Long idReservation;
    private Date anneeUniversitaire ;
    private Boolean estValide ;


    @ManyToMany
    private Set<Etudiant> etudiants;

    public void setChambre(Chambre chambre) {
    }

    public void setEtudiant(Etudiant etudiant) {
    }
}