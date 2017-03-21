package br.com.ifpe.sistemaponto.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Departamento {
	
	private Integer codigo_dp;
	
	@NotEmpty(message="O nome deve ser preenchido")
	@Size(min = 5, max = 20, message="O nome deve deve ter um tamanho de 20 caracteres")
	private String nomeDepartamento;
	
	@NotEmpty(message="A descrição deve ser preenchida")
	@Size(max = 50, message="A descrição deve deve ter um tamanho máximo de 50 caracteres")
	private String descricao;
	
	private Integer qtdFunc;
	
	
	public Integer getCodigo_dp() {
		return codigo_dp;
	}
	public void setCodigo_dp(Integer codigo_dp) {
		this.codigo_dp = codigo_dp;
	}
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
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
