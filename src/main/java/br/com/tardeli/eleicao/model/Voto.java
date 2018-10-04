package br.com.tardeli.eleicao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;;

/**
 * Classe que representa os votos
 * 
 * @author DaRocha
 *
 */
@Entity
@Table(name = "Voto")
public class Voto {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Column(nullable = false)
	private Long urna;
	@ManyToOne
    @JoinColumn(name = "candidato_cod")
	private Candidato candidato;
	@ManyToOne
    @JoinColumn(name = "eleitor_cod")
	private Eleitor eleitor;
	
	
	public Voto() {
		
	}

	public Voto(Long codigo, Date data, Long urna, Candidato candidato, Eleitor eleitor) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.urna = urna;
		this.candidato = candidato;
		this.eleitor = eleitor;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getUrna() {
		return urna;
	}

	public void setUrna(Long urna) {
		this.urna = urna;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	@Override
	public String toString() {
		return "Voto [codigo=" + codigo + ", data=" + data + ", urna=" + urna + ", candidato=" + candidato
				+ ", eleitor=" + eleitor + "]";
	}

}
