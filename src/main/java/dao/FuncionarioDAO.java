package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Funcionario;

public class FuncionarioDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {


		if(obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO cliente ");
			sql.append("(Nome,CPF,RG,Usuario,Senha,Endereco,NumCasa,Complemento,Bairro,Cidade,UF,Cep,DtaCadastro,Tel,Cel,Email,Sexo)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst =  conexao.prepareStatement(sql.toString());
			pst.setString(1, f.getNome());
			pst.setString(2, f.getCpf());
			pst.setString(3, f.getRg());
			pst.setString(4, f.getUsuario());
			pst.setString(5, f.getSenha());
			pst.setString(6,f.getEndereco());
			pst.setInt(7, f.getNumCasa());
			pst.setString(8, f.getComplemento());
			pst.setString(9, f.getBairro());
			pst.setString(10, f.getCidade());
			pst.setString(11, f.getUf());
			pst.setInt(12, f.getCep());
			pst.setDate(13,(f.getDtaCadastro()));
			pst.setInt(14, f.getTel());
			pst.setInt(15, f.getCel());
			pst.setString(16, f.getEmail());
			pst.setString(17, f.getSexo());

			pst.executeUpdate();
			pst.close();
		}

	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM funcionario ");
			sql.append("WHERE idFUNC = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, f.getIdFUNC());

			pst.executeUpdate();
			pst.close();
		}

	}

	@Override
	public void editar(Object obj) throws SQLException {

		if(obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;

			String sql = "UPDATE funcionario SET Nome = ?, CPF = ?, RG = ?, Usuario = ?, Senha = ?, Endereco = ?, NumCasa = ?, Complemento = ?, Bairro = ?, Cidade = ?, UF = ?, Cep = ?, DtaCadastro = ?, Tel = ?, Cel = ?, Email = ?, Sexo = ?   WHERE idFUNC = ? ";

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, f.getNome());
			pst.setString(2, f.getCpf());
			pst.setString(3, f.getRg());
			pst.setString(4, f.getUsuario());
			pst.setString(5, f.getSenha());
			pst.setString(6,f.getEndereco());
			pst.setInt(7, f.getNumCasa());
			pst.setString(8, f.getComplemento());
			pst.setString(9, f.getBairro());
			pst.setString(10, f.getCidade());
			pst.setString(11, f.getUf());
			pst.setInt(12, f.getCep());
			pst.setDate(13,(f.getDtaCadastro()));
			pst.setInt(14, f.getTel());
			pst.setInt(15, f.getCel());
			pst.setString(16, f.getEmail());
			pst.setString(17, f.getSexo());
			pst.setInt(18, f.getIdFUNC());

			pst.executeUpdate();
			pst.close();
		}	

	}

	
	public ArrayList<Funcionario> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append("funcionario ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while(rs.next()) {
			Funcionario f = new Funcionario();
			f.setIdFUNC(rs.getInt("idFUNC"));
			f.setNome(rs.getString("Nome"));
			f.setCpf(rs.getString("CPF"));
			f.setRg(rs.getString("RG"));
			f.setUsuario(rs.getString("Usuario"));
			f.setEndereco(rs.getString("Endereco"));
			f.setNumCasa(rs.getInt("NumCasa"));
			f.setComplemento(rs.getString("Complemento"));
			f.setBairro(rs.getString("Bairro"));
			f.setCidade(rs.getString("Cidade"));
			f.setUf(rs.getString("UF"));
			f.setCep(rs.getInt("Cep"));
			f.setDtaCadastro(rs.getDate("DtaCadastro"));
			f.setTel(rs.getInt("Tel"));
			f.setCel(rs.getInt("Cel"));
			f.setEmail(rs.getString("Email"));
			f.setSexo(rs.getString("Sexo"));
			
			lista.add(f);
		}
		return lista;
	}


}
