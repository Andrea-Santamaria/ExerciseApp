package project.qseat.qseatdemo.services;

import java.util.List;

import project.qseat.qseatdemo.model.entities.Dipendente;

// in questa INTERFACE (ogni servizio è una interface!!!) mi è stato richiesto
// di DEFINIRE due metodi per la ricerca del personale
public interface DipendenteService {

    // qui si DICHIARANO i metodi/servizi disponibili, che poi verranno 
    // richiamati nei controllers  per essere utilizzati

    // il primo vuole tutti i dipendenti che sono ancora dentro Quantyca
    List<Dipendente> findDipendenti();

    // il secondo filtro sulla mail
    Dipendente findDipendente(String Email);
}
