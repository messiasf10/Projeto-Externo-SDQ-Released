package com.developer.barbosa.sdq.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Bruno Barbosa on 03/04/2017.
 */

public class SubQuestoes extends RealmObject {

    private String questao;

    private String resposta;

    public SubQuestoes(String questao, String resposta) {
        this.questao = questao;
        this.resposta = resposta;
    }

    public SubQuestoes() {
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
