package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test1.entities.Chambre;
import tn.esprit.test1.services.IChambreService;

import java.util.List;

@RequestMapping("/chambres")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ChambreController {
    @Autowired
    IChambreService chambreService;
    //pour tester on doit introduire l url http://localhost:9995/universities/all
    @GetMapping("/all")
    public List<Chambre> getAll(){
        return  chambreService.retrieveAllChambres();

    }
    @PutMapping("/add-chambre")
    public void addChambre (@RequestBody Chambre e){
        chambreService.addchambre(e);
    }
}
