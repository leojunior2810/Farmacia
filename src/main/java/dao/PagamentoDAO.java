package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Pagamento;

public class PagamentoDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {

		if(obj instanceof Pagamento) {
			Pagamento p = (Pagamento) obj;


			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO pagamento ");
			sql.append("(NomeCliente,ValorTotal,DtVenda,TipoPagamento,Obs,NumeroCheque,NumeroCartao)");
			sql.append("VALUES (?,?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst =  conexao.prepareStatement(sql.toString());
			pst.setString(1, p.getNome());
			pst.setDouble(2, p.getValorTotal());
			pst.setDate(3, p.getDtVenda());
			pst.setString(4, p.getTipoPagamento());
			pst.setString(5, p.getObs());
			pst.setInt(6, p.getnCheque());
			pst.setInt(7, p.getnCartao());

			pst.executeUpdate();
			pst.close();
		}
	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if(obj instanceof Pagamento) {
			Pagamento p = (Pagamento) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM pagamento ");
			sql.append("WHERE idPAG = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, p.getIdPAG());

			pst.executeUpdate();
			pst.close();

		}

	}

	@Override
	public void editar(Object obj) throws SQLException {

		if(obj instanceof Pagamento) {
			Pagamento p = (Pagamento) obj;

			String sql = "UPDATE pagamento SET NomeCliente = ?, ValorTotal = ?, DtVenda = ?, TipoPagamento = ?, Obs = ?, NumeroCheque = ?, NumeroCartao = ? WHERE idFABRI = ? ";


			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, p.getNome());
			pst.setDouble(2, p.getValorTotal());
			pst.setDate(3, p.getDtVenda());
			pst.setString(4, p.getTipoPagamento());
			pst.setString(5, p.getObs());
			pst.setInt(6, p.getnCheque());
			pst.setInt(7, p.getnCartao());
			pst.setInt(8, p.getIdPAG());

			pst.executeUpdate();
			pst.close();
		}		

	}


	public ArrayList<Pagamento> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append("pagamento ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Pagamento> lista = new ArrayList<Pagamento>();

		while(rs.next()) {
			Pagamento p = new Pagamento();
			p.setIdPAG(rs.getInt("idPAG"));
			p.setNome(rs.getString("NomeCliente"));
			p.setValorTotal(rs.getDouble("ValorTotal"));
			p.setDtVenda(rs.getDate("DtVenda"));
			p.setTipoPagamento(rs.getString("TipoPagamento"));
			p.setObs(rs.getString("Obs"));
			p.setnCheque(rs.getInt("NumeroCheque"));
			p.setnCartao(rs.getInt("NumeroCartao"));

			lista.add(p);
		}
		return lista;
	}




}
