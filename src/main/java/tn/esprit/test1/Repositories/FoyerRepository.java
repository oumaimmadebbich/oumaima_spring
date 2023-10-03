package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}
