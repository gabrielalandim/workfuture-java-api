package br.com.fiap.main;

import br.com.fiap.beans.Lead;
import br.com.fiap.dao.LeadDAO;
import java.util.List;

public class TesteSelecionarLead {
    public static void main(String[] args) {
        try {
            LeadDAO dao = new LeadDAO();
            List<Lead> lista = dao.selecionar();
            for(Lead l : lista) {
                System.out.println("ID: " + l.getId() + " | Nome: " + l.getNome() + " | Msg: " + l.getMensagem());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
