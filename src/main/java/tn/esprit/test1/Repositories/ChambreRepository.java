package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.test1.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long>{
    Chambre findByNumeroChambre(Long n);
}
