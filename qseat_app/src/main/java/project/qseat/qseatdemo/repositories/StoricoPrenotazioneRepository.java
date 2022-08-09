package project.qseat.qseatdemo.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.qseat.qseatdemo.model.entities.Dipendente;
import project.qseat.qseatdemo.model.entities.Postazione;
import project.qseat.qseatdemo.model.entities.StoricoPrenotazione;
import project.qseat.qseatdemo.model.entities.StoricoPrenotazioneId;

public interface StoricoPrenotazioneRepository extends JpaRepository<StoricoPrenotazione, StoricoPrenotazioneId>{
    
    // funzioni per fare il delete di acuni record
    @Transactional
    void deleteByDataAndCodPostazioneScrivania(LocalDate data, Postazione desk);
    
    @Transactional
    void deleteByDataAndRisorsa(LocalDate data, Dipendente employee);

    // query per fare la ricerca dei record a seconda degli input che passo
    @Query(value = "SELECT b " +
            "FROM StoricoPrenotazione b " +
            "WHERE (:data IS NULL OR b.data = :data) AND " +
            "(:sede IS NULL OR b.codPostazioneScrivania.sede = :sede) AND " +
            "(:piano IS NULL OR b.codPostazioneScrivania.piano = :piano) AND " +
            "(:nome IS NULL OR b.risorsa.nome = :nome) AND " +
            "(:cognome IS NULL OR b.risorsa.cognome = :cognome)")
    List<StoricoPrenotazione> filterParams(LocalDate data, String sede, String piano, String nome, String cognome);

}
