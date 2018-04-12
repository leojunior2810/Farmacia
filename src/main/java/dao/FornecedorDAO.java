package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Fornecedor;

public class FornecedorDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {
		if(obj instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) obj;


			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO fornecedor ");
			sql.append("(Nome,CNPJ,Tel,Endereco,Cidade,Numero,Complemento,Bairro,Cep,UF,Email,Obs,Site)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst =  conexao.prepareStatement(sql.toString());
			pst.setString(1, f.getNome());
			pst.setString(2, f.getCnpj());
			pst.setInt(3, f.getTel());
			pst.setString(4, f.getEndereco());
			pst.setString(5, f.getCidade());
			pst.setInt(6, f.getNumero());
			pst.setString(7,f.getComplemento());
			pst.setString(8, f.getBairro());
			pst.setInt(9, f.getCep());
			pst.setString(10, f.getUf());
			pst.setString(11, f.getEmail());
			pst.setString(12, f.getObs());
			pst.setString(13, f.getSite());

			pst.executeUpdate();
			pst.close();
		}


	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM fornecedor ");
			sql.append("WHERE idFORNE = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, f.getIdFORNE());

			pst.executeUpdate();
			pst.close();

		}

	}

	@Override
	public void editar(Object obj) throws SQLException {

		if(obj instanceof Fornecedor) {
			Fornecedor f = (Fornecedor) obj;

			String sql = "UPDATE Fornecedor SET Nome = ?, CNPJ = ?, Tel = ?, Endereco = ?, Cidade = ?, Numero = ?, Complemento = ?, Bairro = ?, Cep = ?, UF = ?, Email = ?, Obs = ?, Site = ? WHERE idFABRI = ? ";


			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, f.getNome());
			pst.setString(2, f.getCnpj());
			pst.setInt(3, f.getTel());
			pst.setString(4, f.getEndereco());
			pst.setString(5, f.getCidade());
			pst.setInt(6, f.getNumero());
			pst.setString(7,f.getComplemento());
			pst.setString(8, f.getBairro());
			pst.setInt(9, f.getCep());
			pst.setString(10, f.getUf());
			pst.setString(11, f.getEmail());
			pst.setString(12, f.getObs());
			pst.setString(13, f.getSite());
			pst.setInt(14, f.getIdFORNE());

			pst.executeUpdate();
			pst.close();
		}		
	}

	
	public ArrayList<Fornecedor> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append("fornecedor ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();

		while(rs.next()) {
			Fornecedor f = new Fornecedor();
			f.setIdFORNE(rs.getInt("idFABRI"));
			f.setNome(rs.getString("Nome"));
			f.setCnpj(rs.getString("CNPJ"));
			f.setTel(rs.getInt("Tel"));
			f.setEndereco(rs.getString("Endereco"));
			f.setCidade(rs.getString("Cidade"));
			f.setNumero(rs.getInt("Numero"));
			f.setComplemento(rs.getString("Complemento"));
			f.setBairro(rs.getString("Bairro"));
			f.setCep(rs.getInt("Cep"));
			f.setUf(rs.getString("UF"));
			f.setEmail(rs.getString("Email"));
			f.setObs(rs.getString("Obs"));
			f.setSite(rs.getString("Site"));
			
			lista.add(f);
		}
		return lista;
	}
	
	


}
