package br.com.ifpe.sistemaponto.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class PontoEletronico {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		PontoEletronico pontoeletronico = new PontoEletronico();
				List<Funcionario> lista = pontoeletronico.carregaFuncionarios();
				Scanner sc = new Scanner(System.in);
				Ponto ponto = new Ponto();

		// =============================================================
		
				Date data = Calendar.getInstance().getTime();
				SimpleDateFormat dft = new SimpleDateFormat("HH:mm");
				dft = new SimpleDateFormat("dd/MM/yyyy");
		
				String data_atual = dft.format(data);
				System.out.println("---- SISTEMA DE PONTO");
				System.out.println("DATA ATUAL:" + data_atual);

		// =============================================================

				dft = new SimpleDateFormat("HH");
				String hora_atual = dft.format(data);
				int h = Integer.parseInt(hora_atual);
				String nome;
				for(int j = 0; j<= 3;j++){
					
					if (h >= 7 && h <= 8) {
						System.out.println("REGISTRO DE ENTRADA");
			
						do {
							System.out.println("Informe o nome:");
				nome = sc.nextLine();
			
						} while (pontoeletronico.verificarNome(nome, lista) == false);
						ponto.setEntrada(data.getTime());
		
		//Date novadata = new Date(pt.getEntrada());
		}
					if (h >8) {
					System.out.println("REGISTRO DA SAIDA");
					do {
						System.out.println("Informe o nome:");
						nome = sc.nextLine();
					} while (pontoeletronico.verificarNome(nome, lista) == false);
					if(data != null)
						ponto.setSaida(data.getTime());
					else
						System.out.println("Data Nula");

			//Date novadata = new Date(pt.getSaida());
		}
	}
		// ===========================================================

	}
				private boolean verificarNome(String nome, List<Funcionario> lista) {
					// TODO Auto-generated method stub
					return false;
				}
				
	
				private List<Funcionario> carregaFuncionarios() {
				List<Funcionario> lista = new ArrayList<Funcionario>();
				String nomes[] = { "Maicon Silva", "Maria Lucia", "Isidoro Ferreira" };
				String logins[] = { "maicon.silva", "maria.lucia", "isidoro.ferreira" };
				for (int i = 0; i < logins.length; i++) {
					Funcionario funcionario = new Funcionario();
					funcionario.setNome(nomes[i]);
					funcionario.setLogin(logins[i]);
					lista.add(funcionario);
				}
				return lista;
			}

		// =============================================================
	
			@SuppressWarnings("unused")
			private boolean verificarLogin(String login, List<Funcionario> lista) {
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getLogin().equals(login)) {
						return true;
					}
				}
				System.out.println("Login INCORRETO");
				return false;
			}
				@SuppressWarnings("unused")
				private void imprimir(Ponto pt){
				}
				@SuppressWarnings("unused")
				private void MaiorMenor(){
				}

		// ================================================================

}
