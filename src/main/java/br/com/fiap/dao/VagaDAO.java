package br.com.fiap.dao;

import br.com.fiap.beans.Vaga;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {
    public Connection minhaConexao;

    public VagaDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Vaga vaga) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Insert into T_GS_VAGA (ID_VAGA, TITULO, DESCRICAO, NIVEL) values (SEQ_GS_VAGA.NEXTVAL, ?, ?, ?)");
        stmt.setString(1, vaga.getTitulo());
        stmt.setString(2, vaga.getDescricao());
        stmt.setString(3, vaga.getNivel());
        stmt.execute();
        stmt.close();
        return "Vaga cadastrada com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Delete from T_GS_VAGA where ID_VAGA = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Vaga deletada com sucesso!";
    }

    public String atualizar(Vaga vaga) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Update T_GS_VAGA set TITULO = ?, DESCRICAO = ?, NIVEL = ? where ID_VAGA = ?");
        stmt.setString(1, vaga.getTitulo());
        stmt.setString(2, vaga.getDescricao());
        stmt.setString(3, vaga.getNivel());
        stmt.setInt(4, vaga.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Vaga atualizada com sucesso!";
    }

    public List<Vaga> selecionar() throws SQLException {
        List<Vaga> listaVagas = new ArrayList();
        PreparedStatement stmt = this.minhaConexao.prepareStatement("select * from T_GS_VAGA ORDER BY ID_VAGA");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Vaga vaga = new Vaga();
            vaga.setId(rs.getInt("ID_VAGA"));
            vaga.setTitulo(rs.getString("TITULO"));
            vaga.setDescricao(rs.getString("DESCRICAO"));
            vaga.setNivel(rs.getString("NIVEL"));
            listaVagas.add(vaga);
        }
        return listaVagas;
    }

    // Método extra necessário para a API (Busca por ID)
    public Vaga selecionarPorId(int id) throws SQLException {
        Vaga vaga = null;
        PreparedStatement stmt = this.minhaConexao.prepareStatement("select * from T_GS_VAGA where ID_VAGA = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            vaga = new Vaga();
            vaga.setId(rs.getInt("ID_VAGA"));
            vaga.setTitulo(rs.getString("TITULO"));
            vaga.setDescricao(rs.getString("DESCRICAO"));
            vaga.setNivel(rs.getString("NIVEL"));
        }
        return vaga;
    }
}
