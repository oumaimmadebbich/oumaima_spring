package tn.esprit.test1.services;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.test1.Repositories.EtudiantRepository;
import tn.esprit.test1.Repositories.ReservationRepository;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.entities.Reservation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationService {
    ReservationRepository reservationRepository;

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll() ;
    }

    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }


    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);

    }


    public List<Reservation> getReservationParAnneeUniversitaire(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return reservationRepository.findByAnneUniversitaire_Year(calendar.get(Calendar.YEAR));
    }

}


