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
import com.developer.barbosa.sdq.enums.QuestoesProfessores;
import com.developer.barbosa.sdq.enums.TipoQuestionario;
import com.developer.barbosa.sdq.model.QuestaoResposta;
import com.developer.barbosa.sdq.model.Questionario;
import com.developer.barbosa.sdq.model.ResultadosDAO;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;

import io.realm.Realm;
import io.realm.RealmQuery;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ResultadosActivity extends AppCompatActivity {

    private Spinner spinnerTipoQuestResults, spinnerSelecQuestResults;
    private String tipoQuestionarioSelecionado = "";
    private int positionQuestionarioSelecionado = 0;
    private TextView txtRespNumFalso, txtRespNumMMV, txtRespNumVerdadeiro;
    private Button btnVisualizarQuestionario;

    //variavel Botao de exportar Excell
    private Button btnExportarExcell;


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
        btnExportarExcell = (Button) findViewById(R.id.btnExportarExcell);

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

    public void visualizarQuestionario(View view) {
        if (spinnerSelecQuestResults.getSelectedItemId() != AdapterView.INVALID_ROW_ID) {

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

        } else {
            Toast.makeText(this, "Selecione um questionário!", Toast.LENGTH_LONG).show();
        }
    }


    public void exportarExcell(View view) {

        try {

            File file = new File(
                    Environment.getExternalStorageDirectory(), "SDQ.xls");

            WritableWorkbook wb = null;

            wb = Workbook.createWorkbook(file);


            //Cria aba da planilha
            wb.createSheet("Professor", 0);

            //Testando criar nova aba
            wb.createSheet("Aluno", 1);

            //Testando criar nova aba
            wb.createSheet("Pais ou Responsáveis", 2);

            WritableSheet plan1 = wb.getSheet(0);

            WritableSheet plan2 = wb.getSheet(1);
            WritableSheet plan3 = wb.getSheet(2);

            // Cor de fundo das celular
            Colour bckcolor = Colour.GRAY_50;
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setBackground(bckcolor);

            // Cor e tipo de fonte
            WritableFont fonte = new WritableFont(WritableFont.ARIAL);
            fonte.setColour(Colour.BLACK);
            cellFormat.setFont(fonte);

            cellFormat.setWrap(true);
            cellFormat.setAlignment(Alignment.CENTRE);
            cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            // Cor de fundo das celular
            Colour bckcolor2 = Colour.GRAY_25;
            WritableCellFormat cellFormat2 = new WritableCellFormat();
            cellFormat2.setBackground(bckcolor2);

            cellFormat2.setFont(fonte);

            cellFormat2.setWrap(true);
            cellFormat2.setAlignment(Alignment.CENTRE);
            cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat2.setBorder(Border.ALL, BorderLineStyle.THIN);

            Realm realm = Realm.getDefaultInstance();

            realm.beginTransaction();

            RealmQuery<Questionario> questionarioRealmQuery = realm.where(Questionario.class).equalTo("tipo", TipoQuestionario.PROFESSORES.getTipo());
            List<Questionario> questionariosProfessor = questionarioRealmQuery.findAll();

            QuestoesProfessores[] questoesProfessores = QuestoesProfessores.values();

            // PERCORRENDO VETOR COM TODAS AS QUESTOES DO PROFESSOR
            for (int colunaVetor = 0, colunaExcel = 0; colunaVetor < questoesProfessores.length; colunaVetor++) {
                plan1.setColumnView(colunaExcel, 25);

                Label label1;
                Label label2;
                if (questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32.getTexto())) {
                    label1 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto() + "(" + QuestoesProfessores.Q32sub1.getTexto() + ")");
                    plan1.addCell(label1);

                    WritableCell cell = plan1.getWritableCell(colunaExcel, 0);
                    cell.setCellFormat(cellFormat);

                    colunaExcel = colunaExcel + 1;

                    label2 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto() + "(" + QuestoesProfessores.Q32sub2.getTexto() + ")");
                    plan1.addCell(label2);

                    // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                    plan1.setColumnView(colunaExcel, 25);

                    WritableCell cell2 = plan1.getWritableCell(colunaExcel, 0);
                    cell2.setCellFormat(cellFormat);

                    colunaExcel++;
                } else {

                    if (questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.QComentario.getTexto())) {
                        // COLUNA DO EXCEL NAO AVANÇA
                    } else {

                        if (questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32sub1.getTexto()) ||
                                questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32sub2.getTexto())) {
                            // COLUNA DO EXCEL NAO AVANÇA
                        } else {
                            label1 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto());
                            plan1.addCell(label1);

                            WritableCell cell3 = plan1.getWritableCell(colunaExcel, 0);
                            cell3.setCellFormat(cellFormat);

                            colunaExcel++;
                        }

                    }

                }
            }

            // PERCORRER TODAS AS RESPOSTAS DOS QUESTIONARIOS DOS PROFESSORES
            for (int linha = 1, colunaExcel = 0; linha <= questionariosProfessor.size(); linha++) {
                plan1.setColumnView(colunaExcel, 25);

                Questionario q = questionariosProfessor.get(linha - 1);

                for (int coluna = 0; coluna < q.getQuestaoRespostas().size(); coluna++) {

                    QuestaoResposta qr = q.getQuestaoRespostas().get(coluna);

                    // Escrevendo as respostas
                    Label label1;
                    Label label2;
                    if (qr.getQuestao().equals(QuestoesProfessores.Q32.getTexto())) {
                        label1 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(0).getResposta());
                        plan1.addCell(label1);

                        WritableCell cell = plan1.getWritableCell(colunaExcel, linha);
                        cell.setCellFormat(cellFormat2);

                        colunaExcel = colunaExcel + 1;

                        label2 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(1).getResposta());
                        plan1.addCell(label2);

                        // COLOCOU AQUI POR QUE PULOU UMA COLUNA
                        plan1.setColumnView(colunaExcel, 25);

                        WritableCell cell2 = plan1.getWritableCell(colunaExcel, linha);
                        cell2.setCellFormat(cellFormat2);

                        colunaExcel++;
                    } else {

                        if (qr.getQuestao().equals(QuestoesProfessores.QComentario.getTexto())) {
                            // COLUNA DO EXCEL NAO AVANÇA
                        } else {

                            if (qr.getQuestao().equals(QuestoesProfessores.Q32sub1.getTexto()) ||
                                    qr.getQuestao().equals(QuestoesProfessores.Q32sub2.getTexto())) {
                                // COLUNA DO EXCEL NAO AVANÇA
                            } else {
                                label1 = new Label(colunaExcel, linha, qr.getResposta());
                                plan1.addCell(label1);

                                WritableCell cell3 = plan1.getWritableCell(colunaExcel, linha);
                                cell3.setCellFormat(cellFormat2);

                                colunaExcel++;
                            }

                        }

                    }

                }

            }

            wb.write();
            wb.close();

            realm.commitTransaction();

            realm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }




        /*//colunas e linhas e os valores das células
        Label label = new Label(0, 0,"Primeira célula");
        Label label1 = new Label(1, 0, "Segunda célula");
        Label label2 = new Label(2, 0, "Terceira célula");
        Label label3 = new Label(3, 0, "Quarta célula");
        Label label4 = new Label(4, 0, "Quinta célula");
        Label label5 = new Label(5, 0, "Sexta célula");
        Label label6 = new Label(6, 0, "Sétima célula");*/


        /*//Adicionando células no excell
        try {
            plan1.addCell(label);
            plan1.addCell(label1);
            plan1.addCell(label2);
            plan1.addCell(label3);
            plan1.addCell(label4);
            plan1.addCell(label5);
            plan1.addCell(label6);

            plan2.addCell(label);
            plan2.addCell(label1);
            plan2.addCell(label2);
            plan2.addCell(label3);
            plan2.addCell(label4);
            plan2.addCell(label5);
            plan2.addCell(label6);

            plan3.addCell(label);
            plan3.addCell(label1);
            plan3.addCell(label2);
            plan3.addCell(label3);
            plan3.addCell(label4);
            plan3.addCell(label5);
            plan3.addCell(label6);

        } catch (RowsExceededException e1) {
            e1.printStackTrace();
        } catch (WriteException e1) {
            e1.printStackTrace();
        }*/

        /*try {
            wb.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }*/
    }

}
