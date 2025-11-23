package br.com.fiap.main;

import br.com.fiap.beans.Lead;
import br.com.fiap.dao.LeadDAO;
import javax.swing.JOptionPane;

public class TesteInserirLead {
    static String texto(String j) { return JOptionPane.showInputDialog(j); }

    public static void main(String[] args) {
        try {
            Lead objLead = new Lead();
            LeadDAO objDao = new LeadDAO();

            objLead.setNome(texto("Nome do Contato"));
            objLead.setEmail(texto("Email do Contato"));
            objLead.setMensagem(texto("Mensagem"));

            System.out.println(objDao.inserir(objLead));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
