package project.qseat.qseatdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.dto.StoricoPrenotazioneDTO;
import project.qseat.qseatdemo.model.entities.StoricoPrenotazione;
import project.qseat.qseatdemo.services.StoricoPrenotazioneService;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/bookingHistory")
public class StoricoPrenotazioneControllers {
    private final StoricoPrenotazioneService storicoPrenotazioneService;

    @GetMapping("/get-all")
    public List<StoricoPrenotazione> getPrenotazioni() {
        return storicoPrenotazioneService.findAllPrenotazioni();
    }

    @GetMapping("/get-few")
    public List<StoricoPrenotazione> getFewPrenotazioni(
                                @RequestParam(required = false) String data,
                                @RequestParam(required = false) String sede,
                                @RequestParam(required = false) String piano,
                                @RequestParam(required = false) String nome,
                                @RequestParam(required = false) String cognome) {
        return storicoPrenotazioneService.findPrenotazioni(data, sede, piano, nome, cognome);
    }

    @DeleteMapping("/delete-one")
    public String deletePrenotazione(
                                @RequestParam(required = false) String data,
                                @RequestParam(required = false) String idScrivania,
                                @RequestParam(required = false) String nome,
                                @RequestParam(required = false) String cognome) {        
        if(data != null){
            /* 
            if( !(idScrivania.isEmpty() || idScrivania == null) ){
                storicoPrenotazioneService.removePrenotazione(data, idScrivania);
                return "eliminata con successo";
            }
            System.out.println("...provo la seconda parte...");
            if( !(nome.isEmpty() || nome == null) && !(cognome.isEmpty() || cognome == null) ){
                storicoPrenotazioneService.removePrenotazione2(data, nome, cognome);
                return "eliminata con successo";
            }
            */
            //storicoPrenotazioneService.removePrenotazione(data, idScrivania, nome, cognome);
            storicoPrenotazioneService.removePrenotazione(data, idScrivania);
            return "eliminata con successo";
        }

        return "non è stato possibile rimuovere il record";
    }

    @PostMapping("/update-one")
    public StoricoPrenotazione updatePrenotazione(@RequestBody StoricoPrenotazioneDTO objDTO) {
        return storicoPrenotazioneService.savePrenotazione(objDTO);
    }
}
