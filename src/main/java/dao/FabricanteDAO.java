package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoFactory;
import model.Fabricante;

public class FabricanteDAO {

	public void incluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(Nome,CNPJ,Tel,Endereco,Numero,Cidade,Complemento,Bairro,Cep,UF,Email,Obs,Site)");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst =  conexao.prepareStatement(sql.toString());
		pst.setString(1, f.getNome());
		pst.setString(2, f.getCnpj());
		pst.setInt(3, f.getTel());
		pst.setString(4, f.getEndereco());
		pst.setInt(5, f.getNumero());
		pst.setString(6, f.getCidade());
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

	public void deletar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE idFABRI = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql.toString());
		pst.setInt(1, f.getIdFABRI());
		
		pst.executeUpdate();
		pst.close();
	}

	
	
	public void editar(Fabricante f) throws SQLException{
	
		String sql = "UPDATE fabricante SET Nome = ?, CNPJ = ?, Tel = ?, Endereco = ?, Numero = ?, Cidade = ?, Complemento = ?, Bairro = ?, Cep = ?, UF = ?, Email = ?, Obs = ?, Site = ? WHERE idFABRI = ? ";

		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, f.getNome());
		pst.setString(2, f.getCnpj());
		pst.setInt(3, f.getTel());
		pst.setString(4, f.getEndereco());
		pst.setInt(5, f.getNumero());
		pst.setString(6, f.getCidade());
		pst.setString(7,f.getComplemento());
		pst.setString(8, f.getBairro());
		pst.setInt(9, f.getCep());
		pst.setString(10, f.getUf());
		pst.setString(11, f.getEmail());
		pst.setString(12, f.getObs());
		pst.setString(13, f.getSite());
		pst.setInt(14, f.getIdFABRI());
		
		pst.executeUpdate();
		pst.close();
		 
	}
	
	
	

		/*
		public static void main(String[] args) {
		
		Fabricante f1 = new Fabricante();
		
		
		f1.setNome("Leonildo Junior");
		f1.setCnpj("126.433.4343/0001");
		f1.setTel(432423);
		f1.setEndereco("Rua das ruas");
		f1.setNumero(123);
		f1.setCidade("Recife");
		f1.setComplemento("Teste de inclusão");
		f1.setBairro("Água Fria");
		f1.setCep(52121110);
		f1.setUf("lala");
		f1.setEmail("leo.junior2810@gmail.com");
		f1.setObs("teste 123");
		f1.setSite("www.teste.com.br");
		f1.setIdFABRI(1);
		
		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.editar(f1);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar");
			e.printStackTrace();
		}
		
		
		}*/
		/*
		Fabricante f1 = new Fabricante();
		f1.setNome("Leonildo");
		f1.setCnpj("2312342");
		f1.setTel(432423);
		f1.setEndereco("Rua das ruas");
		f1.setNumero(123);
		f1.setCidade("Recife");
		f1.setComplemento("Teste de inclusão");
		f1.setBairro("Água Fria");
		f1.setCep(52121110);
		f1.setUf("lala");
		f1.setObs("teste 123");
		f1.setSite("www.teste.com.br");

		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.incluir(f1);
			System.out.println("Registro incluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir");
			e.printStackTrace();
		}*/
			
			/*
			//Teste para excluir fabricante
			Fabricante f1 = new Fabricante();
			f1.setIdFABRI(1);
			
			FabricanteDAO fdao = new FabricanteDAO();

			try {
				fdao.deletar(f1);
				System.out.println("Registro excluido com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao excluir");
				e.printStackTrace();
			}*/	
			
		





		


		
}
