package br.com.ifpe.sistemaponto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.sistemaponto.util.ConnectionFactory;

public class DepartamentoDao {

	private Connection connection;

	public DepartamentoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Departamento departamento) {

		try {
			String sql = "INSERT INTO departamento (nomeDepartamento, descricao, qtdFunc) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, departamento.getNomeDepartamento());
			stmt.setString(2, departamento.getDescricao());
			stmt.setInt(3, departamento.getQtdFunc());
			
			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Departamento> listar() {

		try {
			List<Departamento> listaDepartamento = new ArrayList<Departamento>();

			String sql = "SELECT * FROM departamento ORDER BY nomeDepartamento";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Departamento departamento = new Departamento();

				departamento.setCodigo_dp(rs.getInt("codigo_dp"));
				departamento.setNomeDepartamento(rs.getString("nomeDepartamento"));
				departamento.setDescricao(rs.getString("descricao"));
				departamento.setQtdFunc(rs.getInt("qtdFunc"));
				
				listaDepartamento.add(departamento);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaDepartamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Departamento departamento) {

		String sql = "UPDATE departamento SET nomeDepartamento = ? , descricao = ? WHERE codigo_dp = ?";

		try {

		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setString(1, departamento.getNomeDepartamento());
		    stmt.setString(2, departamento.getDescricao());
		    stmt.setInt(3, departamento.getCodigo_dp());
		    stmt.execute();
		    stmt.close();
		    connection.close();

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	public void remover(Departamento departamento) {

		try {
			String sql = "DELETE FROM departamento WHERE codigo_dp = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, departamento.getCodigo_dp());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
