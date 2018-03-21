package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoFactory;
import model.Cliente;

public class ClienteDAO {

	
	public void incluir(Cliente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente ");
		sql.append("(Nome,DtaNasc,CPF,RG,Tel,Cel,Endereco,NumCasa,Complemento,Bairro,Cidade,Cep,UF,Sexo,Email,DtaCadastro)");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst =  conexao.prepareStatement(sql.toString());
		pst.setString(1, c.getNome());
		pst.setDate(2, new java.sql.Date(c.getDta_nasc().getDate()));
		pst.setString(3, c.getCpf());
		pst.setString(4, c.getRg());
		pst.setInt(5, c.getTel());
		pst.setInt(6, c.getCel());
		pst.setString(7,c.getEndereco());
		pst.setInt(8, c.getNumCasa());
		pst.setString(9, c.getComplemento());
		pst.setString(10, c.getBairro());
		pst.setString(11, c.getCidade());
		pst.setInt(12, c.getCep());
		pst.setString(13, c.getUf());
		pst.setString(14, c.getSexo());
		pst.setString(15, c.getEmail());
		pst.setDate(16, new java.sql.Date(c.getDtaCadastro().getDate()));

		pst.executeUpdate();
		pst.close();

	}
	
	
	
	
	public static void main(String[] args) {
		
		
		Cliente c1 = new Cliente();
		c1.setNome("Leonildo");
		c1.setDta_nasc(10/10/2018);

		ClienteDAO cdao = new ClienteDAO();

		try {
			cdao.incluir(c1);
			System.out.println("Registro incluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
