package com.developer.barbosa.sdq.enums;

/**
 * Created by Bruno Barbosa on 31/03/2017.
 */

public enum TipoQuestionario {

    RESPONSAVEL("PAIS/RESPONSÁVEIS"),

    PROFESSORES("PROFESSORES"),

    ALUNOS("ALUNOS");

    private String tipo;

    TipoQuestionario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
