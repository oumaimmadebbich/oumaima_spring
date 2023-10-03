package tn.esprit.test1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity

public class
Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;
    private String nomEt , prenomEt;
    private Long cin ;
    private String ecole;
    private Date dateNaissance ;
    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }



    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    @ManyToMany(mappedBy="etudiants")
    private Set<Reservation> reservations;
}
