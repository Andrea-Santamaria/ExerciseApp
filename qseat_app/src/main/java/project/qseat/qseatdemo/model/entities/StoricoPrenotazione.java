package project.qseat.qseatdemo.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "StoricoPrenotazioni")
@Data
@IdClass(StoricoPrenotazioneId.class) // sono obbligato per definire una composite key
@NoArgsConstructor
@AllArgsConstructor
public class StoricoPrenotazione {
    @Id
    @Column(name = "Data")
    private LocalDate data;

    // siccome c'è una many-to-one relation con Postazione, lo sottolineo
    // introducendo come membro della classe NON una semplice stringa che
    // riporterebbe l'id della postazione, bensì un intero oggetto Postazione
    // e lo associo all'attributo CodPostazioneScrivania per fare la join su
    // questa tabella  (la key di riferimento è IdPostazioneScrivania)
    @Id
    @ManyToOne
    @JoinColumn(name = "CodPostazioneScrivania")
    private Postazione codPostazioneScrivania;

    // stesso discorso per Dipendente e la sua key Email che viene joinata
    // sull'attributo Risorsa di questa tabella
    @ManyToOne
    @JoinColumn(name = "Risorsa")
    private Dipendente risorsa;

    @Column(name = "InsertUpdateTimestamp")
    private LocalDateTime insertUpdateTimestamp;
}
