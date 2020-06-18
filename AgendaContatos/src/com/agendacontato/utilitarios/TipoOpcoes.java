package com.agendacontato.utilitarios;

public enum TipoOpcoes {
    AMIGOS(1), FAMILIA(2), TRABALHO(3), OUTROS(4);
    private final int valor;

    private TipoOpcoes(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor() {
        return valor;
    }

}
