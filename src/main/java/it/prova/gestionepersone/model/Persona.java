package it.prova.gestionepersone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "altezza")
	private Integer altezza;

	@Column(name = "dataNascita")
	private Date dataNascita;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public Persona(String nome, String cognome, Integer altezza, Date dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.altezza = altezza;
		this.dataNascita = dataNascita;
	}

	public Persona(Long id, String nome, String cognome, Integer altezza, Date dataNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.altezza = altezza;
		this.dataNascita = dataNascita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getAltezza() {
		return altezza;
	}

	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", altezza=" + altezza
				+ ", dataNascita=" + dataNascita + "]";
	}

}
