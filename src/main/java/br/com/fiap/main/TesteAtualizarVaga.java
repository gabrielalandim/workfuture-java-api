package br.com.fiap.main;

import br.com.fiap.beans.Vaga;
import br.com.fiap.dao.VagaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteAtualizarVaga {
    static String texto(String j) { return JOptionPane.showInputDialog(j); }
    static int inteiro(String j) { return Integer.parseInt(JOptionPane.showInputDialog(j)); }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Vaga objVaga = new Vaga();
        VagaDAO objVagaDao = new VagaDAO();

        objVaga.setId(inteiro("Informe o ID da Vaga a ser atualizada"));
        objVaga.setTitulo(texto("Atualize o Título"));
        objVaga.setDescricao(texto("Atualize a Descrição"));
        objVaga.setNivel(texto("Atualize o Nível"));

        System.out.println(objVagaDao.atualizar(objVaga));
    }
}
