package tn.esprit.test1.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import tn.esprit.test1.services.IUniversiteService;

public class UniversiteController {
    IUniversiteService universiteService;
    @PutMapping("/Universite affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public void UniversiteaffecterFoyerAUniversiteProjetDetail(@PathVariable("idFoyer") Long idFoyer,
                                                               @PathVariable("nomUniversite") String nomUniversite) {
        universiteService.UniversiteaffecterFoyerAUniversite(idFoyer, nomUniversite);
    }
}
