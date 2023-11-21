package tn.esprit.test1.services;

import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.EtudiantRepository;
import tn.esprit.test1.Repositories.ReservationRepository;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.entities.Reservation;

import java.util.List;
@Service
public class EtudiantService implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Reservation r = reservationRepository.findById(idReservation).get();
        return Etudiant;

    }
}