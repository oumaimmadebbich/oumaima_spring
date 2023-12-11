package tn.esprit.test1.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.Repositories.EtudiantRepository;
import tn.esprit.test1.Repositories.ReservationRepository;
import tn.esprit.test1.entities.Chambre;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.entities.Reservation;
import tn.esprit.test1.entities.Universite;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class ReservationService implements IReservationService{
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
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              ChambreRepository chambreRepository,
                              EtudiantRepository etudiantRepository) {
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
        this.etudiantRepository = etudiantRepository;
    }
    //service avancee 1ere qst
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant).orElse(null);

        if (chambre != null && etudiant != null) {
            Reservation reservation = new Reservation();
            reservation.setChambre(chambre);
            reservation.setEtudiant(etudiant);
            return reservationRepository.save(reservation);
        }
        return null;
    }
    //2eme qst service avancee
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (etudiant != null) {
            Reservation reservation = reservationRepository.findByEtudiant(etudiant);
            if (reservation != null) {
                reservationRepository.delete(reservation);
                return reservation;
            }
        }
        return null;
        //3eme qst
        public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite)
        {
            return reservationRepository.findByEtudiant_Universite_NomAndAnneeUniversitaire(nomUniversite, anneeUniversite);
        }
    }
    //4eme qst
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        Object universiteRepository = null;
        Universite universite = universiteRepository.findByNom(nomUniversite);

        if (universite != null) {
            List<Reservation> reservations = reservationRepository.findByChambre_IdIn(
                    chambreRepository.findByUniversite_NomAndTypeAndIdNotIn(nomUniversite, type, Collections.emptyList())
                            .stream()
                            .map(Chambre::getId)
                            .collect(Collectors.toList())
            );

            Set<Long> chambreIdsOccupees = reservations.stream()
                    .map(reservation -> reservation.getChambre().getId())
                    .collect(Collectors.toSet());

            return chambreRepository.findByUniversite_NomAndTypeAndIdNotIn(nomUniversite, type, new ArrayList<>(chambreIdsOccupees));
        }
        return Collections.emptyList();
    }

}
