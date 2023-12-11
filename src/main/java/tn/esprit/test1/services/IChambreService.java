package tn.esprit.test1.services;

import tn.esprit.test1.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addchambre (Chambre e);

    void getChambresParBloc(long idBloc);

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);
}
