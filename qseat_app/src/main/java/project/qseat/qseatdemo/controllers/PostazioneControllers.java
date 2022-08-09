package project.qseat.qseatdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.entities.Postazione;
import project.qseat.qseatdemo.services.PostazioneService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/stations")
public class PostazioneControllers {
    private final PostazioneService postazioneService;
    
    @GetMapping("/get-all")
    public List<Postazione> getPostazioni() {
        return postazioneService.findPostazioni();
    }
}
