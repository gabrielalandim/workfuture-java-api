package br.com.fiap.bo;

import br.com.fiap.beans.Vaga;
import br.com.fiap.dao.VagaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class VagaBO {
    VagaDAO vagaDAO;

    public ArrayList<Vaga> selecionarBo() throws ClassNotFoundException, SQLException {
        this.vagaDAO = new VagaDAO();
        return (ArrayList)this.vagaDAO.selecionar();
    }

    public Vaga buscarPorIdBo(int id) throws ClassNotFoundException, SQLException {
        this.vagaDAO = new VagaDAO();
        return this.vagaDAO.selecionarPorId(id);
    }

    public void inserirBo(Vaga vaga) throws ClassNotFoundException, SQLException {
        VagaDAO vagaDao = new VagaDAO();
        vagaDao.inserir(vaga);
    }

    public void atualizarBo(Vaga vaga) throws ClassNotFoundException, SQLException {
        VagaDAO vagaDao = new VagaDAO();
        vagaDao.atualizar(vaga);
    }

    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        VagaDAO vagaDao = new VagaDAO();
        vagaDao.deletar(id);
    }
}
