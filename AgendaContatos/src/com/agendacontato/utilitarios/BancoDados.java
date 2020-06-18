package com.agendacontato.utilitarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDados {

    public boolean eParaRestaurarBanco() {
        String sql = "SELECT * FROM contatos";
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = Conexao.pegarConexao();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.executeQuery();
            return false;
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            if (conexao != null && preparedStatement != null) {
                try {
                    preparedStatement.close();
                    conexao.close();
                } catch (SQLException ex) {
                }
            }
        }
        return true;
    }

    public void execute() {
        String sqlParaExecutar = pegarSqlParaExecutar();
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = Conexao.pegarConexao();
            preparedStatement = conexao.prepareStatement(sqlParaExecutar);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            if (conexao != null && preparedStatement != null) {
                try {
                    preparedStatement.close();
                    conexao.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    private String pegarSqlParaExecutar() {
        return "CREATE TABLE IF NOT EXISTS contatos (\n"
                + " id	INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nome TEXT NOT NULL,\n"
                + " telefone TEXT NOT NULL,\n"
                + " tipo INTEGER NOT NULL\n"
                + ");";
    }
}
