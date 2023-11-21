package tn.esprit.test1.services;

import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.entities.Bloc;
import tn.esprit.test1.entities.Chambre;

import java.util.List;

public class ChambreService {
    ChambreRepository chambreRepository;
    public List<Chambre> retrieveAllChambres() {

        return chambreRepository.findAll();
    }

    public Chambre addChambre(Chambre c) {

        return chambreRepository.save(c);
    }

    public Chambre updateChambre(Chambre c) {

        return chambreRepository.save(c);
    }

    public Chambre retrieveChambre(Long idChambre) {

        return chambreRepository.findById(idChambre).get();
    }

    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);


    }
    public long nbrChambreParTypeEtBloc(Chambre.TypeChambre typeChambre, long idBloc) {
        return chambreRepository.countByTypeCAndBlocs_Id(typeChambre,idBloc);
    }
}


