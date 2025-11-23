package br.com.fiap.main;

import br.com.fiap.beans.Vaga;
import br.com.fiap.dao.VagaDAO;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

public class TesteSelecionarVaga {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        VagaDAO objVagaDao = new VagaDAO();
        List<Vaga> listaVagas = objVagaDao.selecionar();
        if (listaVagas != null) {
            for(Vaga vaga : listaVagas) {
                System.out.println("ID: " + vaga.getId() + " | Título: " + vaga.getTitulo() + " | Nível: " + vaga.getNivel());
            }
        }
    }
}
