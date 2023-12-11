package tn.esprit.test1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.test1.entities.Chambre;
import tn.esprit.test1.entities.TypeChambre;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long>{
    @Override
    Optional<Chambre> findById(Long aLong);

    @Override
    <S extends Chambre> S save(S entity);


    List<Chambre> findByBloc(long id);
    Chambre findByNumeroChambre(Long n);


        @Query("select c From Chambre c where c.typeC='DOUBLE' and c.bloc.idBloc=:blocId")
        List<Chambre> findChambresByTypeCAndBloc_IdBloc(@Param("blocId") Long id);
        @Query("select c from Chambre c join Reservation r ON r.chambre.idChambre=c.idChambre where r.estValide=:estValide")
        List<Chambre> findChambresByReservationsAndValidtions(@Param("estValide") Boolean estValide);
        @Query("select c from Chambre c where c.bloc.idBloc=:blocId and c.bloc.capaciteBloc>:capacity")
        List<Chambre> findChambresByCapacityBlocGreaterThan(@Param("blocId") Long idBloc,@Param("capacity") Long capacity);


    long countByTypeCAndBlocs_Id(Chambre.TypeChambre typeChambre, long idBloc);

    Collection<Object> findByUniversite_NomAndTypeAndIdNotIn(String nomUniversite, TypeChambre type, List<Object> objects);
}

