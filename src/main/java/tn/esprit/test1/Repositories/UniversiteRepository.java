package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
