package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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



}
