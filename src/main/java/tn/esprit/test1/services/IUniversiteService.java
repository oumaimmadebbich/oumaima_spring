package tn.esprit.test1.services;

import tn.esprit.test1.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    void UniversiteaffecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversity (long idUniversity);
    void removeUniversity  (long idUniversity );

    void desaffecterFoyerAUniversite(Long idUniversite);
}
