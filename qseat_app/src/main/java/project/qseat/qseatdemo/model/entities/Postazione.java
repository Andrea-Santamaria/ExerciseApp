package project.qseat.qseatdemo.model.entities;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AnagraficaPostazioni")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postazione {
    @Id 
    @Column(name = "IdPostazioneScrivania") 
    private String idPostazioneScrivania;
    
    @Column(name = "PrenotabileFlag")
    private Byte prenotabileFlag;

    @Column(name="Destinazione")
    private String destinazione;

    @Column(name="Sede")
    private String sede;

    @Column(name="Piano")
    private String piano;

    @Column(name = "InsertUpdateTimestamp")
    private LocalDateTime insertUpdateTimestamp;

    public Postazione(String idPostazioneScrivania) {
        this.idPostazioneScrivania = idPostazioneScrivania;
    }
}
