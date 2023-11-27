package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.entities.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByAnneUniversitaire_Year(int i);

    Reservation findByEtudiant(Etudiant etudiant);
}
