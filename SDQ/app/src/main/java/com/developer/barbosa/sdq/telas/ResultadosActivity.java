package com.developer.barbosa.sdq.telas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.barbosa.sdq.R;
import com.developer.barbosa.sdq.model.ResultadosDAO;

public class ResultadosActivity extends AppCompatActivity {

    private Spinner spinnerTipoQuestResults, spinnerSelecQuestResults;
    private String tipoQuestionarioSelecionado = "";
    private int positionQuestionarioSelecionado = 0;
    private TextView txtRespNumFalso, txtRespNumMMV, txtRespNumVerdadeiro;
    private Button btnVisualizarQuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#763b5c")));

        spinnerTipoQuestResults = (Spinner) findViewById(R.id.spinnerTipoQuestResults);
        spinnerSelecQuestResults = (Spinner) findViewById(R.id.spinnerSelecQuestResult);
        txtRespNumFalso = (TextView) findViewById(R.id.txtRespNumFalso);
        txtRespNumMMV = (TextView) findViewById(R.id.txtRespNumMMV);
        txtRespNumVerdadeiro = (TextView) findViewById(R.id.txtRespNumV);
        btnVisualizarQuestionario = (Button) findViewById(R.id.btnVizualizarQuest);

        ArrayAdapter<CharSequence> adapterSpinnerTipo = ArrayAdapter.createFromResource(this,
                R.array.tipo_quest_array, android.R.layout.simple_spinner_item);
        adapterSpinnerTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTipoQuestResults.setAdapter(adapterSpinnerTipo);

        spinnerTipoQuestResults.setOnItemSelectedListener(selectedListener);
        spinnerSelecQuestResults.setOnItemSelectedListener(selectedListener1);

    }

    AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            tipoQuestionarioSelecionado = spinnerTipoQuestResults.getSelectedItem().toString();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(ResultadosActivity.this,
                    android.R.layout.simple_spinner_item,
                    ResultadosDAO.getStringsViewQuestionariosByTipo(tipoQuestionarioSelecionado));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerSelecQuestResults.setAdapter(adapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    AdapterView.OnItemSelectedListener selectedListener1 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            positionQuestionarioSelecionado = i;

            int[] vetorDeNumeroDeRespostas = ResultadosDAO.getNumeroRespostasFalsoMMVVQuestionarioPositionTipo(tipoQuestionarioSelecionado, i);

            txtRespNumFalso.setText(String.valueOf(vetorDeNumeroDeRespostas[0]));
            txtRespNumMMV.setText(String.valueOf(vetorDeNumeroDeRespostas[1]));
            txtRespNumVerdadeiro.setText(String.valueOf(vetorDeNumeroDeRespostas[2]));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    public void visualizarQuestionario(View view){
        if(spinnerSelecQuestResults.getSelectedItemId() != AdapterView.INVALID_ROW_ID){

            Intent intent = null;

            switch (tipoQuestionarioSelecionado) {
                case "ALUNOS":
                    intent = new Intent(ResultadosActivity.this, AlunoActivity.class);
                    break;
                case "PROFESSORES":
                    intent = new Intent(ResultadosActivity.this, ProfessorActivity.class);
                    break;
                case "PAIS/RESPONSÁVEIS":
                    intent = new Intent(ResultadosActivity.this, ResponsavelActivity.class);
                    break;
            }

            intent.putExtra("tipo", tipoQuestionarioSelecionado);
            intent.putExtra("position", positionQuestionarioSelecionado);
            startActivity(intent);

        }
        else {
            Toast.makeText(this, "Selecione um questionário!", Toast.LENGTH_LONG).show();
        }
    }
}
