package project.qseat.qseatdemo.services.sources;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.dto.StoricoPrenotazioneDTO;
import project.qseat.qseatdemo.model.entities.Dipendente;
import project.qseat.qseatdemo.model.entities.Postazione;
import project.qseat.qseatdemo.model.entities.StoricoPrenotazione;
import project.qseat.qseatdemo.repositories.StoricoPrenotazioneRepository;
import project.qseat.qseatdemo.services.StoricoPrenotazioneService;

@Component
@RequiredArgsConstructor
public class StoricoPrenotazioneServiceSource implements StoricoPrenotazioneService {
    private final StoricoPrenotazioneRepository repo;
    
    @Override
    public List<StoricoPrenotazione> findAllPrenotazioni() {
        return repo.findAll();
    }

    @Override
    public List<StoricoPrenotazione> findPrenotazioni(String data, String sede, String piano, String nome, String cognome) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = null;
        if(!(data == null || data.isEmpty()))
            localDate = LocalDate.parse(data, formatter);
        //LocalDate localDate = StringToLocalDate(data);
        return repo.filterParams(localDate, sede, piano, nome, cognome);
    }

    @Override
    public void removePrenotazione(String data, String codPostazioneScrivania) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = null;
        if(!(data == null || data.isEmpty()))
            localDate = LocalDate.parse(data, formatter);
        // StringToLocalDate(data)
        Postazione desk = new Postazione(codPostazioneScrivania);
        repo.deleteByDataAndCodPostazioneScrivania(localDate, desk);
    }

    @Override
    public StoricoPrenotazione savePrenotazione(StoricoPrenotazioneDTO obj) {
        Postazione postazione = new Postazione(obj.getCodPostazioneScrivania());
        Dipendente dipendente = new Dipendente(obj.getRisorsa());
        LocalDateTime time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        StoricoPrenotazione newBooking = new StoricoPrenotazione(
                                            obj.getData(),
                                            postazione,
                                            dipendente,
                                            time);
        return repo.save(newBooking);
    }
}
