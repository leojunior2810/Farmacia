package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.Venda;

public class VendaDAO extends BasicDAO {

	@Override
	public void incluir(Object obj) throws SQLException {

		if (obj instanceof Venda) {
			Venda v = (Venda) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO venda ");
			sql.append(
					"(DataVenda,DataVenc,DataPgto,Obs,Iof,Icms,Ipi,CLIENTE_idCLIENTE,FUNCIONARIO_idFUNC,PAGAMENTO_idPAG)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setDate(1, v.getDataVenda());
			pst.setString(2, v.getDataVenc());
			pst.setString(3, v.getDataPgto());
			pst.setString(4, v.getObs());
			pst.setDouble(5, v.getIof());
			pst.setDouble(6, v.getIcms());
			pst.setDouble(7, v.getIpi());
			pst.setInt(8, v.getIdCliente());
			pst.setInt(9, v.getIdFuncionario());
			pst.setInt(10, v.getIdPagamento());

			pst.executeUpdate();
			pst.close();
		}

	}

	@Override
	public void deletar(Object obj) throws SQLException {

		if (obj instanceof Venda) {
			Venda v = (Venda) obj;

			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM venda ");
			sql.append("WHERE idVENDA = ? ");

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql.toString());
			pst.setInt(1, v.getIdVENDA());

			pst.executeUpdate();
			pst.close();

		}

	}

	@Override
	public void editar(Object obj) throws SQLException {

		if (obj instanceof Venda) {
			Venda v = (Venda) obj;

			String sql = "UPDATE venda SET DataVenda = ?, DataVenc = ?, DataPgto = ?, Obs = ?, Iof = ?, Icms = ?, Ipi = ? WHERE idVENDA = ? ";

			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setDate(1, v.getDataVenda());
			pst.setString(2, v.getDataVenc());
			pst.setString(3, v.getDataPgto());
			pst.setString(4, v.getObs());
			pst.setDouble(5, v.getIof());
			pst.setDouble(6, v.getIcms());
			pst.setDouble(7, v.getIpi());
			pst.setInt(8, v.getIdVENDA());

			pst.executeUpdate();
			pst.close();
		}
	}

	public ArrayList<Venda> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT venda.*, cliente.Nome as NomeCliente ,funcionario.Nome as NomeFuncionario,pagamento.ValorTotal FROM venda ");
		sql.append("inner join cliente on venda.CLIENTE_idCLIENTE=cliente.idCLIENTE " );
		sql.append("inner join funcionario on funcionario.idFUNC=venda.FUNCIONARIO_idFUNC " );
		sql.append("inner join pagamento on pagamento.idPAG=venda.PAGAMENTO_idPAG " );

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement pst = conexao.prepareStatement(sql.toString());

		ResultSet rs = pst.executeQuery();

		ArrayList<Venda> lista = new ArrayList<Venda>();

		while (rs.next()) {
			Venda v = new Venda();
			v.setIdVENDA(rs.getInt("idVENDA"));
			v.setDataVenda(rs.getDate("DataVenda"));
			v.setDataVenc(rs.getString("DataVenc"));
			v.setDataPgto(rs.getString("DataPgto"));
			v.setObs(rs.getString("Obs"));
			v.setIof(rs.getDouble("Iof"));
			v.setIcms(rs.getDouble("Icms"));
			v.setIpi(rs.getDouble("Ipi"));
			v.setNomeCliente(rs.getString("NomeCliente"));
			v.setNomeFuncionario(rs.getString("NomeFuncionario"));
			v.setValorVenda(rs.getDouble("ValorTotal"));
			
			lista.add(v);
		}
		return lista;
	}

}
