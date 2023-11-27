package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByNomEtudiantAndPrenomEtudiant (String nomEtudiant , String prenomEtudiant);

    Etudiant findByNomAndPrenom(String nomEt, String prenomEt);

    Etudiant findByCin(long cinEtudiant);
}
