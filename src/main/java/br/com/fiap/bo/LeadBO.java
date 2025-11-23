package br.com.fiap.bo;

import br.com.fiap.beans.Lead;
import br.com.fiap.dao.LeadDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeadBO {

    // Inserir
    public void inserirBo(Lead lead) throws ClassNotFoundException, SQLException {
        if(lead.getEmail() == null || !lead.getEmail().contains("@")) {
            throw new SQLException("Email inválido!");
        }
        LeadDAO dao = new LeadDAO();
        dao.inserir(lead);
    }

    // Selecionar Todos
    public ArrayList<Lead> selecionarBo() throws ClassNotFoundException, SQLException {
        LeadDAO dao = new LeadDAO();
        return (ArrayList<Lead>) dao.selecionar();
    }

    // Selecionar por ID
    public Lead buscarPorIdBo(int id) throws ClassNotFoundException, SQLException {
        LeadDAO dao = new LeadDAO();
        return dao.selecionarPorId(id);
    }

    // Atualizar
    public void atualizarBo(Lead lead) throws ClassNotFoundException, SQLException {
        LeadDAO dao = new LeadDAO();
        dao.atualizar(lead);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        LeadDAO dao = new LeadDAO();
        dao.deletar(id);
    }
}
