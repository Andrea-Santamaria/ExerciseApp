package project.qseat.qseatdemo.model.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.qseat.qseatdemo.model.entities.Postazione;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostazioneResource {
    // di postazione posso prendere tutte le info necessarie tramite l'oggetto
    // ma la cosa principale è sapere se è prenotata o no
    private Postazione postazione;
    private Boolean prenotata;
}
