package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
