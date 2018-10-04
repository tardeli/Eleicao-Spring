package br.com.tardeli.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe que representa um candidato
 * 
 * @author DaRocha
 *
 */
@Entity
public class Candidato implements Validador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoRegistro;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(nullable = false)
	private Long cpf;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partido_cod")
	private Partido partido;
	@Column
	private Cargo cargo;
	
	public Candidato() {

	}

	public Candidato(Integer codigoRegistro, String nome, Long cpf, Partido partido, Cargo cargo) {
		super();
		this.codigoRegistro = codigoRegistro;
		this.nome = nome;
		this.cpf = cpf;
		this.partido = partido;
		this.cargo = cargo;
	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean validarDocumento(Long numero) {
		return numero > 10; // número maior que 10
	}

	@Override
	public String toString() {
		return "Candidato [codigoRegistro=" + codigoRegistro + ", nome=" + nome + ", cpf=" + cpf + ", partido="
				+ partido + ", cargo=" + cargo + "]";
	}
	
}
