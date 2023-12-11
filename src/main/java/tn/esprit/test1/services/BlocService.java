package tn.esprit.test1.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.test1.Repositories.BlocRepository;
import tn.esprit.test1.Repositories.ChambreRepository;
import tn.esprit.test1.entities.Bloc;
import tn.esprit.test1.entities.Chambre;

import java.util.List;

@AllArgsConstructor
@Service
public class BlocService implements IBlocService {

    private final ChambreRepository chambreRepository; // Utilisation de final pour l'injection de dépendances
    private final BlocRepository blocRepository;

    public Bloc affecterChambreBloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null); // Utilisation de findById().orElse(null) pour éviter les NPE

        if (bloc != null) {
            List<Chambre> chambres = (List<Chambre>) chambreRepository.findAllById(numChambres);

            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
                chambreRepository.save(chambre); // Sauvegarde de chaque chambre
            }

            // Sauvegarde du bloc une fois toutes les chambres affectées
            return blocRepository.save(bloc);
        }

        return null; // Retourne null si le bloc n'est pas trouvé
    }

    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc affecterchambreBloc(List<Long> numCombre, long idBloc) {
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}