package br.com.fiap.main;

import br.com.fiap.beans.Vaga;
import br.com.fiap.dao.VagaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TesteInserirVaga {
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Vaga objVaga = new Vaga();
        VagaDAO objVagaDao = new VagaDAO();

        // ID é automatico na sequence
        objVaga.setTitulo(texto("Informe o Título da Vaga"));
        objVaga.setDescricao(texto("Informe a Descrição"));
        objVaga.setNivel(texto("Informe o Nível (Jr/Pl/Sr)"));

        System.out.println(objVagaDao.inserir(objVaga));
    }
}
