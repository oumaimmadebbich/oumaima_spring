package tn.esprit.test1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.BlocRepository;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.Repositories.FoyerRepository;
import tn.esprit.test1.Repositories.UniversiteRepository;
import tn.esprit.test1.entities.Foyer;
import tn.esprit.test1.entities.Universite;

import java.util.List;

@Service
public class FoyerService implements IFoyerService{
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void archiverFoyer(long idFoyer) {
        Foyer f=foyerRepository.findById(idFoyer).get();
        f.setArchived(true);
        foyerRepository.save(f);

    }
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            foyer.setUniversite(universite);
            Foyer addedFoyer = foyerRepository.save(foyer);
            return addedFoyer;
        }

        return null;
    }
}
