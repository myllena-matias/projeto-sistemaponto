package br.com.ifpe.sistemaponto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.sistemaponto.util.ConnectionFactory;

public class FuncionarioDao {

	 private Connection connection;

	    public FuncionarioDao() {

		try {
		    this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }
	    
	    public Funcionario buscarFuncionario(Funcionario funcionario) {
	    	try {
	    	Funcionario funcionarioConsultado = null;
	    	PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario where login = ? and senha = ?");
	    	stmt.setString(1, funcionario.getLogin());
	    	stmt.setString(2, funcionario.getSenha());
	    	ResultSet rs = stmt.executeQuery();
	    	
	    	if (rs.next()) {
	    	funcionarioConsultado = montarObjeto(rs);
	    	}
	    	
	    	rs.close();
	    	stmt.close();
	    	
	    	return funcionarioConsultado;
	    	} catch (SQLException e) {
	    	throw new RuntimeException(e);
	    	}
	    	}

	    public void salvar(Funcionario funcionario) {

		try {

		    String sql = "INSERT INTO funcionario (nome, email, login, senha, nomeCargo, nomeDepartamento, imagem) VALUES (?,?,?,?,?,?,?)";
		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setString(1, funcionario.getNome());
		    stmt.setString(2, funcionario.getEmail());
		    stmt.setString(3, funcionario.getLogin());
		    stmt.setString(4, funcionario.getSenha());
		    stmt.setInt(5, funcionario.getCargogetId());
		    stmt.setInt(6, funcionario.getDepartamentogetId());
			stmt.setString(7, funcionario.getImagem());

		    stmt.execute();
		    stmt.close();
		    connection.close();

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public List<Funcionario> listar() {

		try {
		    List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM funcionario ORDER BY nome");

		    ResultSet rs = stmt.executeQuery();

		    while (rs.next()) {
			listaFuncionario.add(montarObjeto(rs));
		    }

		    rs.close();
		    stmt.close();
		    connection.close();

		    return listaFuncionario;

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public void remover(Funcionario funcionario) {

		try {
		    PreparedStatement stmt = connection.prepareStatement("DELETE FROM funcionario WHERE id = ?");
		    stmt.setLong(1, funcionario.getId());
		    stmt.execute();
		    stmt.close();
		    connection.close();
		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public Funcionario buscarPorId(int id) {

		try {
		    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
		    stmt.setInt(1, id);
		    ResultSet rs = stmt.executeQuery();

		    Funcionario funcionario = null;
		    if (rs.next()) {
		    funcionario = montarObjeto(rs);
		    }

		    rs.close();
		    stmt.close();
		    connection.close();
		    return funcionario;

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public void alterar(Funcionario funcionario) {

		String sql = "UPDATE funcionario SET nome = ? , email = ? , login = ? , senha = ? , nomeCargo = ? , nomeDepartamento = ? WHERE id = ?";

		try {

		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setString(1, funcionario.getNome());
		    stmt.setString(2, funcionario.getEmail());
		    stmt.setString(3, funcionario.getLogin());
		    stmt.setString(4, funcionario.getSenha());
		    stmt.setInt(5, funcionario.getCargogetId());
		    stmt.setInt(6,  funcionario.getDepartamentogetId());
		    stmt.setInt(7, funcionario.getId());
		   
		    stmt.execute();
		    stmt.close();
		    connection.close();

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	    private Funcionario montarObjeto(ResultSet rs) throws SQLException {

	    Funcionario funcionario = new Funcionario();
	    funcionario.setId(rs.getInt("id"));
	    funcionario.setNome(rs.getString("nome"));
	    funcionario.setEmail(rs.getString("email"));
	    funcionario.setLogin(rs.getString("login"));
	    funcionario.setSenha(rs.getString("senha"));
	    funcionario.setCargogetId(rs.getString("nomeCargo"));
	    funcionario.setDepartamentogetId(rs.getString("nomeDepartamento"));
		funcionario.setImagem(rs.getString("imagem"));


		return funcionario;
	    }
	}
