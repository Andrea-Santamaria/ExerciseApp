package project.qseat.qseatdemo.services;

import java.util.List;

import project.qseat.qseatdemo.model.dto.StoricoPrenotazioneDTO;
import project.qseat.qseatdemo.model.entities.StoricoPrenotazione;

public interface StoricoPrenotazioneService {
    // funzione per ottenere tutte le prenotazioni
    List<StoricoPrenotazione> findAllPrenotazioni();

    // funzione per ottenere le prenotazioni a seconda del parametro/i che passo
    List<StoricoPrenotazione> findPrenotazioni(String data, String sede, String piano, String nome, String cognome);

    // funzione per rimuovere una prenotazione, devo per forza passarci due parametri
    // perché la tabella ha una composite key
    void removePrenotazione(String data, String codPostazioneScrivania);

    //void removePrenotazione(String data, String codPostazioneScrivania, String nome, String cognome);
    
    // però posso anche rimuovere una prenotazione passando in ingresso a data e la email
    //void removePrenotazione2(String data, String nome, String cognome);

    // funzione per aggiungere un nuovo record, vuole in input un oggetto del DTO
    // dovrà per forza restituire il type dell'oggetto che ho creato
    StoricoPrenotazione savePrenotazione(StoricoPrenotazioneDTO obj);
}
