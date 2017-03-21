package br.com.ifpe.sistemaponto.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Funcionario {

	    private int id;
	    private String nome;
	    private String email;
	    
	    @NotEmpty(message="O login deve ser preenchido")
	    @Size(min = 5, max = 13, message="O login deve deve ter um tamanho de 5 a 13 caracteres")
	    private String login;
	    
	    @NotEmpty(message="A senha deve ser preenchida")
	    @Size(min = 5, max = 5, message="A senha deve deve ter um tamanho de 5 caracteres")
	    private String senha;
	    
	    private Cargo cargo;
	    private Departamento departamento;
		private String imagem;


		
	    public int getId() {
		return id;
	    }

	    public void setId(int id) {
		this.id = id;
	    }

	    public String getNome() {
		return nome;
	    }

	    public void setNome(String nome) {
		this.nome = nome;
	    }

	    public String getEmail() {
		return email;
	    }

	    public void setEmail(String email) {
		this.email = email;
	    }

	    public String getLogin() {
		return login;
	    }

	    public void setLogin(String login) {
		this.login = login;
	    }

	    public String getSenha() {
		return senha;
	    }

	    public void setSenha(String senha) {
		this.senha = senha;
	    }
	    
	    public Cargo getCargo() {
			return cargo;
		}

		public void setCargo(Cargo cargo) {
			this.cargo = cargo;
		}
		
		public Departamento getDepartamento() {
			return departamento;
		}

		public void setDepartamento(Departamento departamento) {
			this.departamento = departamento;
		}
			    
		public String getImagem() {
			return imagem;
		}
		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public int getCargogetId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getDepartamentogetId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setCargogetId(String string) {
			// TODO Auto-generated method stub
			
		}

		public void setDepartamentogetId(String string) {
			// TODO Auto-generated method stub
			
		}

		
	}
