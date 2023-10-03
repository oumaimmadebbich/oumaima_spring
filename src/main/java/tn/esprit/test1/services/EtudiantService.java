package tn.esprit.test1.services;

import org.springframework.stereotype.Service;
import tn.esprit.test1.entities.Etudiant;

import java.util.List;
@Service
public class EtudiantService implements IEtudiantService{
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return null;
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {

    }
}
