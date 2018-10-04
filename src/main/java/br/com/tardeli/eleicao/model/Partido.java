package br.com.tardeli.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um partido
 * 
 * @author DaRocha
 *
 */
@Entity
public class Partido {
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	@Column(length = 30, nullable = false)
	private String nome;
	@Column(length = 10, nullable = false)
	private String sigla;
		
	public Partido() {
		super();
	}

	public Partido(Integer codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Partido [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
}
