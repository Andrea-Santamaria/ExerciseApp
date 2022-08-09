package project.qseat.qseatdemo.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable // sono obbligato per definire una composite key
public class StoricoPrenotazioneId implements Serializable{
    // siccome ho una Composite Key nella tabella StoricoPrenotazione
    // l'unico modo per definire ciò è introdurre un'altra classe
    // i cui membri sono proprio le primary key della tabella 
    // Attenzione: i nomi dei membri devono COINCIDERE!
    private LocalDate data;
    private Postazione codPostazioneScrivania;

}
