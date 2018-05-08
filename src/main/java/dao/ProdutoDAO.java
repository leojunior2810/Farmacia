package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Produto;

public class ProdutoDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {
		if(obj instanceof Produto) {
			Produto p = (Produto) obj;


			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO produto ");
			sql.append("(Nome,DataProd,Descricao,Qtde,ValorUnitario,ValorFinal,Obs,Origem,Bula)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst =  conexao.prepareStatement(sql.toString());
			pst.setString(1, p.getNome());
			pst.setDate(2, new Date(p.getDataProd().getTime()));
			pst.setString(3, p.getDescricao());
			pst.setInt(4, p.getQtde());
			pst.setDouble(5, p.getValorUni());
			pst.setDouble(6, p.getValorFinal());
			pst.setString(7, p.getObs());
			pst.setString(8, p.getOrigem());
			pst.setString(9, p.getBula());
			
			pst.executeUpdate();
			pst.close();
		}
		
	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof Produto) {
			Produto p = (Produto) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM produto ");
			sql.append("WHERE idPROD = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, p.getIdPROD());

			pst.executeUpdate();
			pst.close();

		}
		
		
	}

	@Override
	public void editar(Object obj) throws SQLException {

		if(obj instanceof Produto) {
			Produto p = (Produto) obj;
		
		String sql = "UPDATE produto SET Nome = ?, DataProd = ?, Descricao = ?, Qtde = ?, ValorUnitario = ?, ValorFinal = ?, Obs = ?, Origem = ?, Bula = ? WHERE idPROD = ? ";
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, p.getNome());
		pst.setDate(2, p.getDataProd());
		pst.setString(3, p.getDescricao());
		pst.setInt(4, p.getQtde());
		pst.setDouble(5, p.getValorUni());
		pst.setDouble(6, p.getValorFinal());
		pst.setString(7, p.getObs());
		pst.setString(8, p.getOrigem());
		pst.setString(9, p.getBula());
		pst.setInt(10, p.getIdPROD());

		pst.executeUpdate();
		pst.close();
		}
	}
	
	
	public ArrayList<Produto> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append("produto ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while(rs.next()) {
			Produto p = new Produto();
			p.setIdPROD(rs.getInt("idPROD"));
			p.setDataProd(rs.getDate("DataProd"));
			p.setDescricao(rs.getString("Descricao"));
			p.setQtde(rs.getInt("Qtde"));
			p.setValorUni(rs.getDouble("ValorUnitario"));
			p.setValorFinal(rs.getDouble("ValorFinal"));
			p.setObs(rs.getString("Obs"));
			p.setOrigem(rs.getString("Origem"));
			p.setBula(rs.getString("Bula"));

			lista.add(p);
		}
		return lista;
	}

}
