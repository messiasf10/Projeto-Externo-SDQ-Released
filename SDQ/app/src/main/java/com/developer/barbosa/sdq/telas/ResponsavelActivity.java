package com.developer.barbosa.sdq.telas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.barbosa.sdq.enums.QuestoesResponsavel;
import com.developer.barbosa.sdq.enums.TipoQuestionario;
import com.developer.barbosa.sdq.R;
import com.developer.barbosa.sdq.model.QuestaoResposta;
import com.developer.barbosa.sdq.model.Questionario;
import com.developer.barbosa.sdq.model.ResultadosDAO;
import com.developer.barbosa.sdq.model.SubQuestoes;
import com.developer.barbosa.sdq.util.Mascara;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class ResponsavelActivity extends AppCompatActivity {

    EditText rq1,rq2;
    RadioGroup rg3;
    TextView q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,
            q26,q27,q28,qComentario,q29,q30,q31,q32,q32sub1,q32sub2,q32sub3,q32sub4,q33,q34,q35,q36;
    RadioGroup rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rg13,rg14,rg15,rg16,rg17,rg18,rg19,rg20,rg21,rg22,
            rg23,rg24,rg25,rg26,rg27,rg28,rg29,rg30,rg31,rg32sub1,rg32sub2,rg32sub3,rg32sub4,rg33;
    EditText rQcomentario,rq34,rq35,rq36;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsavel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#763b5c")));

        final Realm realm = Realm.getDefaultInstance();

        // resposta do nome
        rq1 = (EditText) findViewById(R.id.rQ1);

        // resposta da data
        rq2 = (EditText) findViewById(R.id.rQ2);
        rq2.addTextChangedListener(Mascara.insert("##/##/####", rq2));

        // Radio group para pegar o sexo
        rg3 = (RadioGroup) findViewById(R.id.rQ3);

        q4 = (TextView) findViewById(R.id.Q4);
        q4.setText(QuestoesResponsavel.Q4.getTexto());
        rg4 = (RadioGroup) findViewById(R.id.rQ4);

        q5 = (TextView) findViewById(R.id.Q5);
        q5.setText(QuestoesResponsavel.Q5.getTexto());
        rg5 = (RadioGroup) findViewById(R.id.rQ5);

        q6 = (TextView) findViewById(R.id.Q6);
        q6.setText(QuestoesResponsavel.Q6.getTexto());
        rg6 = (RadioGroup) findViewById(R.id.rQ6);

        q7 = (TextView) findViewById(R.id.Q7);
        q7.setText(QuestoesResponsavel.Q7.getTexto());
        rg7 = (RadioGroup) findViewById(R.id.rQ7);

        q8 = (TextView) findViewById(R.id.Q8);
        q8.setText(QuestoesResponsavel.Q8.getTexto());
        rg8 = (RadioGroup) findViewById(R.id.rQ8);

        q9 = (TextView) findViewById(R.id.Q9);
        q9.setText(QuestoesResponsavel.Q9.getTexto());
        rg9 = (RadioGroup) findViewById(R.id.rQ9);

        q10 = (TextView) findViewById(R.id.Q10);
        q10.setText(QuestoesResponsavel.Q10.getTexto());
        rg10 = (RadioGroup) findViewById(R.id.rQ10);

        q11 = (TextView) findViewById(R.id.Q11);
        q11.setText(QuestoesResponsavel.Q11.getTexto());
        rg11 = (RadioGroup) findViewById(R.id.rQ11);

        q12 = (TextView) findViewById(R.id.Q12);
        q12.setText(QuestoesResponsavel.Q12.getTexto());
        rg12 = (RadioGroup) findViewById(R.id.rQ12);

        q13 = (TextView) findViewById(R.id.Q13);
        q13.setText(QuestoesResponsavel.Q13.getTexto());
        rg13 = (RadioGroup) findViewById(R.id.rQ13);

        q14 = (TextView) findViewById(R.id.Q14);
        q14.setText(QuestoesResponsavel.Q14.getTexto());
        rg14 = (RadioGroup) findViewById(R.id.rQ14);

        q15 = (TextView) findViewById(R.id.Q15);
        q15.setText(QuestoesResponsavel.Q15.getTexto());
        rg15 = (RadioGroup) findViewById(R.id.rQ15);

        q16 = (TextView) findViewById(R.id.Q16);
        q16.setText(QuestoesResponsavel.Q16.getTexto());
        rg16 = (RadioGroup) findViewById(R.id.rQ16);

        q17 = (TextView) findViewById(R.id.Q17);
        q17.setText(QuestoesResponsavel.Q17.getTexto());
        rg17 = (RadioGroup) findViewById(R.id.rQ17);

        q18 = (TextView) findViewById(R.id.Q18);
        q18.setText(QuestoesResponsavel.Q18.getTexto());
        rg18 = (RadioGroup) findViewById(R.id.rQ18);

        q19 = (TextView) findViewById(R.id.Q19);
        q19.setText(QuestoesResponsavel.Q19.getTexto());
        rg19 = (RadioGroup) findViewById(R.id.rQ19);

        q20 = (TextView) findViewById(R.id.Q20);
        q20.setText(QuestoesResponsavel.Q20.getTexto());
        rg20 = (RadioGroup) findViewById(R.id.rQ20);

        q21 = (TextView) findViewById(R.id.Q21);
        q21.setText(QuestoesResponsavel.Q21.getTexto());
        rg21 = (RadioGroup) findViewById(R.id.rQ21);

        q22 = (TextView) findViewById(R.id.Q22);
        q22.setText(QuestoesResponsavel.Q22.getTexto());
        rg22 = (RadioGroup) findViewById(R.id.rQ22);

        q23 = (TextView) findViewById(R.id.Q23);
        q23.setText(QuestoesResponsavel.Q23.getTexto());
        rg23 = (RadioGroup) findViewById(R.id.rQ23);

        q24 = (TextView) findViewById(R.id.Q24);
        q24.setText(QuestoesResponsavel.Q24.getTexto());
        rg24 = (RadioGroup) findViewById(R.id.rQ24);

        q25 = (TextView) findViewById(R.id.Q25);
        q25.setText(QuestoesResponsavel.Q25.getTexto());
        rg25 = (RadioGroup) findViewById(R.id.rQ25);

        q26 = (TextView) findViewById(R.id.Q26);
        q26.setText(QuestoesResponsavel.Q26.getTexto());
        rg26 = (RadioGroup) findViewById(R.id.rQ26);

        q27 = (TextView) findViewById(R.id.Q27);
        q27.setText(QuestoesResponsavel.Q27.getTexto());
        rg27 = (RadioGroup) findViewById(R.id.rQ27);

        q28 = (TextView) findViewById(R.id.Q28);
        q28.setText(QuestoesResponsavel.Q28.getTexto());
        rg28 = (RadioGroup) findViewById(R.id.rQ28);

        qComentario = (TextView) findViewById(R.id.Qcomentario);
        qComentario.setText(QuestoesResponsavel.QComentario.getTexto());
        rQcomentario = (EditText) findViewById(R.id.rQcomentario);

        q29 = (TextView) findViewById(R.id.Q29);
        q29.setText(QuestoesResponsavel.Q29.getTexto());
        rg29 = (RadioGroup) findViewById(R.id.rQ29);

        q30 = (TextView) findViewById(R.id.Q30);
        q30.setText(QuestoesResponsavel.Q30.getTexto());
        rg30 = (RadioGroup) findViewById(R.id.rQ30);

        q31 = (TextView) findViewById(R.id.Q31);
        q31.setText(QuestoesResponsavel.Q31.getTexto());
        rg31 = (RadioGroup) findViewById(R.id.rQ31);

        q32 = (TextView) findViewById(R.id.Q32);
        q32.setText(QuestoesResponsavel.Q32.getTexto());

        q32sub1 = (TextView) findViewById(R.id.Q32sub1);
        q32sub1.setText(QuestoesResponsavel.Q32sub1.getTexto());
        rg32sub1 = (RadioGroup) findViewById(R.id.rQ32sub1);

        q32sub2 = (TextView) findViewById(R.id.Q32sub2);
        q32sub2.setText(QuestoesResponsavel.Q32sub2.getTexto());
        rg32sub2 = (RadioGroup) findViewById(R.id.rQ32sub2);

        q32sub3 = (TextView) findViewById(R.id.Q32sub3);
        q32sub3.setText(QuestoesResponsavel.Q32sub3.getTexto());
        rg32sub3 = (RadioGroup) findViewById(R.id.rQ32sub3);

        q32sub4 = (TextView) findViewById(R.id.Q32sub4);
        q32sub4.setText(QuestoesResponsavel.Q32sub4.getTexto());
        rg32sub4 = (RadioGroup) findViewById(R.id.rQ32sub4);

        q33 = (TextView) findViewById(R.id.Q33);
        q33.setText(QuestoesResponsavel.Q33.getTexto());
        rg33 = (RadioGroup) findViewById(R.id.rQ33);

        q34 = (TextView) findViewById(R.id.Q34);
        q34.setText(QuestoesResponsavel.Q34.getTexto());
        rq34 = (EditText) findViewById(R.id.rQ34);

        q35 = (TextView) findViewById(R.id.Q35);
        q35.setText(QuestoesResponsavel.Q35.getTexto());
        rq35 = (EditText) findViewById(R.id.rQ35);
        rq35.addTextChangedListener(Mascara.insert("##/##/####", rq35));

        q36 = (TextView) findViewById(R.id.Q36);
        q36.setText(QuestoesResponsavel.Q36.getTexto());
        rq36 = (EditText) findViewById(R.id.rQ36);

        salvar = (Button) findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        String tipoQuestSelec  = intent.getStringExtra("tipo");
        int positionQuestSelec = intent.getIntExtra("position", -1);

        if (tipoQuestSelec != null && positionQuestSelec != -1){
            somenteExibirQuestionario(tipoQuestSelec, positionQuestSelec);
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (rq1.getText().toString().trim().isEmpty() || rq2.getText().toString().trim().isEmpty() || rg3.getCheckedRadioButtonId() == -1
                        || rg4.getCheckedRadioButtonId() == -1
                        || rg5.getCheckedRadioButtonId() == -1
                        || rg6.getCheckedRadioButtonId() == -1
                        || rg7.getCheckedRadioButtonId() == -1
                        || rg8.getCheckedRadioButtonId() == -1
                        || rg9.getCheckedRadioButtonId() == -1
                        || rg10.getCheckedRadioButtonId() == -1
                        || rg11.getCheckedRadioButtonId() == -1
                        || rg12.getCheckedRadioButtonId() == -1
                        || rg13.getCheckedRadioButtonId() == -1
                        || rg14.getCheckedRadioButtonId() == -1
                        || rg15.getCheckedRadioButtonId() == -1
                        || rg16.getCheckedRadioButtonId() == -1
                        || rg17.getCheckedRadioButtonId() == -1
                        || rg18.getCheckedRadioButtonId() == -1
                        || rg19.getCheckedRadioButtonId() == -1
                        || rg20.getCheckedRadioButtonId() == -1
                        || rg21.getCheckedRadioButtonId() == -1
                        || rg22.getCheckedRadioButtonId() == -1
                        || rg23.getCheckedRadioButtonId() == -1
                        || rg24.getCheckedRadioButtonId() == -1
                        || rg25.getCheckedRadioButtonId() == -1
                        || rg26.getCheckedRadioButtonId() == -1
                        || rg27.getCheckedRadioButtonId() == -1
                        || rg28.getCheckedRadioButtonId() == -1
                        || rg29.getCheckedRadioButtonId() == -1
                        || rq34.getText().toString().trim().isEmpty()
                        || rq35.getText().toString().trim().isEmpty()
                        || rq36.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Selecione todos os campos!",Toast.LENGTH_LONG).show();
                } else {
                    QuestaoResposta q1 = new QuestaoResposta(QuestoesResponsavel.Q1.getTexto(),rq1.getText().toString());
                    QuestaoResposta q2 = new QuestaoResposta(QuestoesResponsavel.Q2.getTexto(),rq2.getText().toString());

                    String resp3 = "";
                    switch (rg3.getCheckedRadioButtonId()){
                        case R.id.rbM : resp3 = "MASCULINO";break;
                        case R.id.rbF : resp3 = "FEMININO";break;
                    }
                    QuestaoResposta q3 = new QuestaoResposta(QuestoesResponsavel.Q3.getTexto(),resp3);

                    String resp4 = "";
                    switch (rg4.getCheckedRadioButtonId()){
                        case R.id.rbQ4Falso : resp4 = "FALSO";break;
                        case R.id.rbQ4MMV : resp4 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ4Verdadeiro : resp4 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q4 = new QuestaoResposta(QuestoesResponsavel.Q4.getTexto(),resp4);

                    String resp5 = "";
                    switch (rg5.getCheckedRadioButtonId()){
                        case R.id.rbQ5Falso : resp5 = "FALSO";break;
                        case R.id.rbQ5MMV : resp5 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ5Verdadeiro : resp5 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q5 = new QuestaoResposta(QuestoesResponsavel.Q5.getTexto(),resp5);

                    String resp6 = "";
                    switch (rg6.getCheckedRadioButtonId()){
                        case R.id.rbQ6Falso : resp6 = "FALSO";break;
                        case R.id.rbQ6MMV : resp6 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ6Verdadeiro : resp6 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q6 = new QuestaoResposta(QuestoesResponsavel.Q6.getTexto(),resp6);

                    String resp7 = "";
                    switch (rg7.getCheckedRadioButtonId()){
                        case R.id.rbQ7Falso : resp7 = "FALSO";break;
                        case R.id.rbQ7MMV : resp7 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ7Verdadeiro : resp7 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q7 = new QuestaoResposta(QuestoesResponsavel.Q7.getTexto(),resp7);

                    String resp8 = "";
                    switch (rg8.getCheckedRadioButtonId()){
                        case R.id.rbQ8Falso : resp8 = "FALSO";break;
                        case R.id.rbQ8MMV : resp8 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ8Verdadeiro : resp8 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q8 = new QuestaoResposta(QuestoesResponsavel.Q8.getTexto(),resp8);

                    String resp9 = "";
                    switch (rg9.getCheckedRadioButtonId()){
                        case R.id.rbQ9Falso : resp9 = "FALSO";break;
                        case R.id.rbQ9MMV : resp9 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ9Verdadeiro : resp9 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q9 = new QuestaoResposta(QuestoesResponsavel.Q9.getTexto(),resp9);

                    String resp10 = "";
                    switch (rg10.getCheckedRadioButtonId()){
                        case R.id.rbQ10Falso : resp10 = "FALSO";break;
                        case R.id.rbQ10MMV : resp10 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ10Verdadeiro : resp10 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q10 = new QuestaoResposta(QuestoesResponsavel.Q10.getTexto(),resp10);

                    String resp11 = "";
                    switch (rg11.getCheckedRadioButtonId()){
                        case R.id.rbQ11Falso : resp11 = "FALSO";break;
                        case R.id.rbQ11MMV : resp11 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ11Verdadeiro : resp11 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q11 = new QuestaoResposta(QuestoesResponsavel.Q11.getTexto(),resp11);

                    String resp12 = "";
                    switch (rg12.getCheckedRadioButtonId()){
                        case R.id.rbQ12Falso : resp12 = "FALSO";break;
                        case R.id.rbQ12MMV : resp12 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ12Verdadeiro : resp12 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q12 = new QuestaoResposta(QuestoesResponsavel.Q12.getTexto(),resp12);

                    String resp13 = "";
                    switch (rg13.getCheckedRadioButtonId()){
                        case R.id.rbQ13Falso : resp13 = "FALSO";break;
                        case R.id.rbQ13MMV : resp13 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ13Verdadeiro : resp13 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q13 = new QuestaoResposta(QuestoesResponsavel.Q13.getTexto(),resp13);

                    String resp14 = "";
                    switch (rg14.getCheckedRadioButtonId()){
                        case R.id.rbQ14Falso : resp14 = "FALSO";break;
                        case R.id.rbQ14MMV : resp14 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ14Verdadeiro : resp14 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q14 = new QuestaoResposta(QuestoesResponsavel.Q14.getTexto(),resp14);

                    String resp15 = "";
                    switch (rg15.getCheckedRadioButtonId()){
                        case R.id.rbQ15Falso : resp15 = "FALSO";break;
                        case R.id.rbQ15MMV : resp15 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ15Verdadeiro : resp15 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q15 = new QuestaoResposta(QuestoesResponsavel.Q15.getTexto(),resp15);

                    String resp16 = "";
                    switch (rg16.getCheckedRadioButtonId()){
                        case R.id.rbQ16Falso : resp16 = "FALSO";break;
                        case R.id.rbQ16MMV : resp16 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ16Verdadeiro : resp16 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q16 = new QuestaoResposta(QuestoesResponsavel.Q16.getTexto(),resp16);

                    String resp17 = "";
                    switch (rg17.getCheckedRadioButtonId()){
                        case R.id.rbQ17Falso : resp17 = "FALSO";break;
                        case R.id.rbQ17MMV : resp17 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ17Verdadeiro : resp17 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q17 = new QuestaoResposta(QuestoesResponsavel.Q17.getTexto(),resp17);

                    String resp18 = "";
                    switch (rg18.getCheckedRadioButtonId()){
                        case R.id.rbQ18Falso : resp18 = "FALSO";break;
                        case R.id.rbQ18MMV : resp18 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ18Verdadeiro : resp18 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q18 = new QuestaoResposta(QuestoesResponsavel.Q18.getTexto(),resp18);

                    String resp19 = "";
                    switch (rg19.getCheckedRadioButtonId()){
                        case R.id.rbQ19Falso : resp19 = "FALSO";break;
                        case R.id.rbQ19MMV : resp19 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ19Verdadeiro : resp19 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q19 = new QuestaoResposta(QuestoesResponsavel.Q19.getTexto(),resp19);

                    String resp20 = "";
                    switch (rg20.getCheckedRadioButtonId()){
                        case R.id.rbQ20Falso : resp20 = "FALSO";break;
                        case R.id.rbQ20MMV : resp20 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ20Verdadeiro : resp20 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q20 = new QuestaoResposta(QuestoesResponsavel.Q20.getTexto(),resp20);

                    String resp21 = "";
                    switch (rg21.getCheckedRadioButtonId()){
                        case R.id.rbQ21Falso : resp21 = "FALSO";break;
                        case R.id.rbQ21MMV : resp21 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ21Verdadeiro : resp21 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q21 = new QuestaoResposta(QuestoesResponsavel.Q21.getTexto(),resp21);

                    String resp22 = "";
                    switch (rg22.getCheckedRadioButtonId()){
                        case R.id.rbQ22Falso : resp22 = "FALSO";break;
                        case R.id.rbQ22MMV : resp22 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ22Verdadeiro : resp22 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q22 = new QuestaoResposta(QuestoesResponsavel.Q22.getTexto(),resp22);

                    String resp23 = "";
                    switch (rg23.getCheckedRadioButtonId()){
                        case R.id.rbQ23Falso : resp23 = "FALSO";break;
                        case R.id.rbQ23MMV : resp23 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ23Verdadeiro : resp23 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q23 = new QuestaoResposta(QuestoesResponsavel.Q23.getTexto(),resp23);

                    String resp24 = "";
                    switch (rg24.getCheckedRadioButtonId()){
                        case R.id.rbQ24Falso : resp24 = "FALSO";break;
                        case R.id.rbQ24MMV : resp24 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ24Verdadeiro : resp24 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q24 = new QuestaoResposta(QuestoesResponsavel.Q24.getTexto(),resp24);

                    String resp25 = "";
                    switch (rg25.getCheckedRadioButtonId()){
                        case R.id.rbQ25Falso : resp25 = "FALSO";break;
                        case R.id.rbQ25MMV : resp25 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ25Verdadeiro : resp25 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q25 = new QuestaoResposta(QuestoesResponsavel.Q25.getTexto(),resp25);

                    String resp26 = "";
                    switch (rg26.getCheckedRadioButtonId()){
                        case R.id.rbQ26Falso : resp26 = "FALSO";break;
                        case R.id.rbQ26MMV : resp26 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ26Verdadeiro : resp26 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q26 = new QuestaoResposta(QuestoesResponsavel.Q26.getTexto(),resp26);

                    String resp27 = "";
                    switch (rg27.getCheckedRadioButtonId()){
                        case R.id.rbQ27Falso : resp27 = "FALSO";break;
                        case R.id.rbQ27MMV : resp27 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ27Verdadeiro : resp27 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q27 = new QuestaoResposta(QuestoesResponsavel.Q27.getTexto(),resp27);

                    String resp28 = "";
                    switch (rg28.getCheckedRadioButtonId()){
                        case R.id.rbQ28Falso : resp28 = "FALSO";break;
                        case R.id.rbQ28MMV : resp28 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.rbQ28Verdadeiro : resp28 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q28 = new QuestaoResposta(QuestoesResponsavel.Q28.getTexto(),resp28);

                    QuestaoResposta comentario = new QuestaoResposta(QuestoesResponsavel.QComentario.getTexto(),rQcomentario.getText().toString());

                    String resp29 = "";
                    switch (rg29.getCheckedRadioButtonId()){
                        case R.id.rbQ29N : resp29 = "NAO";break;
                        case R.id.rbQ29SPD : resp29 = "SIM PEQUENAS DIFICULDADES";break;
                        case R.id.rbQ29SDD : resp29 = "SIM DIFICULDADES BEM DEFINIDAS";break;
                        case R.id.rbQ29SDG : resp29 = "SIM DIFICULDADES GRAVES";break;
                    }
                    QuestaoResposta q29 = new QuestaoResposta(QuestoesResponsavel.Q29.getTexto(),resp29);

                    String resp30 = "";
                    switch (rg30.getCheckedRadioButtonId()){
                        case R.id.rbQ301m : resp30 = "MENOS DE 1 MES";break;
                        case R.id.rbQ3015m : resp30 = "1-5 MESES";break;
                        case R.id.rbQ30612m : resp30 = "6-12 MESES";break;
                        case R.id.rbQ301a : resp30 = "MAIS DE 1 ANO";break;
                    }
                    QuestaoResposta q30 = new QuestaoResposta(QuestoesResponsavel.Q30.getTexto(),resp30);

                    String resp31 = "";
                    switch (rg31.getCheckedRadioButtonId()){
                        case R.id.rbQ31Nada : resp31 = "NADA";break;
                        case R.id.rbQ31UP : resp31 = "UM POUCO";break;
                        case R.id.rbQ31M : resp31 = "MUITO";break;
                        case R.id.rbQ31MM : resp31 = "MAIS QUE MUITO";break;
                    }
                    QuestaoResposta q31 = new QuestaoResposta(QuestoesResponsavel.Q31.getTexto(),resp31);

                    String resp32sub1 = "";
                    switch (rg32sub1.getCheckedRadioButtonId()){
                        case R.id.rbQ32sub1N : resp32sub1 = "NADA";break;
                        case R.id.rbQ32sub1UP : resp32sub1 = "UM POUCO";break;
                        case R.id.rbQ32sub1M : resp32sub1 = "MUITO";break;
                        case R.id.rbQ32sub1MM : resp32sub1 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub1 = new SubQuestoes(QuestoesResponsavel.Q32sub1.getTexto(),resp32sub1);

                    String resp32sub2 = "";
                    switch (rg32sub2.getCheckedRadioButtonId()){
                        case R.id.rbQ32sub2N : resp32sub2 = "NADA";break;
                        case R.id.rbQ32sub2UP : resp32sub2 = "UM POUCO";break;
                        case R.id.rbQ32sub2M : resp32sub2 = "MUITO";break;
                        case R.id.rbQ32sub2MM : resp32sub2 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub2 = new SubQuestoes(QuestoesResponsavel.Q32sub2.getTexto(),resp32sub2);

                    String resp32sub3 = "";
                    switch (rg32sub3.getCheckedRadioButtonId()){
                        case R.id.rbQ32sub3N : resp32sub3 = "NADA";break;
                        case R.id.rbQ32sub3UP : resp32sub3 = "UM POUCO";break;
                        case R.id.rbQ32sub3M : resp32sub3 = "MUITO";break;
                        case R.id.rbQ32sub3MM : resp32sub3 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub3 = new SubQuestoes(QuestoesResponsavel.Q32sub3.getTexto(),resp32sub3);

                    String resp32sub4 = "";
                    switch (rg32sub4.getCheckedRadioButtonId()){
                        case R.id.rbQ32sub4N : resp32sub4 = "NADA";break;
                        case R.id.rbQ32sub4UP : resp32sub4 = "UM POUCO";break;
                        case R.id.rbQ32sub4M : resp32sub4 = "MUITO";break;
                        case R.id.rbQ32sub4MM : resp32sub4 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub4 = new SubQuestoes(QuestoesResponsavel.Q32sub4.getTexto(),resp32sub4); // Corrigido de questao sub1 para sub4

                    RealmList<SubQuestoes> subQuestoes = new RealmList<SubQuestoes>();
                    subQuestoes.add(sub1);
                    subQuestoes.add(sub2);
                    subQuestoes.add(sub3);
                    subQuestoes.add(sub4);

                    QuestaoResposta q32 = new QuestaoResposta(QuestoesResponsavel.Q32.getTexto());
                    q32.setSubQuestoes(subQuestoes);
                    q32.setResposta("");

                    String resp33 = "";
                    switch (rg33.getCheckedRadioButtonId()){
                        case R.id.rbQ33Nada : resp33 = "NADA";break;
                        case R.id.rbQ33UP : resp33 = "UM POUCO";break;
                        case R.id.rbQ33M : resp33 = "MUITO";break;
                        case R.id.rbQ33MM : resp33 = "MAIS QUE MUITO";break;
                    }
                    // Corrigido. Antes era 31
                    QuestaoResposta q33 = new QuestaoResposta(QuestoesResponsavel.Q33.getTexto(),resp33);

                    QuestaoResposta q34 = new QuestaoResposta(QuestoesResponsavel.Q34.getTexto(),rq34.getText().toString());
                    QuestaoResposta q35 = new QuestaoResposta(QuestoesResponsavel.Q35.getTexto(),rq35.getText().toString());
                    QuestaoResposta q36 = new QuestaoResposta(QuestoesResponsavel.Q36.getTexto(),rq36.getText().toString());

                    //AtomicLong atomicLong = new AtomicLong(realm.where(Questionario.class).max("id").longValue());

                    realm.beginTransaction();

                    // Definindo o id do questionário a ser cadastrado
                    List<Questionario> questionarios = realm.where(Questionario.class).findAll();
                    long id = questionarios.size() == 0 ? 1 : questionarios.get(questionarios.size()-1).getId() + 1;

                    Questionario questionario = new Questionario();
                    questionario.setId(id);

                    //Questionario questionario = realm.createObject(Questionario.class,atomicLong);

                    questionario.setTipo(TipoQuestionario.RESPONSAVEL.getTipo());

                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q1));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q2));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q3));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q4));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q5));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q6));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q7));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q8));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q9));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q10));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q11));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q12));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q13));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q14));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q15));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q16));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q17));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q18));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q19));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q20));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q21));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q22));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q23));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q24));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q25));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q26));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q27));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q28));

                    // Acrescentado o comentáio no questionário do responsável. Estava faltando.
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(comentario));

                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q29));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q30));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q31));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q32));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q33));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q34));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q35));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q36));

                    realm.copyToRealm(questionario);

                    realm.commitTransaction();

                    // Fechando a conexão. Muito importante.
                    realm.close();

                    // Corrigido o Toast. Estava sem a instrução show()
                    Toast.makeText(getApplicationContext(),"Questionário salvo com sucesso. Muito obrigado pela sua colaboração!",Toast.LENGTH_LONG).show();

                    // Melhorado a maneira de retornar para a tela principal
                    onBackPressed();

                    /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);*/

                }
            }
        });
    }

    private void somenteExibirQuestionario(String tipo, int position) {
        Questionario questionario = ResultadosDAO.getQuestionarioByPositionTipo(tipo, position);

        // nome
        String resp = questionario.getQuestaoRespostas().get(0).getResposta();
        rq1.setText(resp);
        rq1.setEnabled(false);

        // data
        resp = questionario.getQuestaoRespostas().get(1).getResposta();
        rq2.setText(resp);
        rq2.setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(2).getResposta();
        if(resp.equals("MASCULINO")){
            rg3.check(R.id.rbM);
        } else {
            rg3.check(R.id.rbF);
        }
        rg3.getChildAt(0).setEnabled(false);
        rg3.getChildAt(1).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(3).getResposta();
        switch (resp){
            case "FALSO": rg4.check(R.id.rbQ4Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg4.check(R.id.rbQ4MMV); break;
            case "VERDADEIRO": rg4.check(R.id.rbQ4Verdadeiro); break;
        }
        rg4.getChildAt(0).setEnabled(false);
        rg4.getChildAt(1).setEnabled(false);
        rg4.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(4).getResposta();
        switch (resp){
            case "FALSO": rg5.check(R.id.rbQ5Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg5.check(R.id.rbQ5MMV); break;
            case "VERDADEIRO": rg5.check(R.id.rbQ5Verdadeiro); break;
        }
        rg5.getChildAt(0).setEnabled(false);
        rg5.getChildAt(1).setEnabled(false);
        rg5.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(5).getResposta();
        switch (resp){
            case "FALSO": rg6.check(R.id.rbQ6Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg6.check(R.id.rbQ6MMV); break;
            case "VERDADEIRO": rg6.check(R.id.rbQ6Verdadeiro); break;
        }
        rg6.getChildAt(0).setEnabled(false);
        rg6.getChildAt(1).setEnabled(false);
        rg6.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(6).getResposta();
        switch (resp){
            case "FALSO": rg7.check(R.id.rbQ7Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg7.check(R.id.rbQ7MMV); break;
            case "VERDADEIRO": rg7.check(R.id.rbQ7Verdadeiro); break;
        }
        rg7.getChildAt(0).setEnabled(false);
        rg7.getChildAt(1).setEnabled(false);
        rg7.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(7).getResposta();
        switch (resp){
            case "FALSO": rg8.check(R.id.rbQ8Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg8.check(R.id.rbQ8MMV); break;
            case "VERDADEIRO": rg8.check(R.id.rbQ8Verdadeiro); break;
        }
        rg8.getChildAt(0).setEnabled(false);
        rg8.getChildAt(1).setEnabled(false);
        rg8.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(8).getResposta();
        switch (resp){
            case "FALSO": rg9.check(R.id.rbQ9Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg9.check(R.id.rbQ9MMV); break;
            case "VERDADEIRO": rg9.check(R.id.rbQ9Verdadeiro); break;
        }
        rg9.getChildAt(0).setEnabled(false);
        rg9.getChildAt(1).setEnabled(false);
        rg9.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(9).getResposta();
        switch (resp){
            case "FALSO": rg10.check(R.id.rbQ10Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg10.check(R.id.rbQ10MMV); break;
            case "VERDADEIRO": rg10.check(R.id.rbQ10Verdadeiro); break;
        }
        rg10.getChildAt(0).setEnabled(false);
        rg10.getChildAt(1).setEnabled(false);
        rg10.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(10).getResposta();
        switch (resp){
            case "FALSO": rg11.check(R.id.rbQ11Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg11.check(R.id.rbQ11MMV); break;
            case "VERDADEIRO": rg11.check(R.id.rbQ11Verdadeiro); break;
        }
        rg11.getChildAt(0).setEnabled(false);
        rg11.getChildAt(1).setEnabled(false);
        rg11.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(11).getResposta();
        switch (resp){
            case "FALSO": rg12.check(R.id.rbQ12Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg12.check(R.id.rbQ12MMV); break;
            case "VERDADEIRO": rg12.check(R.id.rbQ12Verdadeiro); break;
        }
        rg12.getChildAt(0).setEnabled(false);
        rg12.getChildAt(1).setEnabled(false);
        rg12.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(12).getResposta();
        switch (resp){
            case "FALSO": rg13.check(R.id.rbQ13Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg13.check(R.id.rbQ13MMV); break;
            case "VERDADEIRO": rg13.check(R.id.rbQ13Verdadeiro); break;
        }
        rg13.getChildAt(0).setEnabled(false);
        rg13.getChildAt(1).setEnabled(false);
        rg13.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(13).getResposta();
        switch (resp){
            case "FALSO": rg14.check(R.id.rbQ14Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg14.check(R.id.rbQ14MMV); break;
            case "VERDADEIRO": rg14.check(R.id.rbQ14Verdadeiro); break;
        }
        rg14.getChildAt(0).setEnabled(false);
        rg14.getChildAt(1).setEnabled(false);
        rg14.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(14).getResposta();
        switch (resp){
            case "FALSO": rg15.check(R.id.rbQ15Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg15.check(R.id.rbQ15MMV); break;
            case "VERDADEIRO": rg15.check(R.id.rbQ15Verdadeiro); break;
        }
        rg15.getChildAt(0).setEnabled(false);
        rg15.getChildAt(1).setEnabled(false);
        rg15.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(15).getResposta();
        switch (resp){
            case "FALSO": rg16.check(R.id.rbQ16Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg16.check(R.id.rbQ16MMV); break;
            case "VERDADEIRO": rg16.check(R.id.rbQ16Verdadeiro); break;
        }
        rg16.getChildAt(0).setEnabled(false);
        rg16.getChildAt(1).setEnabled(false);
        rg16.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(16).getResposta();
        switch (resp){
            case "FALSO": rg17.check(R.id.rbQ17Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg17.check(R.id.rbQ17MMV); break;
            case "VERDADEIRO": rg17.check(R.id.rbQ17Verdadeiro); break;
        }
        rg17.getChildAt(0).setEnabled(false);
        rg17.getChildAt(1).setEnabled(false);
        rg17.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(17).getResposta();
        switch (resp){
            case "FALSO": rg18.check(R.id.rbQ18Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg18.check(R.id.rbQ18MMV); break;
            case "VERDADEIRO": rg18.check(R.id.rbQ18Verdadeiro); break;
        }
        rg18.getChildAt(0).setEnabled(false);
        rg18.getChildAt(1).setEnabled(false);
        rg18.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(18).getResposta();
        switch (resp){
            case "FALSO": rg19.check(R.id.rbQ19Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg19.check(R.id.rbQ19MMV); break;
            case "VERDADEIRO": rg19.check(R.id.rbQ19Verdadeiro); break;
        }
        rg19.getChildAt(0).setEnabled(false);
        rg19.getChildAt(1).setEnabled(false);
        rg19.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(19).getResposta();
        switch (resp){
            case "FALSO": rg20.check(R.id.rbQ20Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg20.check(R.id.rbQ20MMV); break;
            case "VERDADEIRO": rg20.check(R.id.rbQ20Verdadeiro); break;
        }
        rg20.getChildAt(0).setEnabled(false);
        rg20.getChildAt(1).setEnabled(false);
        rg20.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(20).getResposta();
        switch (resp){
            case "FALSO": rg21.check(R.id.rbQ21Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg21.check(R.id.rbQ21MMV); break;
            case "VERDADEIRO": rg21.check(R.id.rbQ21Verdadeiro); break;
        }
        rg21.getChildAt(0).setEnabled(false);
        rg21.getChildAt(1).setEnabled(false);
        rg21.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(21).getResposta();
        switch (resp){
            case "FALSO": rg22.check(R.id.rbQ22Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg22.check(R.id.rbQ22MMV); break;
            case "VERDADEIRO": rg22.check(R.id.rbQ22Verdadeiro); break;
        }
        rg22.getChildAt(0).setEnabled(false);
        rg22.getChildAt(1).setEnabled(false);
        rg22.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(22).getResposta();
        switch (resp){
            case "FALSO": rg23.check(R.id.rbQ23Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg23.check(R.id.rbQ23MMV); break;
            case "VERDADEIRO": rg23.check(R.id.rbQ23Verdadeiro); break;
        }
        rg23.getChildAt(0).setEnabled(false);
        rg23.getChildAt(1).setEnabled(false);
        rg23.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(23).getResposta();
        switch (resp){
            case "FALSO": rg24.check(R.id.rbQ24Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg24.check(R.id.rbQ24MMV); break;
            case "VERDADEIRO": rg24.check(R.id.rbQ24Verdadeiro); break;
        }
        rg24.getChildAt(0).setEnabled(false);
        rg24.getChildAt(1).setEnabled(false);
        rg24.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(24).getResposta();
        switch (resp){
            case "FALSO": rg25.check(R.id.rbQ25Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg25.check(R.id.rbQ25MMV); break;
            case "VERDADEIRO": rg25.check(R.id.rbQ25Verdadeiro); break;
        }
        rg25.getChildAt(0).setEnabled(false);
        rg25.getChildAt(1).setEnabled(false);
        rg25.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(25).getResposta();
        switch (resp){
            case "FALSO": rg26.check(R.id.rbQ26Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg26.check(R.id.rbQ26MMV); break;
            case "VERDADEIRO": rg26.check(R.id.rbQ26Verdadeiro); break;
        }
        rg26.getChildAt(0).setEnabled(false);
        rg26.getChildAt(1).setEnabled(false);
        rg26.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(26).getResposta();
        switch (resp){
            case "FALSO": rg27.check(R.id.rbQ27Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg27.check(R.id.rbQ27MMV); break;
            case "VERDADEIRO": rg27.check(R.id.rbQ27Verdadeiro); break;
        }
        rg27.getChildAt(0).setEnabled(false);
        rg27.getChildAt(1).setEnabled(false);
        rg27.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(27).getResposta();
        switch (resp){
            case "FALSO": rg28.check(R.id.rbQ28Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg28.check(R.id.rbQ28MMV); break;
            case "VERDADEIRO": rg28.check(R.id.rbQ28Verdadeiro); break;
        }
        rg28.getChildAt(0).setEnabled(false);
        rg28.getChildAt(1).setEnabled(false);
        rg28.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(28).getResposta();
        rQcomentario.setText(resp);
        rQcomentario.setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(29).getResposta();
        switch (resp){
            case "NAO": rg29.check(R.id.rbQ29N); break;
            case "SIM PEQUENAS DIFICULDADES": rg29.check(R.id.rbQ29SPD); break;
            case "SIM DIFICULDADES BEM DEFINIDAS": rg29.check(R.id.rbQ29SDD);break;
            case "SIM DIFICULDADES GRAVES": rg29.check(R.id.rbQ29SDG);break;
        }
        rg29.getChildAt(0).setEnabled(false);
        rg29.getChildAt(1).setEnabled(false);
        rg29.getChildAt(2).setEnabled(false);
        rg29.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(30).getResposta();
        switch (resp){
            case "MENOS DE 1 MES": rg30.check(R.id.rbQ301m); break;
            case "1-5 MESES": rg30.check(R.id.rbQ3015m); break;
            case "6-12 MESES": rg30.check(R.id.rbQ30612m);break;
            case "MAIS DE 1 ANO": rg30.check(R.id.rbQ301a);break;
        }
        rg30.getChildAt(0).setEnabled(false);
        rg30.getChildAt(1).setEnabled(false);
        rg30.getChildAt(2).setEnabled(false);
        rg30.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(31).getResposta();
        switch (resp){
            case "NADA": rg31.check(R.id.rbQ31Nada); break;
            case "UM POUCO": rg31.check(R.id.rbQ31UP); break;
            case "MUITO": rg31.check(R.id.rbQ31M);break;
            case "MAIS QUE MUITO": rg31.check(R.id.rbQ31MM);break;
        }
        rg31.getChildAt(0).setEnabled(false);
        rg31.getChildAt(1).setEnabled(false);
        rg31.getChildAt(2).setEnabled(false);
        rg31.getChildAt(3).setEnabled(false);

        // Sub Questao 1 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(0).getResposta();
        switch (resp){
            case "NADA": rg32sub1.check(R.id.rbQ32sub1N); break;
            case "UM POUCO": rg32sub1.check(R.id.rbQ32sub1UP); break;
            case "MUITO": rg32sub1.check(R.id.rbQ32sub1M);break;
            case "MAIS QUE MUITO": rg32sub1.check(R.id.rbQ32sub1MM);break;
        }
        rg32sub1.getChildAt(0).setEnabled(false);
        rg32sub1.getChildAt(1).setEnabled(false);
        rg32sub1.getChildAt(2).setEnabled(false);
        rg32sub1.getChildAt(3).setEnabled(false);

        // Sub Questao 2 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(1).getResposta();
        switch (resp){
            case "NADA": rg32sub2.check(R.id.rbQ32sub2N); break;
            case "UM POUCO": rg32sub2.check(R.id.rbQ32sub2UP); break;
            case "MUITO": rg32sub2.check(R.id.rbQ32sub2M);break;
            case "MAIS QUE MUITO": rg32sub2.check(R.id.rbQ32sub2MM);break;
        }
        rg32sub2.getChildAt(0).setEnabled(false);
        rg32sub2.getChildAt(1).setEnabled(false);
        rg32sub2.getChildAt(2).setEnabled(false);
        rg32sub2.getChildAt(3).setEnabled(false);

        // Sub Questao 3 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(2).getResposta();
        switch (resp){
            case "NADA": rg32sub3.check(R.id.rbQ32sub3N); break;
            case "UM POUCO": rg32sub3.check(R.id.rbQ32sub3UP); break;
            case "MUITO": rg32sub3.check(R.id.rbQ32sub3M);break;
            case "MAIS QUE MUITO": rg32sub3.check(R.id.rbQ32sub3MM);break;
        }
        rg32sub3.getChildAt(0).setEnabled(false);
        rg32sub3.getChildAt(1).setEnabled(false);
        rg32sub3.getChildAt(2).setEnabled(false);
        rg32sub3.getChildAt(3).setEnabled(false);

        // Sub Questao 4 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(3).getResposta();
        switch (resp){
            case "NADA": rg32sub4.check(R.id.rbQ32sub4N); break;
            case "UM POUCO": rg32sub4.check(R.id.rbQ32sub4UP); break;
            case "MUITO": rg32sub4.check(R.id.rbQ32sub4M);break;
            case "MAIS QUE MUITO": rg32sub4.check(R.id.rbQ32sub4MM);break;
        }
        rg32sub4.getChildAt(0).setEnabled(false);
        rg32sub4.getChildAt(1).setEnabled(false);
        rg32sub4.getChildAt(2).setEnabled(false);
        rg32sub4.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(33).getResposta();
        switch (resp){
            case "NADA": rg33.check(R.id.rbQ33Nada); break;
            case "UM POUCO": rg33.check(R.id.rbQ33UP); break;
            case "MUITO": rg33.check(R.id.rbQ33M);break;
            case "MAIS QUE MUITO": rg33.check(R.id.rbQ33MM);break;
        }
        rg33.getChildAt(0).setEnabled(false);
        rg33.getChildAt(1).setEnabled(false);
        rg33.getChildAt(2).setEnabled(false);
        rg33.getChildAt(3).setEnabled(false);

        // nome completo
        resp = questionario.getQuestaoRespostas().get(34).getResposta();
        rq34.setText(resp);
        rq34.setEnabled(false);

        // data de hoje
        resp = questionario.getQuestaoRespostas().get(35).getResposta();
        rq35.setText(resp);
        rq35.setEnabled(false);

        // mae,pai,outro
        resp = questionario.getQuestaoRespostas().get(36).getResposta();
        rq36.setText(resp);
        rq36.setEnabled(false);

        salvar.setEnabled(false);
        salvar.setVisibility(View.INVISIBLE);

    }

}
