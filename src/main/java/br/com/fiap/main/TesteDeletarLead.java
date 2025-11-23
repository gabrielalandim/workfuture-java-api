package br.com.fiap.main;

import br.com.fiap.dao.LeadDAO;
import javax.swing.JOptionPane;

public class TesteDeletarLead {
    static int inteiro(String j) { return Integer.parseInt(JOptionPane.showInputDialog(j)); }

    public static void main(String[] args) {
        try {
            LeadDAO objDao = new LeadDAO();
            int id = inteiro("Digite o ID do contato para deletar");
            System.out.println(objDao.deletar(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
