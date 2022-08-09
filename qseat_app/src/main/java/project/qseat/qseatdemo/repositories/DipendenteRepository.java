package project.qseat.qseatdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.qseat.qseatdemo.model.entities.Dipendente;

// ogni repository è un'estensione di qualcosa, in questo caso la classe
// Dipendente è normale (una sola key) e quindi userò la JpaRepository a cui passo
// il type della classe (Dipendente) e il type della sua primary key (String)
public interface DipendenteRepository extends JpaRepository<Dipendente, String> {
    // qui posso dichiarare tutti i metodi che voglio, lo tratto come header.h
    // le funzioni che dichiaro qui verranno poi usate nei SERVIZI

    // il metodo findAll esiste già

    // voglio un find per trovare il dipendente se passo in ingresso la mail
    // di default esiste il findById che però è un po' generico
    Dipendente findByEmail(String email);
}
