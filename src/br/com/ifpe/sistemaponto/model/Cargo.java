package br.com.ifpe.sistemaponto.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Cargo {
	
	private Integer codigo_cg;
	
	@NotEmpty(message="O nome deve ser preenchido")
	@Size(min = 5, max = 20, message="O nome deve deve ter um tamanho de 20 caracteres")
	private String nomeCargo;
	
	@NotEmpty(message="A descrição deve ser preenchida")
	@Size(max = 50, message="A descrição deve deve ter um tamanho máximo de 50 caracteres")
	private String descricao;
	
	private Integer qtdFunc;
	
		
	public Integer getCodigo_cg() {
		return codigo_cg;
	}
	public void setCodigo_cg(Integer codigo_cg) {
		this.codigo_cg = codigo_cg;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQtdFunc() {
		return qtdFunc;
	}
	public void setQtdFunc(Integer qtdFunc) {
		this.qtdFunc = qtdFunc;
	}

}
