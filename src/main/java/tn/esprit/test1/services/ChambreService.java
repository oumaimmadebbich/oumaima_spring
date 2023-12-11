package tn.esprit.test1.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.entities.Chambre;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
@Override
    public List<Chambre> retrieveAllChambres() {

        return chambreRepository.findAll();
    }

    @Override
    public Chambre addchambre(Chambre e) {
        return null;
    }

    @Override
    public void getChambresParBloc(long idBloc) {

    }

    @Override
    public Chambre addChambre(Chambre c) {

        return chambreRepository.save(c);
    }
@Override
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
    //qst  schedulés (sc13)
    @Scheduled(fixedRate = 5000)
    public void listeChambresParBloc() {
    }
    @Scheduled(cron = "0 0 0 * * *")
    public void pourcentageChambresParTypeChambre() {
    }
    @Scheduled(fixedDelay = 60000)
    public void nbPlacesDisponiblesParChambreAnneeEnCours() {
    }
}





