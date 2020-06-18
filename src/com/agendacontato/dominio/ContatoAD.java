package com.agendacontato.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoAD {

    private final Connection conexao;

    public ContatoAD(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Contato> listar() {
        List<Contato> lista = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String consultar = "SELECT * FROM contatos ORDER BY id DESC";
        try {
            preparedStatement = this.conexao.prepareStatement(consultar);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Contato contato = new Contato();

                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setTipo(resultSet.getInt("tipo"));
                lista.add(contato);
            }

            return lista;

        } catch (SQLException ex) {
            try {
                this.conexao.rollback();
            } catch (SQLException ex1) {
            }
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return lista;
    }

    public void salvar(Contato contato) {
        PreparedStatement preparedStatement = null;
        String salvar = "INSERT INTO contatos(nome,telefone,tipo) VALUES (?,?,?)";
        try {
            this.conexao.setAutoCommit(false);
            preparedStatement = this.conexao.prepareStatement(salvar);

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getTelefone());
            preparedStatement.setInt(3, contato.getTipo());
            preparedStatement.execute();
            this.conexao.commit();
            System.out.println("Salvo!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            try {
                this.conexao.rollback();
            } catch (SQLException ex1) {
            }
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public void excluir(Contato contato) {
        PreparedStatement preparedStatement = null;
        String salvar = "DELETE FROM contatos WHERE id = ?";
        try {
            this.conexao.setAutoCommit(false);
            preparedStatement = this.conexao.prepareStatement(salvar);
            preparedStatement.setInt(1, contato.getId());
            preparedStatement.execute();
            this.conexao.commit();
            System.out.println("Excluído!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            try {
                this.conexao.rollback();
            } catch (SQLException ex1) {
            }
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public List<Contato> buscar(Contato contatoParaBuscar) {
        List<Contato> lista = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String nomeParaPesquisar = contatoParaBuscar.getNome().toLowerCase();
        String consultar = "SELECT * FROM contatos WHERE nome LIKE '%" + nomeParaPesquisar + "%'";
        try {
            preparedStatement = this.conexao.prepareStatement(consultar);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setTipo(resultSet.getInt("tipo"));
                lista.add(contato);
            }

            return lista;

        } catch (SQLException ex) {
            try {
                this.conexao.rollback();
            } catch (SQLException ex1) {
            }
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return lista;
    }

    public Contato buscarPorId(Contato contatoParaBuscar) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String consultar = "SELECT * FROM contatos WHERE id = ?";
        try {
            preparedStatement = this.conexao.prepareStatement(consultar);
            preparedStatement.setInt(1, contatoParaBuscar.getId());
            resultSet = preparedStatement.executeQuery();

            Contato contato = new Contato();
            contato.setId(resultSet.getInt("id"));
            contato.setNome(resultSet.getString("nome"));
            contato.setTelefone(resultSet.getString("telefone"));

            return contato;

        } catch (SQLException ex) {
            try {
                this.conexao.rollback();
            } catch (SQLException ex1) {
            }
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            } catch (SQLException ex) {
            }
        }

        return null;
    }
}
