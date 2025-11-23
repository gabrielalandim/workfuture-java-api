package br.com.fiap.main;

import br.com.fiap.dao.VagaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteDeletarVaga {
    static int inteiro(String j) { return Integer.parseInt(JOptionPane.showInputDialog(j)); }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        VagaDAO objVagaDao = new VagaDAO();
        int id = inteiro("Informe o ID da Vaga a ser deletada");
        System.out.println(objVagaDao.deletar(id));
    }
}