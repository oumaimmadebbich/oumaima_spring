package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.services.IEtudiantService;
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/etudiants")
public class EtudiantController {
    IEtudiantService etudiantService;
    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){

        return etudiantService.addEtudiant(e);
    }
    @PostMapping("/modif_etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e)
    {
        Etudiant etudiant=etudiantService.updateEtudiant(e);
        return etudiant;
    }
//@PostMapping("/remove-etudiant/{id_Etudiant}")




}