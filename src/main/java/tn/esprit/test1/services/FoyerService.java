package tn.esprit.test1.services;

import tn.esprit.test1.Repositories.BlocRepository;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.Repositories.FoyerRepository;
import tn.esprit.test1.Repositories.UniversiteRepository;
import tn.esprit.test1.entities.Foyer;
import tn.esprit.test1.entities.Universite;

public class FoyerService {
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = UniversiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            foyer.setUniversite(universite);
            Foyer addedFoyer = foyerRepository.save(foyer);
            return addedFoyer;
        }

        return null;
    }
}
