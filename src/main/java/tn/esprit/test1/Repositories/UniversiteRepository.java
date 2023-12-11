package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);

    Universite findByNom(String nomUniversite);
}
