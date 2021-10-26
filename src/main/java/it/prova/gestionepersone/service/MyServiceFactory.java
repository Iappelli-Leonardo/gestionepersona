package it.prova.gestionepersone.service;

import it.prova.gestionepersone.dao.PersonaDAOImpl;
import it.prova.gestionepersone.dao.PersonaDao;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static PersonaService PERSONA_SERVICE_INSTANCE = null;
	private static PersonaDao PERSONADAO_INSTANCE = null;

	public static PersonaService getPersonaServiceInstance() {
		if (PERSONA_SERVICE_INSTANCE == null)
			PERSONA_SERVICE_INSTANCE = new PersonaServiceImpl();

		if (PERSONADAO_INSTANCE == null)
			PERSONADAO_INSTANCE = new PersonaDAOImpl();

		PERSONA_SERVICE_INSTANCE.setPersonaDao(PERSONADAO_INSTANCE);

		return PERSONA_SERVICE_INSTANCE;
	}

}
