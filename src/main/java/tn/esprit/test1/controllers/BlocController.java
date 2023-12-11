package tn.esprit.test1.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.test1.entities.Bloc;
import tn.esprit.test1.entities.Etudiant;
import tn.esprit.test1.services.IBlocService;
import tn.esprit.test1.services.IEtudiantService;

import java.util.List;

@RequestMapping("/blocs")
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BlocController {
    @Autowired
    IBlocService blocService;
    //pour tester on doit introduire l url http://localhost:9995/universities/all
    @GetMapping("/all")
    public List<Bloc> getAll(){
        return  blocService.retrieveAllBlocs();

    }
    @PutMapping("/affecterchambreBloc/{idBloc}")
    public void affecterchambreBloc (@PathVariable("idChambre")List<Long> numCombre,@PathVariable("idBloc") long idBloc){
        blocService.affecterchambreBloc(numCombre,idBloc);
    }
    @PutMapping("/add-bloc")
    public void addBloc (@RequestBody Bloc e){
        blocService.addBloc(e);
    }
}
