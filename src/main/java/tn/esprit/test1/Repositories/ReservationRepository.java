package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
