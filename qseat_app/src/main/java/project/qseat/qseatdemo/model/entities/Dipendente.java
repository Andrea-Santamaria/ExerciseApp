package project.qseat.qseatdemo.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AnagraficaDipendenti")
@Data                       // genera getters e setters
@AllArgsConstructor         // è il constructor con tutti i parametri
@NoArgsConstructor          // è il default constructor quello vuoto
public class Dipendente {

    @Id
    @Column(name = "Email")
    private String email;

    @Column(name = "NomeBreve")
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

    public Dipendente(String email) {
        this.email = email;
    }
}
