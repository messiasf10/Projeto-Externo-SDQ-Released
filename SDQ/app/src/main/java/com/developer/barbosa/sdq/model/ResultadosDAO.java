package com.developer.barbosa.sdq.model;

import com.developer.barbosa.sdq.enums.TipoQuestionario;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by Messias on 08/04/2017.
 */

public class ResultadosDAO {

    public static List<String> getStringsViewQuestionariosByTipo(String tipo){

        List<String> stringQuestionariosRetorno = new ArrayList<>();
        String infoQuestionario, infoNomeCompleto, infoData;

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionarios = questionarioRealmQuery.findAll();

        for(Questionario q : questionarios){
            String tipoQuestionario = q.getTipo();
            if(tipoQuestionario.equals(TipoQuestionario.RESPONSAVEL.getTipo())) {
                infoNomeCompleto = q.getQuestaoRespostas().get(q.getQuestaoRespostas().size()-3).getResposta();
                infoData = q.getQuestaoRespostas().get(q.getQuestaoRespostas().size()-2).getResposta();
            } else {
                infoNomeCompleto = q.getQuestaoRespostas().get(q.getQuestaoRespostas().size()-2).getResposta();
                infoData = q.getQuestaoRespostas().get(q.getQuestaoRespostas().size()-1).getResposta();
            }
            infoQuestionario = "NOME COMPLETO: " + infoNomeCompleto  + " | DATA: " + infoData;
            stringQuestionariosRetorno.add(infoQuestionario);
        }

        realm.commitTransaction();

        realm.close();

        return  stringQuestionariosRetorno;

    }

    public static int[] getNumeroRespostasFalsoMMVVQuestionarioPositionTipo(String tipo, int position){
        int numeroRespostasFalso = 0, numeroRespostasMMV = 0, numeroRespostasVerdadeiro = 0;
        int retorno[] = new int[3];

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        for(QuestaoResposta qr : questionarioSelecionado.getQuestaoRespostas()){
            if (qr.getResposta().equals("FALSO"))
                numeroRespostasFalso++;
            else if (qr.getResposta().equals("MAIS OU MENOS VERDADEIRO"))
                numeroRespostasMMV++;
            else if (qr.getResposta().equals("VERDADEIRO"))
                numeroRespostasVerdadeiro++;
        }

        realm.commitTransaction();

        realm.close();

        retorno[0] = numeroRespostasFalso;
        retorno[1] = numeroRespostasMMV;
        retorno[2] = numeroRespostasVerdadeiro;

        return retorno;
    }

    public static int getNumeroRespostasFalsoByQuestionarioPositionTipo(String tipo, int position){
        int numeroRespostasFalso = 0;

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        for(QuestaoResposta qr : questionarioSelecionado.getQuestaoRespostas()){
            if (qr.getResposta().equals("FALSO"))
                numeroRespostasFalso++;
        }

        realm.commitTransaction();

        realm.close();

        return numeroRespostasFalso;
    }

    public static int getNumeroRespostasMMVByQuestionarioPositionTipo(String tipo, int position){
        int numeroRespostasMMV = 0;

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        for(QuestaoResposta qr : questionarioSelecionado.getQuestaoRespostas()){
            if (qr.getResposta().equals("MAIS OU MENOS VERDADEIRO"))
                numeroRespostasMMV++;
        }

        realm.commitTransaction();

        realm.close();

        return numeroRespostasMMV;
    }

    public static int getNumeroRespostasVerdadeiroByQuestionarioPositionTipo(String tipo, int position){
        int numeroRespostasVerdadeiro = 0;

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        for(QuestaoResposta qr : questionarioSelecionado.getQuestaoRespostas()){
            if (qr.getResposta().equals("VERDADEIRO"))
                numeroRespostasVerdadeiro++;
        }

        realm.commitTransaction();

        realm.close();

        return numeroRespostasVerdadeiro;
    }

    public static Questionario getQuestionarioByPositionTipo(String tipo, int position){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        realm.commitTransaction();

        realm.close();

        return questionarioSelecionado;
    }

    public static boolean deleteQuestionarioByPositionTipo(String tipo, int position){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", tipo);
        List<Questionario> questionariosTipoSelecionado = questionarioRealmQuery.findAll();

        Questionario questionarioSelecionado = questionariosTipoSelecionado.get(position);

        if (questionarioSelecionado != null){
            questionarioSelecionado.deleteFromRealm();

            realm.commitTransaction();

            realm.close();

            return true;
        }

        realm.commitTransaction();

        realm.close();

        return false;
    }

}
