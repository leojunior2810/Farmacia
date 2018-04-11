package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoFactory;
import model.Fabricante;
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
		
		
	}

	
	
	
}
