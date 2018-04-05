package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import factory.ConexaoFactory;
import model.Cliente;


public class ClienteDAO extends BasicDAO {

	
	public void incluir(Cliente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente ");
		sql.append("(Nome,DtaNasc,CPF,RG,Tel,Cel,Endereco,NumCasa,Complemento,Bairro,Cidade,Cep,UF,Sexo,Email,DtaCadastro,EstadoCivil)");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst =  conexao.prepareStatement(sql.toString());
		pst.setString(1, c.getNome());
		pst.setString(2, c.getDta_nasc());
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
		pst.setDate(16,(c.getDtaCadastro()));
		pst.setString(17, c.getEstadoCivil());
		pst.executeUpdate();
		pst.close();

	}
	
	public void deletar(Cliente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE idCLIENTE = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setInt(1, c.getIdCLIENTE());

		pst.executeUpdate();
		pst.close();
	}
	

	@Override
	public void editar(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		Cliente c1 = new Cliente();
		c1.setNome("Leonildo");
		c1.setDta_nasc("28/10/1993");
		c1.setCpf("10609554409");
		c1.setRg("8849979");
		c1.setTel(12345546);
		c1.setCel(231432432);
		c1.setEndereco("Rua das ruas");
		c1.setNumCasa(123);
		c1.setComplemento("teste");
		c1.setBairro("Água Fria");
		c1.setCidade("Recife");
		c1.setCep(52121110);
		c1.setUf("PE");
		c1.setSexo("Masculino");
		c1.setEmail("leo.junior2810@gmail.com");
		
		c1.setDtaCadastro(new Date(Calendar.getInstance().getTime().getTime()));
		c1.setEstadoCivil("Casado");
		ClienteDAO cdao = new ClienteDAO();

		try {
			cdao.incluir(c1);
			System.out.println("Registro incluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir");
			e.printStackTrace();
		}
		
	}

	@Override
	public void incluir(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
