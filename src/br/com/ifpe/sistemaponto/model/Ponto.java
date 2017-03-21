package br.com.ifpe.sistemaponto.model;

public class Ponto extends Funcionario {
	private FilaPrioridade fp_entrada;
	private FilaPrioridade fp_saida;
	public Ponto(){
		fp_entrada = new FilaPrioridade(50);
		fp_saida = new FilaPrioridade(50);
	}
	public long getEntrada() {
		return fp_entrada.peek();
	}
	public void setEntrada(long entrada) {
		this.fp_entrada.inserir(entrada);
	}
	public long getSaida() {
		return fp_saida.peek();
	}
	public void setSaida(long saida) {
		this.fp_saida.inserir(saida);
	}
	
	

}
