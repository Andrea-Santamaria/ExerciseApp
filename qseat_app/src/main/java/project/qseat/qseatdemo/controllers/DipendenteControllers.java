package project.qseat.qseatdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.entities.Dipendente;
import project.qseat.qseatdemo.services.DipendenteService;

@RequiredArgsConstructor // mi serve per avere un costruttore di dipendenteService

@RestController
@RequestMapping(value = "/employees")
public class DipendenteControllers {
    // al posto di sviluppare qui i metodi per GET/POST/DELETE
    // faccio in modo che vengano richiamati dai servizi associati alla
    // classe Dipendente, quindi mi serve inizializzare un oggetto relativo
    // ai Service di Dipendente (DipendenteService) e uso RequiredArgsConstructor
    // per inizilizzarlo, da questo posso ottenere tutti i metodi che ho deinito
    private final DipendenteService dipendenteService;

    @GetMapping("/get-all")
    public List<Dipendente> getEmployees() {
        return dipendenteService.findDipendenti();
    }

    @GetMapping("/get-one")
    public Dipendente getEmployee(@RequestParam String email) {
        return dipendenteService.findDipendente(email);
    }


}
