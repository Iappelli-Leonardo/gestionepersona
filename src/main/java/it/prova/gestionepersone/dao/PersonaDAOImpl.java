package it.prova.gestionepersone.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepersone.model.Persona;


public class PersonaDAOImpl implements PersonaDao {

	private EntityManager entityManager;

	@Override
	public List<Persona> list() throws Exception {
		return entityManager.createQuery("from Persona", Persona.class).getResultList();
	}

	@Override
	public Persona findOne(Long id) throws Exception {
		return entityManager.find(Persona.class, id);
	}

	@Override
	public void update(Persona input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Persona input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Persona input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
