package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Bloc;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    @Override
    <S extends Bloc> S save(S entity);
}

