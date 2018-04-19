package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Fabricante;

public class FabricanteDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {

		if(obj instanceof Fabricante) {
			Fabricante f = (Fabricante) obj;


			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO fabricante ");
			sql.append("(Nome,CNPJ,Tel,Endereco,Numero,Cidade,Complemento,Bairro,Cep,UF,Email,Obs,Site)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

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
	}
	
	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof Fabricante) {
			Fabricante f = (Fabricante) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM fabricante ");
			sql.append("WHERE idFABRI = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, f.getIdFABRI());

			pst.executeUpdate();
			pst.close();

		}
	}


	@Override
	public void editar(Object obj) throws SQLException{
		
		if(obj instanceof Fabricante) {
			Fabricante f = (Fabricante) obj;
		
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
	}


	public ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append("fabricante ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while(rs.next()) {
			Fabricante f = new Fabricante();
			f.setIdFABRI(rs.getInt("idFABRI"));
			f.setNome(rs.getString("Nome"));
			f.setCnpj(rs.getString("CNPJ"));
			f.setTel(rs.getInt("Tel"));
			f.setEndereco(rs.getString("Endereco"));
			f.setNumero(rs.getInt("Numero"));
			f.setCidade(rs.getString("Cidade"));
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










	/*
	public static void main(String[] args) {

		FabricanteDAO fdao = new FabricanteDAO();
		try {
		ArrayList<Fabricante> lista = fdao.listar();

		for(Fabricante f: lista) {
			System.out.println("Resultado: " + f);
		}
		}catch(SQLException e) {
			System.out.println("Erro ao listar");
			e.printStackTrace();
		}
	}*/



	
		/*public static void main(String[] args) {

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

		}
*/

	
	public static void main(String[] args) {


		Fabricante f1 = new Fabricante();
		f1.setNome("Leonildo");
		f1.setCnpj("454545454");
		f1.setTel(333333);
		f1.setEndereco("Rua do cajueiro");
		f1.setNumero(1545);
		f1.setCidade("Olinda");
		f1.setComplemento("Teste de inclusão 2223");
		f1.setBairro("Cajueiro");
		f1.setCep(52121123);
		f1.setUf("nanana");
		f1.setEmail("validar@gmail.com");
		f1.setObs("obs de teste de inclusão");
		f1.setSite("www.aaaaa.com.br");

		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.incluir(f1);
			System.out.println("Registro incluido com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao incluir");
			e.printStackTrace();
		}

	}

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
			}
*/










}
