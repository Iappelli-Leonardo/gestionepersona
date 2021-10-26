package it.prova.gestionepersone.service;

import java.util.List;

import it.prova.gestionepersone.dao.PersonaDao;
import it.prova.gestionepersone.model.Persona;



public interface PersonaService {

	// questo mi serve per injection
		public void setPersonaDao(PersonaDao personaDao);

		public List<Persona> listAll() throws Exception;

		public Persona caricaSingoloElemento(Long idInput) throws Exception;

		public void aggiorna(Persona input) throws Exception;

		public void inserisciNuovo(Persona input) throws Exception;

		public void rimuovi(Persona input) throws Exception;

		public List<Persona> findByExample(Persona input) throws Exception;

}
