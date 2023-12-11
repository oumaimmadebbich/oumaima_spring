package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test1.entities.Universite;
import tn.esprit.test1.services.IUniversiteService;

import java.util.List;

import java.util.logging.Level;

@RequestMapping("/universities")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UniversiteController {
    @Autowired
    IUniversiteService universiteService;
    //pour tester on doit introduire l url http://localhost:9995/universities/all
    @GetMapping("/all")
    public List<Universite> getAll(){
        return  universiteService.retrieveAllUniversities();

    }
    //id on appel path variable{}
    @GetMapping("/{id}")
    public Universite getUniversite(@PathVariable Long id){
        return universiteService.retrieveUniversity(id);
    }
    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.addUniversity(u);
    }
    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteService.updateUniversity(u);
    }
    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id){
        universiteService.removeUniversity(id);
    }
    @PutMapping("/desaffecter/{iduniversity}")
    public void  desaffecterFoyerAUniversite (@PathVariable("iduniversity") Long idUniversite){
        universiteService.desaffecterFoyerAUniversite(idUniversite);

    }
}
