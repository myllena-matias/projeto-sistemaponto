package br.com.ifpe.sistemaponto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.sistemaponto.util.ConnectionFactory;

public class CargoDao {
	
	private Connection connection;

	public CargoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Cargo cargo) {

		try {
			String sql = "INSERT INTO cargo (nomeCargo, descricao, qtdFunc) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cargo.getNomeCargo());
			stmt.setString(2, cargo.getDescricao());
			stmt.setInt(3, cargo.getQtdFunc());
			
			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cargo> listar() {

		try {
			List<Cargo> listaCargo = new ArrayList<Cargo>();

			String sql = "SELECT * FROM cargo ORDER BY nomeCargo";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cargo cargo = new Cargo();

				cargo.setCodigo_cg(rs.getInt("codigo_cg"));
				cargo.setNomeCargo(rs.getString("nomeCargo"));
				cargo.setDescricao(rs.getString("descricao"));
				cargo.setQtdFunc(rs.getInt("qtdFunc"));

				listaCargo.add(cargo);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaCargo;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Cargo cargo) {

		String sql = "UPDATE cargo SET nomeCargo = ? , descricao = ? WHERE codigo_cg = ?";

		try {

		    PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setString(1, cargo.getNomeCargo());
		    stmt.setString(2, cargo.getDescricao());
		    stmt.setInt(3, cargo.getCodigo_cg());
		    stmt.execute();
		    stmt.close();
		    connection.close();

		} catch (SQLException e) {
		    throw new RuntimeException(e);
		}
	    }

	public void remover(Cargo cargo) {

		try {
			String sql = "DELETE FROM cargo WHERE codigo_cg = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cargo.getCodigo_cg());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
