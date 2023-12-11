package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.entities.Reservation;

import java.util.Date;
import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByAnneUniversitaire_Year(int i);

    Reservation findByEtudiant(Etudiant etudiant);

    List<Reservation> findByEtudiant_Universite_NomAndAnneeUniversitaire(String nomUniversite, Date anneeUniversite);

    List<Reservation> findByChambre_IdIn(List<Object> collect);
}
