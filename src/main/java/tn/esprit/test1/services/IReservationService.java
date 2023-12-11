package tn.esprit.test1.services;

import tn.esprit.test1.entities.Reservation;

public interface IReservationService {
    Reservation ajouterReservation(long idChambre, long cinEtudiant);
}
