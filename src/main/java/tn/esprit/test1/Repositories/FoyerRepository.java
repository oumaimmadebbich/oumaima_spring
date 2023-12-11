package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Bloc;
import tn.esprit.test1.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    @Query("select b from Bloc b  where b.foyer.universite.idUniversite=:universiteId ")
    List<Bloc> findAllBlocsByUniversiteId (@Param("universiteId")Long universiteId);
}

