package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.test1.entities.Reservation;
import tn.esprit.test1.services.IReservationService;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Reservation")
public class ReservationController{
    IReservationService ireservatinService;
    @PutMapping("/affecter/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable("idChambre") long idChambre, @PathVariable("cinEtudiant") long cinEtudiant){
        return ireservatinService.ajouterReservation(idChambre,cinEtudiant);
    }
}
