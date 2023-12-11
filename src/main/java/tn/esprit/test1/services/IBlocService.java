package tn.esprit.test1.services;

import tn.esprit.test1.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc affecterchambreBloc (List<Long> numCombre, long idBloc);

    Bloc addBloc(Bloc e);
}


