package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.test1.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
