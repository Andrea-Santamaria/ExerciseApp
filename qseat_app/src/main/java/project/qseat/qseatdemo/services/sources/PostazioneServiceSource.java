package project.qseat.qseatdemo.services.sources;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import project.qseat.qseatdemo.model.entities.Postazione;
import project.qseat.qseatdemo.repositories.PostazioneRepository;
import project.qseat.qseatdemo.services.PostazioneService;

@Component
@RequiredArgsConstructor
public class PostazioneServiceSource implements PostazioneService{
    private final PostazioneRepository repo;
    
    @Override
    public List<Postazione> findPostazioni() {
        return repo.findAll();
    }
}
