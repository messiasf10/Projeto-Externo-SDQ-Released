package com.developer.barbosa.sdq.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Bruno Barbosa on 30/03/2017.
 */

public class QuestaoResposta extends RealmObject{

    private String questao;
    private String resposta;
    private RealmList<SubQuestoes> subQuestoes;

    public QuestaoResposta() {
    }

    public QuestaoResposta(String questao, String resposta) {
        this.questao = questao;
        this.resposta = resposta;
    }

    public QuestaoResposta(String questao) {
        this.questao = questao;
    }

    public RealmList<SubQuestoes> getSubQuestoes() {
        return subQuestoes;
    }

    public void setSubQuestoes(RealmList<SubQuestoes> subQuestoes) {
        this.subQuestoes = subQuestoes;
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
