package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    public Connection conexao() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // CORREÇÃO AQUI:
        // 1. getenv("DB_USER") -> Procura a chave 'DB_USER' que configuramos no Render.
        // 2. Se não achar (null), usa o seu RM fixo (para rodar no seu PC).
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "RM565146";

        // Mesma coisa para a senha
        String pass = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "170806";

        return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", user, pass);
    }
}