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

import com.developer.barbosa.sdq.enums.QuestoesAlunos;
import com.developer.barbosa.sdq.R;
import com.developer.barbosa.sdq.enums.QuestoesAlunos;
import com.developer.barbosa.sdq.enums.QuestoesResponsavel;
import com.developer.barbosa.sdq.enums.TipoQuestionario;
import com.developer.barbosa.sdq.model.QuestaoResposta;
import com.developer.barbosa.sdq.model.Questionario;
import com.developer.barbosa.sdq.model.ResultadosDAO;
import com.developer.barbosa.sdq.model.SubQuestoes;
import com.developer.barbosa.sdq.util.Mascara;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class AlunoActivity extends AppCompatActivity {

    EditText rq1,rq2;
    RadioGroup rg3;
    TextView q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,
            q26,q27,q28,qComentario,q29,q30,q31,q32,q32sub1,q32sub2,q32sub3,q32sub4,q33,q34,q35;
    RadioGroup rg4,rg5,rg6,rg7,rg8,rg9,rg10,rg11,rg12,rg13,rg14,rg15,rg16,rg17,rg18,rg19,rg20,rg21,rg22,
            rg23,rg24,rg25,rg26,rg27,rg28,rg29,rg30,rg31,rg32sub1,rg32sub2,rg32sub3,rg32sub4,rg33;
    EditText rQcomentario,rq34,rq35;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#763b5c")));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Realm realm = Realm.getDefaultInstance();

        rq1 = (EditText) findViewById(R.id.arQ1);

        rq2 = (EditText) findViewById(R.id.arQ2);
        rq2.addTextChangedListener(Mascara.insert("##/##/####", rq2));

        rg3 = (RadioGroup) findViewById(R.id.arQ3);

        q4 = (TextView) findViewById(R.id.aQ4);
        q4.setText(QuestoesAlunos.Q4.getTexto());
        rg4 = (RadioGroup) findViewById(R.id.arQ4);

        q5 = (TextView) findViewById(R.id.aQ5);
        q5.setText(QuestoesAlunos.Q5.getTexto());
        rg5 = (RadioGroup) findViewById(R.id.arQ5);

        q6 = (TextView) findViewById(R.id.aQ6);
        q6.setText(QuestoesAlunos.Q6.getTexto());
        rg6 = (RadioGroup) findViewById(R.id.arQ6);

        q7 = (TextView) findViewById(R.id.aQ7);
        q7.setText(QuestoesAlunos.Q7.getTexto());
        rg7 = (RadioGroup) findViewById(R.id.arQ7);

        q8 = (TextView) findViewById(R.id.aQ8);
        q8.setText(QuestoesAlunos.Q8.getTexto());
        rg8 = (RadioGroup) findViewById(R.id.arQ8);

        q9 = (TextView) findViewById(R.id.aQ9);
        q9.setText(QuestoesAlunos.Q9.getTexto());
        rg9 = (RadioGroup) findViewById(R.id.arQ9);

        q10 = (TextView) findViewById(R.id.aQ10);
        q10.setText(QuestoesAlunos.Q10.getTexto());
        rg10 = (RadioGroup) findViewById(R.id.arQ10);

        q11 = (TextView) findViewById(R.id.aQ11);
        q11.setText(QuestoesAlunos.Q11.getTexto());
        rg11 = (RadioGroup) findViewById(R.id.arQ11);

        q12 = (TextView) findViewById(R.id.aQ12);
        q12.setText(QuestoesAlunos.Q12.getTexto());
        rg12 = (RadioGroup) findViewById(R.id.arQ12);

        q13 = (TextView) findViewById(R.id.aQ13);
        q13.setText(QuestoesAlunos.Q13.getTexto());
        rg13 = (RadioGroup) findViewById(R.id.arQ13);

        q14 = (TextView) findViewById(R.id.aQ14);
        q14.setText(QuestoesAlunos.Q14.getTexto());
        rg14 = (RadioGroup) findViewById(R.id.arQ14);

        q15 = (TextView) findViewById(R.id.aQ15);
        q15.setText(QuestoesAlunos.Q15.getTexto());
        rg15 = (RadioGroup) findViewById(R.id.arQ15);

        q16 = (TextView) findViewById(R.id.aQ16);
        q16.setText(QuestoesAlunos.Q16.getTexto());
        rg16 = (RadioGroup) findViewById(R.id.arQ16);

        q17 = (TextView) findViewById(R.id.aQ17);
        q17.setText(QuestoesAlunos.Q17.getTexto());
        rg17 = (RadioGroup) findViewById(R.id.arQ17);

        q18 = (TextView) findViewById(R.id.aQ18);
        q18.setText(QuestoesAlunos.Q18.getTexto());
        rg18 = (RadioGroup) findViewById(R.id.arQ18);

        q19 = (TextView) findViewById(R.id.aQ19);
        q19.setText(QuestoesAlunos.Q19.getTexto());
        rg19 = (RadioGroup) findViewById(R.id.arQ19);

        q20 = (TextView) findViewById(R.id.aQ20);
        q20.setText(QuestoesAlunos.Q20.getTexto());
        rg20 = (RadioGroup) findViewById(R.id.arQ20);

        q21 = (TextView) findViewById(R.id.aQ21);
        q21.setText(QuestoesAlunos.Q21.getTexto());
        rg21 = (RadioGroup) findViewById(R.id.arQ21);

        q22 = (TextView) findViewById(R.id.aQ22);
        q22.setText(QuestoesAlunos.Q22.getTexto());
        rg22 = (RadioGroup) findViewById(R.id.arQ22);

        q23 = (TextView) findViewById(R.id.aQ23);
        q23.setText(QuestoesAlunos.Q23.getTexto());
        rg23 = (RadioGroup) findViewById(R.id.arQ23);

        q24 = (TextView) findViewById(R.id.aQ24);
        q24.setText(QuestoesAlunos.Q24.getTexto());
        rg24 = (RadioGroup) findViewById(R.id.arQ24);

        q25 = (TextView) findViewById(R.id.aQ25);
        q25.setText(QuestoesAlunos.Q25.getTexto());
        rg25 = (RadioGroup) findViewById(R.id.arQ25);

        q26 = (TextView) findViewById(R.id.aQ26);
        q26.setText(QuestoesAlunos.Q26.getTexto());
        rg26 = (RadioGroup) findViewById(R.id.arQ26);

        q27 = (TextView) findViewById(R.id.aQ27);
        q27.setText(QuestoesAlunos.Q27.getTexto());
        rg27 = (RadioGroup) findViewById(R.id.arQ27);

        q28 = (TextView) findViewById(R.id.aQ28);
        q28.setText(QuestoesAlunos.Q28.getTexto());
        rg28 = (RadioGroup) findViewById(R.id.arQ28);

        qComentario = (TextView) findViewById(R.id.aQcomentario);
        qComentario.setText(QuestoesAlunos.QComentario.getTexto());
        rQcomentario = (EditText) findViewById(R.id.arQcomentario);

        q29 = (TextView) findViewById(R.id.aQ29);
        q29.setText(QuestoesAlunos.Q29.getTexto());
        rg29 = (RadioGroup) findViewById(R.id.arQ29);

        q30 = (TextView) findViewById(R.id.aQ30);
        q30.setText(QuestoesAlunos.Q30.getTexto());
        rg30 = (RadioGroup) findViewById(R.id.arQ30);

        q31 = (TextView) findViewById(R.id.aQ31);
        q31.setText(QuestoesAlunos.Q31.getTexto());
        rg31 = (RadioGroup) findViewById(R.id.arQ31);

        q32 = (TextView) findViewById(R.id.aQ32);
        q32.setText(QuestoesAlunos.Q32.getTexto());

        q32sub1 = (TextView) findViewById(R.id.aQ32sub1);
        q32sub1.setText(QuestoesAlunos.Q32sub1.getTexto());
        rg32sub1 = (RadioGroup) findViewById(R.id.arQ32sub1);

        q32sub2 = (TextView) findViewById(R.id.aQ32sub2);
        q32sub2.setText(QuestoesAlunos.Q32sub2.getTexto());
        rg32sub2 = (RadioGroup) findViewById(R.id.arQ32sub2);

        q32sub3 = (TextView) findViewById(R.id.aQ32sub3);
        q32sub3.setText(QuestoesAlunos.Q32sub3.getTexto());
        rg32sub3 = (RadioGroup) findViewById(R.id.arQ32sub3);

        q32sub4 = (TextView) findViewById(R.id.aQ32sub4);
        q32sub4.setText(QuestoesAlunos.Q32sub4.getTexto());
        rg32sub4 = (RadioGroup) findViewById(R.id.arQ32sub4);

        q33 = (TextView) findViewById(R.id.aQ33);
        q33.setText(QuestoesAlunos.Q33.getTexto());
        rg33 = (RadioGroup) findViewById(R.id.arQ33);

        q34 = (TextView) findViewById(R.id.aQ34);
        q34.setText(QuestoesAlunos.Q34.getTexto());
        rq34 = (EditText) findViewById(R.id.arQ34);

        q35 = (TextView) findViewById(R.id.aQ35);
        q35.setText(QuestoesAlunos.Q35.getTexto());
        rq35 = (EditText) findViewById(R.id.arQ35);
        rq35.addTextChangedListener(Mascara.insert("##/##/####", rq35));

        salvar = (Button) findViewById(R.id.btnaSalvar);

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
                        || rq35.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Selecione todos os campos!",Toast.LENGTH_LONG).show();
                } else {
                    QuestaoResposta q1 = new QuestaoResposta(QuestoesAlunos.Q1.getTexto(),rq1.getText().toString());
                    QuestaoResposta q2 = new QuestaoResposta(QuestoesAlunos.Q2.getTexto(),rq2.getText().toString());

                    String resp3 = "";
                    switch (rg3.getCheckedRadioButtonId()){
                        case R.id.arbM : resp3 = "MASCULINO";break;
                        case R.id.arbF : resp3 = "FEMININO";break;
                    }
                    QuestaoResposta q3 = new QuestaoResposta(QuestoesAlunos.Q3.getTexto(),resp3);

                    String resp4 = "";
                    switch (rg4.getCheckedRadioButtonId()){
                        case R.id.arbQ4Falso : resp4 = "FALSO";break;
                        case R.id.arbQ4MMV : resp4 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ4Verdadeiro : resp4 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q4 = new QuestaoResposta(QuestoesAlunos.Q4.getTexto(),resp4);

                    String resp5 = "";
                    switch (rg5.getCheckedRadioButtonId()){
                        case R.id.arbQ5Falso : resp5 = "FALSO";break;
                        case R.id.arbQ5MMV : resp5 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ5Verdadeiro : resp5 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q5 = new QuestaoResposta(QuestoesAlunos.Q5.getTexto(),resp5);

                    String resp6 = "";
                    switch (rg6.getCheckedRadioButtonId()){
                        case R.id.arbQ6Falso : resp6 = "FALSO";break;
                        case R.id.arbQ6MMV : resp6 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ6Verdadeiro : resp6 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q6 = new QuestaoResposta(QuestoesAlunos.Q6.getTexto(),resp6);

                    String resp7 = "";
                    switch (rg7.getCheckedRadioButtonId()){
                        case R.id.arbQ7Falso : resp7 = "FALSO";break;
                        case R.id.arbQ7MMV : resp7 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ7Verdadeiro : resp7 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q7 = new QuestaoResposta(QuestoesAlunos.Q7.getTexto(),resp7);

                    String resp8 = "";
                    switch (rg8.getCheckedRadioButtonId()){
                        case R.id.arbQ8Falso : resp8 = "FALSO";break;
                        case R.id.arbQ8MMV : resp8 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ8Verdadeiro : resp8 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q8 = new QuestaoResposta(QuestoesAlunos.Q8.getTexto(),resp8);

                    String resp9 = "";
                    switch (rg9.getCheckedRadioButtonId()){
                        case R.id.arbQ9Falso : resp9 = "FALSO";break;
                        case R.id.arbQ9MMV : resp9 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ9Verdadeiro : resp9 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q9 = new QuestaoResposta(QuestoesAlunos.Q9.getTexto(),resp9);

                    String resp10 = "";
                    switch (rg10.getCheckedRadioButtonId()){
                        case R.id.arbQ10Falso : resp10 = "FALSO";break;
                        case R.id.arbQ10MMV : resp10 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ10Verdadeiro : resp10 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q10 = new QuestaoResposta(QuestoesAlunos.Q10.getTexto(),resp10);

                    String resp11 = "";
                    switch (rg11.getCheckedRadioButtonId()){
                        case R.id.arbQ11Falso : resp11 = "FALSO";break;
                        case R.id.arbQ11MMV : resp11 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ11Verdadeiro : resp11 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q11 = new QuestaoResposta(QuestoesAlunos.Q11.getTexto(),resp11);

                    String resp12 = "";
                    switch (rg12.getCheckedRadioButtonId()){
                        case R.id.arbQ12Falso : resp12 = "FALSO";break;
                        case R.id.arbQ12MMV : resp12 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ12Verdadeiro : resp12 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q12 = new QuestaoResposta(QuestoesAlunos.Q12.getTexto(),resp12);

                    String resp13 = "";
                    switch (rg13.getCheckedRadioButtonId()){
                        case R.id.arbQ13Falso : resp13 = "FALSO";break;
                        case R.id.arbQ13MMV : resp13 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ13Verdadeiro : resp13 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q13 = new QuestaoResposta(QuestoesAlunos.Q13.getTexto(),resp13);

                    String resp14 = "";
                    switch (rg14.getCheckedRadioButtonId()){
                        case R.id.arbQ14Falso : resp14 = "FALSO";break;
                        case R.id.arbQ14MMV : resp14 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ14Verdadeiro : resp14 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q14 = new QuestaoResposta(QuestoesAlunos.Q14.getTexto(),resp14);

                    String resp15 = "";
                    switch (rg15.getCheckedRadioButtonId()){
                        case R.id.arbQ15Falso : resp15 = "FALSO";break;
                        case R.id.arbQ15MMV : resp15 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ15Verdadeiro : resp15 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q15 = new QuestaoResposta(QuestoesAlunos.Q15.getTexto(),resp15);

                    String resp16 = "";
                    switch (rg16.getCheckedRadioButtonId()){
                        case R.id.arbQ16Falso : resp16 = "FALSO";break;
                        case R.id.arbQ16MMV : resp16 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ16Verdadeiro : resp16 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q16 = new QuestaoResposta(QuestoesAlunos.Q16.getTexto(),resp16);

                    String resp17 = "";
                    switch (rg17.getCheckedRadioButtonId()){
                        case R.id.arbQ17Falso : resp17 = "FALSO";break;
                        case R.id.arbQ17MMV : resp17 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ17Verdadeiro : resp17 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q17 = new QuestaoResposta(QuestoesAlunos.Q17.getTexto(),resp17);

                    String resp18 = "";
                    switch (rg18.getCheckedRadioButtonId()){
                        case R.id.arbQ18Falso : resp18 = "FALSO";break;
                        case R.id.arbQ18MMV : resp18 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ18Verdadeiro : resp18 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q18 = new QuestaoResposta(QuestoesAlunos.Q18.getTexto(),resp18);

                    String resp19 = "";
                    switch (rg19.getCheckedRadioButtonId()){
                        case R.id.arbQ19Falso : resp19 = "FALSO";break;
                        case R.id.arbQ19MMV : resp19 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ19Verdadeiro : resp19 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q19 = new QuestaoResposta(QuestoesAlunos.Q19.getTexto(),resp19);

                    String resp20 = "";
                    switch (rg20.getCheckedRadioButtonId()){
                        case R.id.arbQ20Falso : resp20 = "FALSO";break;
                        case R.id.arbQ20MMV : resp20 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ20Verdadeiro : resp20 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q20 = new QuestaoResposta(QuestoesAlunos.Q20.getTexto(),resp20);

                    String resp21 = "";
                    switch (rg21.getCheckedRadioButtonId()){
                        case R.id.arbQ21Falso : resp21 = "FALSO";break;
                        case R.id.arbQ21MMV : resp21 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ21Verdadeiro : resp21 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q21 = new QuestaoResposta(QuestoesAlunos.Q21.getTexto(),resp21);

                    String resp22 = "";
                    switch (rg22.getCheckedRadioButtonId()){
                        case R.id.arbQ22Falso : resp22 = "FALSO";break;
                        case R.id.arbQ22MMV : resp22 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ22Verdadeiro : resp22 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q22 = new QuestaoResposta(QuestoesAlunos.Q22.getTexto(),resp22);

                    String resp23 = "";
                    switch (rg23.getCheckedRadioButtonId()){
                        case R.id.arbQ23Falso : resp23 = "FALSO";break;
                        case R.id.arbQ23MMV : resp23 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ23Verdadeiro : resp23 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q23 = new QuestaoResposta(QuestoesAlunos.Q23.getTexto(),resp23);

                    String resp24 = "";
                    switch (rg24.getCheckedRadioButtonId()){
                        case R.id.arbQ24Falso : resp24 = "FALSO";break;
                        case R.id.arbQ24MMV : resp24 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ24Verdadeiro : resp24 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q24 = new QuestaoResposta(QuestoesAlunos.Q24.getTexto(),resp24);

                    String resp25 = "";
                    switch (rg25.getCheckedRadioButtonId()){
                        case R.id.arbQ25Falso : resp25 = "FALSO";break;
                        case R.id.arbQ25MMV : resp25 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ25Verdadeiro : resp25 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q25 = new QuestaoResposta(QuestoesAlunos.Q25.getTexto(),resp25);

                    String resp26 = "";
                    switch (rg26.getCheckedRadioButtonId()){
                        case R.id.arbQ26Falso : resp26 = "FALSO";break;
                        case R.id.arbQ26MMV : resp26 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ26Verdadeiro : resp26 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q26 = new QuestaoResposta(QuestoesAlunos.Q26.getTexto(),resp26);

                    String resp27 = "";
                    switch (rg27.getCheckedRadioButtonId()){
                        case R.id.arbQ27Falso : resp27 = "FALSO";break;
                        case R.id.arbQ27MMV : resp27 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ27Verdadeiro : resp27 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q27 = new QuestaoResposta(QuestoesAlunos.Q27.getTexto(),resp27);

                    String resp28 = "";
                    switch (rg28.getCheckedRadioButtonId()){
                        case R.id.arbQ28Falso : resp28 = "FALSO";break;
                        case R.id.arbQ28MMV : resp28 = "MAIS OU MENOS VERDADEIRO";break;
                        case R.id.arbQ28Verdadeiro : resp28 = "VERDADEIRO";break;
                    }
                    QuestaoResposta q28 = new QuestaoResposta(QuestoesAlunos.Q28.getTexto(),resp28);

                    QuestaoResposta comentario = new QuestaoResposta(QuestoesAlunos.QComentario.getTexto(),rQcomentario.getText().toString());

                    String resp29 = "";
                    switch (rg29.getCheckedRadioButtonId()){
                        case R.id.arbQ29N : resp29 = "NAO";break;
                        case R.id.arbQ29SPD : resp29 = "SIM PEQUENAS DIFICULDADES";break;
                        case R.id.arbQ29SDD : resp29 = "SIM DIFICULDADES BEM DEFINIDAS";break;
                        case R.id.arbQ29SDG : resp29 = "SIM DIFICULDADES GRAVES";break;
                    }
                    QuestaoResposta q29 = new QuestaoResposta(QuestoesAlunos.Q29.getTexto(),resp29);

                    String resp30 = "";
                    switch (rg30.getCheckedRadioButtonId()){
                        case R.id.arbQ301m : resp30 = "MENOS DE 1 MES";break;
                        case R.id.arbQ3015m : resp30 = "1-5 MESES";break;
                        case R.id.arbQ30612m : resp30 = "6-12 MESES";break;
                        case R.id.arbQ301a : resp30 = "MAIS DE 1 ANO";break;
                    }
                    QuestaoResposta q30 = new QuestaoResposta(QuestoesAlunos.Q30.getTexto(),resp30);

                    String resp31 = "";
                    switch (rg31.getCheckedRadioButtonId()){
                        case R.id.arbQ31Nada : resp31 = "NADA";break;
                        case R.id.arbQ31UP : resp31 = "UM POUCO";break;
                        case R.id.arbQ31M : resp31 = "MUITO";break;
                        case R.id.arbQ31MM : resp31 = "MAIS QUE MUITO";break;
                    }
                    QuestaoResposta q31 = new QuestaoResposta(QuestoesAlunos.Q31.getTexto(),resp31);

                    String resp32sub1 = "";
                    switch (rg32sub1.getCheckedRadioButtonId()){
                        case R.id.arbQ32sub1N : resp32sub1 = "NADA";break;
                        case R.id.arbQ32sub1UP : resp32sub1 = "UM POUCO";break;
                        case R.id.arbQ32sub1M : resp32sub1 = "MUITO";break;
                        case R.id.arbQ32sub1MM : resp32sub1 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub1 = new SubQuestoes(QuestoesAlunos.Q32sub1.getTexto(),resp32sub1);

                    String resp32sub2 = "";
                    switch (rg32sub2.getCheckedRadioButtonId()){
                        case R.id.arbQ32sub2N : resp32sub2 = "NADA";break;
                        case R.id.arbQ32sub2UP : resp32sub2 = "UM POUCO";break;
                        case R.id.arbQ32sub2M : resp32sub2 = "MUITO";break;
                        case R.id.arbQ32sub2MM : resp32sub2 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub2 = new SubQuestoes(QuestoesAlunos.Q32sub2.getTexto(),resp32sub2);

                    String resp32sub3 = "";
                    switch (rg32sub3.getCheckedRadioButtonId()){
                        case R.id.arbQ32sub3N : resp32sub3 = "NADA";break;
                        case R.id.arbQ32sub3UP : resp32sub3 = "UM POUCO";break;
                        case R.id.arbQ32sub3M : resp32sub3 = "MUITO";break;
                        case R.id.arbQ32sub3MM : resp32sub3 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub3 = new SubQuestoes(QuestoesAlunos.Q32sub3.getTexto(),resp32sub3);

                    String resp32sub4 = "";
                    switch (rg32sub4.getCheckedRadioButtonId()){
                        case R.id.arbQ32sub4N : resp32sub4 = "NADA";break;
                        case R.id.arbQ32sub4UP : resp32sub4 = "UM POUCO";break;
                        case R.id.arbQ32sub4M : resp32sub4 = "MUITO";break;
                        case R.id.arbQ32sub4MM : resp32sub4 = "MAIS QUE MUITO";break;
                    }
                    SubQuestoes sub4 = new SubQuestoes(QuestoesAlunos.Q32sub4.getTexto(),resp32sub4);

                    RealmList<SubQuestoes> subQuestoes = new RealmList<SubQuestoes>();
                    subQuestoes.add(sub1);
                    subQuestoes.add(sub2);
                    subQuestoes.add(sub3);
                    subQuestoes.add(sub4);

                    QuestaoResposta q32 = new QuestaoResposta(QuestoesAlunos.Q32.getTexto());
                    q32.setSubQuestoes(subQuestoes);
                    q32.setResposta("");

                    String resp33 = "";
                    switch (rg33.getCheckedRadioButtonId()){
                        case R.id.arbQ33Nada : resp33 = "NADA";break;
                        case R.id.arbQ33UP : resp33 = "UM POUCO";break;
                        case R.id.arbQ33M : resp33 = "MUITO";break;
                        case R.id.arbQ33MM : resp33 = "MAIS QUE MUITO";break;
                    }
                    QuestaoResposta q33 = new QuestaoResposta(QuestoesAlunos.Q33.getTexto(),resp33);

                    QuestaoResposta q34 = new QuestaoResposta(QuestoesResponsavel.Q34.getTexto(),rq34.getText().toString());
                    QuestaoResposta q35 = new QuestaoResposta(QuestoesResponsavel.Q35.getTexto(),rq35.getText().toString());

                    realm.beginTransaction();

                    List<Questionario> questionarios = realm.where(Questionario.class).findAll();
                    long id = questionarios.size() == 0 ? 1 : questionarios.get(questionarios.size()-1).getId() + 1;

                    Questionario questionario = new Questionario();
                    questionario.setId(id);
                    questionario.setTipo(TipoQuestionario.ALUNOS.getTipo());

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

                    // Questao comentario
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(comentario));

                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q29));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q30));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q31));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q32));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q33));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q34));
                    questionario.getQuestaoRespostas().add(realm.copyToRealm(q35));

                    realm.copyToRealm(questionario);

                    realm.commitTransaction();

                    realm.close();

                    Toast.makeText(getApplicationContext(),"Questionário salvo com sucesso. Muito obrigado pela sua ajuda!",Toast.LENGTH_LONG).show();

                    onBackPressed();

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
            rg3.check(R.id.arbM);
        } else {
            rg3.check(R.id.arbF);
        }
        rg3.getChildAt(0).setEnabled(false);
        rg3.getChildAt(1).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(3).getResposta();
        switch (resp){
            case "FALSO": rg4.check(R.id.arbQ4Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg4.check(R.id.arbQ4MMV); break;
            case "VERDADEIRO": rg4.check(R.id.arbQ4Verdadeiro); break;
        }
        rg4.getChildAt(0).setEnabled(false);
        rg4.getChildAt(1).setEnabled(false);
        rg4.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(4).getResposta();
        switch (resp){
            case "FALSO": rg5.check(R.id.arbQ5Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg5.check(R.id.arbQ5MMV); break;
            case "VERDADEIRO": rg5.check(R.id.arbQ5Verdadeiro); break;
        }
        rg5.getChildAt(0).setEnabled(false);
        rg5.getChildAt(1).setEnabled(false);
        rg5.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(5).getResposta();
        switch (resp){
            case "FALSO": rg6.check(R.id.arbQ6Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg6.check(R.id.arbQ6MMV); break;
            case "VERDADEIRO": rg6.check(R.id.arbQ6Verdadeiro); break;
        }
        rg6.getChildAt(0).setEnabled(false);
        rg6.getChildAt(1).setEnabled(false);
        rg6.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(6).getResposta();
        switch (resp){
            case "FALSO": rg7.check(R.id.arbQ7Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg7.check(R.id.arbQ7MMV); break;
            case "VERDADEIRO": rg7.check(R.id.arbQ7Verdadeiro); break;
        }
        rg7.getChildAt(0).setEnabled(false);
        rg7.getChildAt(1).setEnabled(false);
        rg7.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(7).getResposta();
        switch (resp){
            case "FALSO": rg8.check(R.id.arbQ8Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg8.check(R.id.arbQ8MMV); break;
            case "VERDADEIRO": rg8.check(R.id.arbQ8Verdadeiro); break;
        }
        rg8.getChildAt(0).setEnabled(false);
        rg8.getChildAt(1).setEnabled(false);
        rg8.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(8).getResposta();
        switch (resp){
            case "FALSO": rg9.check(R.id.arbQ9Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg9.check(R.id.arbQ9MMV); break;
            case "VERDADEIRO": rg9.check(R.id.arbQ9Verdadeiro); break;
        }
        rg9.getChildAt(0).setEnabled(false);
        rg9.getChildAt(1).setEnabled(false);
        rg9.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(9).getResposta();
        switch (resp){
            case "FALSO": rg10.check(R.id.arbQ10Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg10.check(R.id.arbQ10MMV); break;
            case "VERDADEIRO": rg10.check(R.id.arbQ10Verdadeiro); break;
        }
        rg10.getChildAt(0).setEnabled(false);
        rg10.getChildAt(1).setEnabled(false);
        rg10.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(10).getResposta();
        switch (resp){
            case "FALSO": rg11.check(R.id.arbQ11Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg11.check(R.id.arbQ11MMV); break;
            case "VERDADEIRO": rg11.check(R.id.arbQ11Verdadeiro); break;
        }
        rg11.getChildAt(0).setEnabled(false);
        rg11.getChildAt(1).setEnabled(false);
        rg11.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(11).getResposta();
        switch (resp){
            case "FALSO": rg12.check(R.id.arbQ12Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg12.check(R.id.arbQ12MMV); break;
            case "VERDADEIRO": rg12.check(R.id.arbQ12Verdadeiro); break;
        }
        rg12.getChildAt(0).setEnabled(false);
        rg12.getChildAt(1).setEnabled(false);
        rg12.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(12).getResposta();
        switch (resp){
            case "FALSO": rg13.check(R.id.arbQ13Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg13.check(R.id.arbQ13MMV); break;
            case "VERDADEIRO": rg13.check(R.id.arbQ13Verdadeiro); break;
        }
        rg13.getChildAt(0).setEnabled(false);
        rg13.getChildAt(1).setEnabled(false);
        rg13.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(13).getResposta();
        switch (resp){
            case "FALSO": rg14.check(R.id.arbQ14Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg14.check(R.id.arbQ14MMV); break;
            case "VERDADEIRO": rg14.check(R.id.arbQ14Verdadeiro); break;
        }
        rg14.getChildAt(0).setEnabled(false);
        rg14.getChildAt(1).setEnabled(false);
        rg14.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(14).getResposta();
        switch (resp){
            case "FALSO": rg15.check(R.id.arbQ15Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg15.check(R.id.arbQ15MMV); break;
            case "VERDADEIRO": rg15.check(R.id.arbQ15Verdadeiro); break;
        }
        rg15.getChildAt(0).setEnabled(false);
        rg15.getChildAt(1).setEnabled(false);
        rg15.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(15).getResposta();
        switch (resp){
            case "FALSO": rg16.check(R.id.arbQ16Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg16.check(R.id.arbQ16MMV); break;
            case "VERDADEIRO": rg16.check(R.id.arbQ16Verdadeiro); break;
        }
        rg16.getChildAt(0).setEnabled(false);
        rg16.getChildAt(1).setEnabled(false);
        rg16.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(16).getResposta();
        switch (resp){
            case "FALSO": rg17.check(R.id.arbQ17Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg17.check(R.id.arbQ17MMV); break;
            case "VERDADEIRO": rg17.check(R.id.arbQ17Verdadeiro); break;
        }
        rg17.getChildAt(0).setEnabled(false);
        rg17.getChildAt(1).setEnabled(false);
        rg17.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(17).getResposta();
        switch (resp){
            case "FALSO": rg18.check(R.id.arbQ18Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg18.check(R.id.arbQ18MMV); break;
            case "VERDADEIRO": rg18.check(R.id.arbQ18Verdadeiro); break;
        }
        rg18.getChildAt(0).setEnabled(false);
        rg18.getChildAt(1).setEnabled(false);
        rg18.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(18).getResposta();
        switch (resp){
            case "FALSO": rg19.check(R.id.arbQ19Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg19.check(R.id.arbQ19MMV); break;
            case "VERDADEIRO": rg19.check(R.id.arbQ19Verdadeiro); break;
        }
        rg19.getChildAt(0).setEnabled(false);
        rg19.getChildAt(1).setEnabled(false);
        rg19.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(19).getResposta();
        switch (resp){
            case "FALSO": rg20.check(R.id.arbQ20Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg20.check(R.id.arbQ20MMV); break;
            case "VERDADEIRO": rg20.check(R.id.arbQ20Verdadeiro); break;
        }
        rg20.getChildAt(0).setEnabled(false);
        rg20.getChildAt(1).setEnabled(false);
        rg20.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(20).getResposta();
        switch (resp){
            case "FALSO": rg21.check(R.id.arbQ21Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg21.check(R.id.arbQ21MMV); break;
            case "VERDADEIRO": rg21.check(R.id.arbQ21Verdadeiro); break;
        }
        rg21.getChildAt(0).setEnabled(false);
        rg21.getChildAt(1).setEnabled(false);
        rg21.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(21).getResposta();
        switch (resp){
            case "FALSO": rg22.check(R.id.arbQ22Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg22.check(R.id.arbQ22MMV); break;
            case "VERDADEIRO": rg22.check(R.id.arbQ22Verdadeiro); break;
        }
        rg22.getChildAt(0).setEnabled(false);
        rg22.getChildAt(1).setEnabled(false);
        rg22.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(22).getResposta();
        switch (resp){
            case "FALSO": rg23.check(R.id.arbQ23Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg23.check(R.id.arbQ23MMV); break;
            case "VERDADEIRO": rg23.check(R.id.arbQ23Verdadeiro); break;
        }
        rg23.getChildAt(0).setEnabled(false);
        rg23.getChildAt(1).setEnabled(false);
        rg23.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(23).getResposta();
        switch (resp){
            case "FALSO": rg24.check(R.id.arbQ24Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg24.check(R.id.arbQ24MMV); break;
            case "VERDADEIRO": rg24.check(R.id.arbQ24Verdadeiro); break;
        }
        rg24.getChildAt(0).setEnabled(false);
        rg24.getChildAt(1).setEnabled(false);
        rg24.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(24).getResposta();
        switch (resp){
            case "FALSO": rg25.check(R.id.arbQ25Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg25.check(R.id.arbQ25MMV); break;
            case "VERDADEIRO": rg25.check(R.id.arbQ25Verdadeiro); break;
        }
        rg25.getChildAt(0).setEnabled(false);
        rg25.getChildAt(1).setEnabled(false);
        rg25.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(25).getResposta();
        switch (resp){
            case "FALSO": rg26.check(R.id.arbQ26Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg26.check(R.id.arbQ26MMV); break;
            case "VERDADEIRO": rg26.check(R.id.arbQ26Verdadeiro); break;
        }
        rg26.getChildAt(0).setEnabled(false);
        rg26.getChildAt(1).setEnabled(false);
        rg26.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(26).getResposta();
        switch (resp){
            case "FALSO": rg27.check(R.id.arbQ27Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg27.check(R.id.arbQ27MMV); break;
            case "VERDADEIRO": rg27.check(R.id.arbQ27Verdadeiro); break;
        }
        rg27.getChildAt(0).setEnabled(false);
        rg27.getChildAt(1).setEnabled(false);
        rg27.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(27).getResposta();
        switch (resp){
            case "FALSO": rg28.check(R.id.arbQ28Falso); break;
            case "MAIS OU MENOS VERDADEIRO": rg28.check(R.id.arbQ28MMV); break;
            case "VERDADEIRO": rg28.check(R.id.arbQ28Verdadeiro); break;
        }
        rg28.getChildAt(0).setEnabled(false);
        rg28.getChildAt(1).setEnabled(false);
        rg28.getChildAt(2).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(28).getResposta();
        rQcomentario.setText(resp);
        rQcomentario.setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(29).getResposta();
        switch (resp){
            case "NAO": rg29.check(R.id.arbQ29N); break;
            case "SIM PEQUENAS DIFICULDADES": rg29.check(R.id.arbQ29SPD); break;
            case "SIM DIFICULDADES BEM DEFINIDAS": rg29.check(R.id.arbQ29SDD);break;
            case "SIM DIFICULDADES GRAVES": rg29.check(R.id.arbQ29SDG);break;
        }
        rg29.getChildAt(0).setEnabled(false);
        rg29.getChildAt(1).setEnabled(false);
        rg29.getChildAt(2).setEnabled(false);
        rg29.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(30).getResposta();
        switch (resp){
            case "MENOS DE 1 MES": rg30.check(R.id.arbQ301m); break;
            case "1-5 MESES": rg30.check(R.id.arbQ3015m); break;
            case "6-12 MESES": rg30.check(R.id.arbQ30612m);break;
            case "MAIS DE 1 ANO": rg30.check(R.id.arbQ301a);break;
        }
        rg30.getChildAt(0).setEnabled(false);
        rg30.getChildAt(1).setEnabled(false);
        rg30.getChildAt(2).setEnabled(false);
        rg30.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(31).getResposta();
        switch (resp){
            case "NADA": rg31.check(R.id.arbQ31Nada); break;
            case "UM POUCO": rg31.check(R.id.arbQ31UP); break;
            case "MUITO": rg31.check(R.id.arbQ31M);break;
            case "MAIS QUE MUITO": rg31.check(R.id.arbQ31MM);break;
        }
        rg31.getChildAt(0).setEnabled(false);
        rg31.getChildAt(1).setEnabled(false);
        rg31.getChildAt(2).setEnabled(false);
        rg31.getChildAt(3).setEnabled(false);

        // Sub Questao 1 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(0).getResposta();
        switch (resp){
            case "NADA": rg32sub1.check(R.id.arbQ32sub1N); break;
            case "UM POUCO": rg32sub1.check(R.id.arbQ32sub1UP); break;
            case "MUITO": rg32sub1.check(R.id.arbQ32sub1M);break;
            case "MAIS QUE MUITO": rg32sub1.check(R.id.arbQ32sub1MM);break;
        }
        rg32sub1.getChildAt(0).setEnabled(false);
        rg32sub1.getChildAt(1).setEnabled(false);
        rg32sub1.getChildAt(2).setEnabled(false);
        rg32sub1.getChildAt(3).setEnabled(false);

        // Sub Questao 2 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(1).getResposta();
        switch (resp){
            case "NADA": rg32sub2.check(R.id.arbQ32sub2N); break;
            case "UM POUCO": rg32sub2.check(R.id.arbQ32sub2UP); break;
            case "MUITO": rg32sub2.check(R.id.arbQ32sub2M);break;
            case "MAIS QUE MUITO": rg32sub2.check(R.id.arbQ32sub2MM);break;
        }
        rg32sub2.getChildAt(0).setEnabled(false);
        rg32sub2.getChildAt(1).setEnabled(false);
        rg32sub2.getChildAt(2).setEnabled(false);
        rg32sub2.getChildAt(3).setEnabled(false);

        // Sub Questao 3 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(2).getResposta();
        switch (resp){
            case "NADA": rg32sub3.check(R.id.arbQ32sub3N); break;
            case "UM POUCO": rg32sub3.check(R.id.arbQ32sub3UP); break;
            case "MUITO": rg32sub3.check(R.id.arbQ32sub3M);break;
            case "MAIS QUE MUITO": rg32sub3.check(R.id.arbQ32sub3MM);break;
        }
        rg32sub3.getChildAt(0).setEnabled(false);
        rg32sub3.getChildAt(1).setEnabled(false);
        rg32sub3.getChildAt(2).setEnabled(false);
        rg32sub3.getChildAt(3).setEnabled(false);

        // Sub Questao 4 da 32
        resp = questionario.getQuestaoRespostas().get(32).getSubQuestoes().get(3).getResposta();
        switch (resp){
            case "NADA": rg32sub4.check(R.id.arbQ32sub4N); break;
            case "UM POUCO": rg32sub4.check(R.id.arbQ32sub4UP); break;
            case "MUITO": rg32sub4.check(R.id.arbQ32sub4M);break;
            case "MAIS QUE MUITO": rg32sub4.check(R.id.arbQ32sub4MM);break;
        }
        rg32sub4.getChildAt(0).setEnabled(false);
        rg32sub4.getChildAt(1).setEnabled(false);
        rg32sub4.getChildAt(2).setEnabled(false);
        rg32sub4.getChildAt(3).setEnabled(false);

        resp = questionario.getQuestaoRespostas().get(33).getResposta();
        switch (resp){
            case "NADA": rg33.check(R.id.arbQ33Nada); break;
            case "UM POUCO": rg33.check(R.id.arbQ33UP); break;
            case "MUITO": rg33.check(R.id.arbQ33M);break;
            case "MAIS QUE MUITO": rg33.check(R.id.arbQ33MM);break;
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

        salvar.setEnabled(false);
        salvar.setVisibility(View.INVISIBLE);

    }

}
