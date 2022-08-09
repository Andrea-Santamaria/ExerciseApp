package project.qseat.qseatdemo.services.sources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.entities.Dipendente;
import project.qseat.qseatdemo.repositories.DipendenteRepository;
import project.qseat.qseatdemo.services.DipendenteService;

@Component
@RequiredArgsConstructor
public class DipendenteServiceSource implements DipendenteService{
    // in questa CLASSE si IMPLEMENTANO i servizi disponibili

    // le funzioni si appoggieranno alle funzioni (o di default o che ho
    // dichiatato io) della Repository, quindi mi serve un oggetto repository
    private final DipendenteRepository repo;

    // implemento il servizio che trova tutti i dipendenti ancora in quantyca
    // devo mettere per forza OVERRIDE se voglio implementare un servizio
    // altrimenti è un metodo interno che sta solo qui
    @Override
    public List<Dipendente> findDipendenti() {
        System.out.println("...sto eseguendo findDipendenti...");
        List<Dipendente> listAncoraDentro = new ArrayList<>();
        for(Dipendente e : repo.findAll()){
            
            // check di chi è ancora dentro in quantyca
            if(e.getDataUscita() == null){
                listAncoraDentro.add(e);
            }
        }
        return listAncoraDentro;
    }

    // implemento il servizio che trova il dipendente in quantyca 
    // filtrando con la sua mail, se non lavora più qui restituisce null
    @Override
    public Dipendente findDipendente(String email) {
        System.out.println("...sto eseguendo findDipendente...");
        
        // check se è ancora dentro in quantyca
        if(repo.findByEmail(email).getDataUscita() == null)
            return repo.findByEmail(email);
        else 
            System.out.println("il dipendente cercato non lavora più in Quantyca :(");
        
        return null;
    }
}
