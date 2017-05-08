package com.developer.barbosa.sdq.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Bruno Barbosa on 30/03/2017.
 */

public class Questionario extends RealmObject{

    @PrimaryKey
    private long id;
    private String tipo;
    private RealmList<QuestaoResposta> questaoRespostas = new RealmList<>();

    public Questionario() {
    }

    public Questionario(String tipo, RealmList<QuestaoResposta> questaoRespostas) {
        this.tipo = tipo;
        this.questaoRespostas = questaoRespostas;
    }

    @Override
    public String toString() {
        return "[QUESTIONÁRIO ID = " + this.id + "]\n" +
                "\tTipo: " + this.tipo  + "\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public RealmList<QuestaoResposta> getQuestaoRespostas() {
        return questaoRespostas;
    }

    public void setQuestaoRespostas(RealmList<QuestaoResposta> questaoRespostas) {
        this.questaoRespostas = questaoRespostas;
    }
}
