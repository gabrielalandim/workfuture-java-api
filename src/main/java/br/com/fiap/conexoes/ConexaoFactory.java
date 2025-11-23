package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    public Connection conexao() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String user = System.getenv("RM565146") != null ? System.getenv("RM565146") : "RM565146";
        String pass = System.getenv("170806") != null ? System.getenv("170806") : "170806";

        return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", user, pass);
    }
}