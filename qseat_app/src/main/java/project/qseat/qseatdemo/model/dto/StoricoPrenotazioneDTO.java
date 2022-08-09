package project.qseat.qseatdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class StoricoPrenotazioneDTO {
    // mi tornerà utile quando verranno trasferiti dei dati da inserire nella tabella
    
    @Column(name="Data")
    private LocalDate data;

    @Column(name="CodPostazioneScrivania")
    private String codPostazioneScrivania;

    @Column(name="Risorsa")
    private String risorsa;

    // non metto il timestamp perché lo inserò 
    // automaticamente quando ricevo dei dati attraverso le funzioni
}
