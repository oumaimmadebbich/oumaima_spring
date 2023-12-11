package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.services.IEtudiantService;
import java.util.List;
@RequestMapping("/etudiants")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;
    //pour tester on doit introduire l url http://localhost:9995/universities/all
    @GetMapping("/all")
    public List<Etudiant> getAll(){
        return  etudiantService.retrieveAllEtudiants();

    }
    //id on appel path variable{}
    @GetMapping("/{id}")
    public Etudiant getEtudiant(@PathVariable Long id){

        return etudiantService.retrieveEtudiant(id);
    }
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e){

        return etudiantService.addEtudiant(e);
    }
    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id){

        etudiantService.removeEtudiant(id);
    }
    @PostMapping("/addAll")
    public List<Etudiant> addEtudiants (List<Etudiant> etudiants){
        return etudiantService.addEtudiants(etudiants);

    }

}
