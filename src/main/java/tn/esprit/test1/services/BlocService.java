package tn.esprit.test1.services;

import tn.esprit.test1.Repositories.BlocRepository;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.entities.Bloc;
import tn.esprit.test1.entities.Chambre;

import java.util.List;

public class BlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    public Bloc affecterChambresABloc (List<Long> numChambre, Long idBloc){
        Bloc bloc = BlocRepository.findById(idBloc).get();
        List<Chambre> chambres =(List<Chambre>) ChambreRepository.findAllById(numChambre);
        Chambre.setBloc(bloc);
        BlocRepository.save(bloc);

    return Bloc ;
}}

