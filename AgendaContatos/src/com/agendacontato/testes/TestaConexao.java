package com.agendacontato.testes;

import com.agendacontato.utilitarios.Conexao;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) {
        try {
            Conexao.pegarConexao();
            System.out.println("Conectou!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro ao conectar! " + ex.getMessage());
        }
    }
}
