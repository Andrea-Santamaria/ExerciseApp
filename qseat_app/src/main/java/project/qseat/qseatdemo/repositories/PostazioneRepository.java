package project.qseat.qseatdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.qseat.qseatdemo.model.entities.Postazione;

public interface PostazioneRepository extends JpaRepository<Postazione, String>{
    
}
