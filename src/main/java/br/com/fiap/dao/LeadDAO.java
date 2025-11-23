package br.com.fiap.dao;

import br.com.fiap.beans.Lead;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeadDAO {
    public Connection minhaConexao;

    public LeadDAO() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Lead lead) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement(
                "Insert into T_GS_CONTATO (ID_CONTATO, NOME, EMAIL, MENSAGEM) values (SEQ_GS_CONTATO.NEXTVAL, ?, ?, ?)"
        );
        stmt.setString(1, lead.getNome());
        stmt.setString(2, lead.getEmail());
        stmt.setString(3, lead.getMensagem());
        stmt.execute();
        stmt.close();
        return "Contato enviado com sucesso!";
    }

    // Select All
    public List<Lead> selecionar() throws SQLException {
        List<Lead> lista = new ArrayList<>();
        PreparedStatement stmt = this.minhaConexao.prepareStatement("select * from T_GS_CONTATO ORDER BY ID_CONTATO DESC");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Lead lead = new Lead();
            lead.setId(rs.getInt("ID_CONTATO"));
            lead.setNome(rs.getString("NOME"));
            lead.setEmail(rs.getString("EMAIL"));
            lead.setMensagem(rs.getString("MENSAGEM"));
            lista.add(lead);
        }
        stmt.close();
        return lista;
    }

    // Select By ID (Para buscar um especifico)
    public Lead selecionarPorId(int id) throws SQLException {
        Lead lead = null;
        PreparedStatement stmt = this.minhaConexao.prepareStatement("select * from T_GS_CONTATO where ID_CONTATO = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            lead = new Lead();
            lead.setId(rs.getInt("ID_CONTATO"));
            lead.setNome(rs.getString("NOME"));
            lead.setEmail(rs.getString("EMAIL"));
            lead.setMensagem(rs.getString("MENSAGEM"));
        }
        stmt.close();
        return lead;
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement("Delete from T_GS_CONTATO where ID_CONTATO = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Contato deletado com sucesso!";
    }

    // Update
    public String atualizar(Lead lead) throws SQLException {
        PreparedStatement stmt = this.minhaConexao.prepareStatement(
                "Update T_GS_CONTATO set NOME = ?, EMAIL = ?, MENSAGEM = ? where ID_CONTATO = ?"
        );
        stmt.setString(1, lead.getNome());
        stmt.setString(2, lead.getEmail());
        stmt.setString(3, lead.getMensagem());
        stmt.setInt(4, lead.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Contato atualizado com sucesso!";
    }
}