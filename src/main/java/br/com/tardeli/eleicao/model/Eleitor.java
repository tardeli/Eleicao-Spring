package br.com.tardeli.eleicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe que representa um Eleitor
 * 
 * @author DaRocha
 *
 */
@Entity
public class Eleitor implements Validador {
	@Id
	private Long numeroTitulo;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 40, nullable = false)
	private String nomeMae;
	@Column(nullable = false)
	private Short zonaEleitoral;
	@Column(nullable = false)
	private Short secao;
	

	public Eleitor() {
		super();
	}

	public Eleitor(Long numeroTitulo, String nome, String nomeMae, Short zonaEleitoral, Short secao) {
		super();
		this.numeroTitulo = numeroTitulo;
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.zonaEleitoral = zonaEleitoral;
		this.secao = secao;
	}

	public Long getNumeroTitulo() {
		return numeroTitulo;
	}
	
	public void setNumeroTitulo(Long numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Short getZonaEleitoral() {
		return zonaEleitoral;
	}

	public void setZonaEleitoral(Short zonaEleitoral) {
		this.zonaEleitoral = zonaEleitoral;
	}

	public Short getSecao() {
		return secao;
	}

	public void setSecao(Short secao) {
		this.secao = secao;
	}

	@Override
	public boolean validarDocumento(Long numero) {
		return numero > 100;
	}

	@Override
	public String toString() {
		return "Eleitor [numeroTitulo=" + numeroTitulo + ", nome=" + nome + ", nomeMae=" + nomeMae + ", zonaEleitoral="
				+ zonaEleitoral + ", secao=" + secao + "]";
	}
}
