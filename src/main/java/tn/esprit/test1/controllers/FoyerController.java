package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test1.entities.Foyer;
import tn.esprit.test1.services.IFoyerService;

import java.util.List;

@RequestMapping("/foyers")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class FoyerController {
    @Autowired
    IFoyerService foyerService;
    //pour tester on doit introduire l url http://localhost:9995/universities/all
    @GetMapping("/all")
    public List<Foyer> getAll(){
        return  foyerService.retrieveAllFoyers();

    }
    //id on appel path variable{}
    @GetMapping("/{id}")
    public Foyer getFoyer(@PathVariable Long id){

        return foyerService.retrieveFoyer(id);
    }
    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){

        return foyerService.addFoyer(f);
    }
    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer f){

        return foyerService.updateFoyer(f);
    }

    // Ajoutez un attribut boolean archived dans l'entité Foyer, par défault false et le modifier à true suite à l'exécution de ce service
    @PutMapping("/archiver/{id}")
    public ResponseEntity<String> archiverFoyer(@PathVariable Long id) {
        Foyer foyer = foyerService.retrieveFoyer(id);
        if (foyer != null) {
            foyer.setArchived(true); // Mettre à true pour archiver le foyer
            foyerService.updateFoyer(foyer); // Mettre à jour l'état du foyer dans la base de données
            return ResponseEntity.ok("Foyer archivé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Foyer non trouvé pour cet ID");
        }

    }
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable("idUniversite") long idUniversite){
        foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
        return null;
    }

}

