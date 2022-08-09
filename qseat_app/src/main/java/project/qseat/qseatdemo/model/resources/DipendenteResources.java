package project.qseat.qseatdemo.model.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendenteResources {
    // di un dipendente mi interessano tutte le info che posso recuperare

    @Column(name="Email")
    private String email;

    @Column(name="NomeBreve")
    private String nomeBreve;

    @Column(name="NomeEsteso")
    private String nomeEsteso;

    @Column(name="Nome")
    private String nome;

    @Column(name="Cognome")
    private String cognome;

    @Column(name="Ruolo")
    private String ruolo;

    @Column(name = "InsertUpdateTimestamp")
    private LocalDateTime insertUpdateTimestamp;

    @Column(name = "DataEntrata")
    private LocalDate dataEntrata;

    @Column(name = "DataUscita")
    private LocalDate dataUscita;
}
