package tn.esprit.test1.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.FoyerRepository;
import tn.esprit.test1.Repositories.UniversiteRepository;
import tn.esprit.test1.entities.Foyer;
import tn.esprit.test1.entities.Universite;
@AllArgsConstructor
@Service

public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
    public void UniversiteaffecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).get();
// on set le fils dans le parent :
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
    }
    public void UniversitedesaffecterFoyerAUniversite( String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(null);
        universiteRepository.save(universite);
    }
}
