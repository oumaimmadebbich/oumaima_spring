package tn.esprit.test1.services;

import tn.esprit.test1.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void archiverFoyer (long idFoyer);

    void ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
    // Ajoutez un attribut boolean archived dans l'entité Foyer, par défault false et le modifier à true suite à l'exécution de ce service
}

