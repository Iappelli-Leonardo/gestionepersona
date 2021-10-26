package it.prova.gestionepersone.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepersone.dao.PersonaDao;
import it.prova.gestionepersone.model.Persona;
import it.prova.gestionepersone.web.listener.LocalEntityManagerFactoryListener;


public class PersonaServiceImpl implements PersonaService {

	private PersonaDao personaDao;

	@Override
	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;

	}

	@Override
	public List<Persona> listAll() throws Exception {
		// questo è come una connection
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

				try {
					// uso l'injection per il dao
					personaDao.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return personaDao.list();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}
	}

	@Override
	public Persona caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

				try {
					// uso l'injection per il dao
					personaDao.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return personaDao.findOne(idInput);

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}
	}

	@Override
	public void aggiorna(Persona input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			personaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			personaDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Persona input) throws Exception {
		// questo è come una connection
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					personaDao.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					personaDao.insert(input);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}

	}

	@Override
	public void rimuovi(Persona input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			personaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			personaDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Persona> findByExample(Persona input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
