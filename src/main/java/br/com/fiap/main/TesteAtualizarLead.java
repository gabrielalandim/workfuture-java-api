package br.com.fiap.main;

import br.com.fiap.beans.Lead;
import br.com.fiap.dao.LeadDAO;
import javax.swing.JOptionPane;

public class TesteAtualizarLead {
    static String texto(String j) { return JOptionPane.showInputDialog(j); }
    static int inteiro(String j) { return Integer.parseInt(JOptionPane.showInputDialog(j)); }

    public static void main(String[] args) {
        try {
            Lead objLead = new Lead();
            LeadDAO objDao = new LeadDAO();

            objLead.setId(inteiro("Digite o ID do contato para atualizar"));
            objLead.setNome(texto("Novo Nome"));
            objLead.setEmail(texto("Novo Email"));
            objLead.setMensagem(texto("Nova Mensagem"));

            System.out.println(objDao.atualizar(objLead));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}