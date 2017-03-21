package br.com.ifpe.sistemaponto.model;

public class FilaPrioridade {
	
	private int tamanho;
	private long[] vetorFila;
	private int itens;
	public FilaPrioridade(int s){
	tamanho = s;
	vetorFila = new long[tamanho];
	itens = 0;
	}
	public long remover(){ 
	return vetorFila[itens];
	}
	public long peek(){ 
	return vetorFila[itens-1];
	}
	public boolean estaVazia(){ 
	return (itens==0); }
	public boolean estaCheia(){ 
	return (itens==tamanho); }
	public void inserir(long elemento){
		int i;
		if (itens==0)
		vetorFila[itens++] = elemento;
	else{
		for (i=itens-1;i>=0; i--){
	if (elemento > vetorFila[i])
		vetorFila[i+1] = vetorFila[i];
	else
	break;
	}
	vetorFila[i+1] = elemento;
	itens++;
	}
  }
	public void imprimir(Ponto ponto){
		   for (int i=itens; i<=tamanho; i++)
			   System.out.println(vetorFila[i]+" ");
	   }

}
