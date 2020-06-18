package com.agendacontato.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Conexao {

    public static Connection pegarConexao() throws ClassNotFoundException, SQLException {
        Class.forName(Constantes.BD_DRIVER);
        Connection conexao = DriverManager.getConnection(Constantes.BD_URL);
        return conexao;
    }
}
