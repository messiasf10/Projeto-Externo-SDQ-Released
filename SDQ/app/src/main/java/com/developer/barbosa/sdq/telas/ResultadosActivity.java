package com.developer.barbosa.sdq.telas;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.barbosa.sdq.R;
import com.developer.barbosa.sdq.enums.QuestoesAlunos;
import com.developer.barbosa.sdq.enums.QuestoesProfessores;
import com.developer.barbosa.sdq.enums.QuestoesResponsavel;
import com.developer.barbosa.sdq.enums.TipoQuestionario;
import com.developer.barbosa.sdq.model.QuestaoResposta;
import com.developer.barbosa.sdq.model.Questionario;
import com.developer.barbosa.sdq.model.ResultadosDAO;


import java.io.File;
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

public class ResultadosActivity extends AppCompatActivity {

    private Spinner spinnerTipoQuestResults, spinnerSelecQuestResults;
    private String tipoQuestionarioSelecionado = "";
    private int positionQuestionarioSelecionado = 0;
    private TextView txtRespNumFalso, txtRespNumMMV, txtRespNumVerdadeiro;
    private Button btnVisualizarQuestionario;
    private Button btnExportarExcell;

    private ProgressDialog dialog;
    private AlertDialog alerta;
    private AlertDialog alertaNomeEscola;

    private String nomeEscola = "";
    private static String NOME_ARQUIVO = "PLANILHA_SDQ";
    private static String EXTENSAO_ARQUIVO = ".xls";

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

        spinnerTipoQuestResults.setOnItemSelectedListener(selectedListenerSpinnerTipoQuestionario);
        spinnerSelecQuestResults.setOnItemSelectedListener(selectedListenerSpinnerPositionQuestionario);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resultados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_deletar_questionario) {

            if (spinnerSelecQuestResults.getSelectedItemId() != AdapterView.INVALID_ROW_ID) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ResultadosActivity.this);
                builder.setTitle("Deletar Questionário Selecionado");
                builder.setMessage("Você tem certeza de que deseja deletar o questionário selecionado?");
                builder.setIcon(R.drawable.ic_action_alerta);
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        boolean deletado = ResultadosDAO.deleteQuestionarioByPositionTipo(tipoQuestionarioSelecionado, positionQuestionarioSelecionado);

                        if(deletado) {
                            Toast.makeText(ResultadosActivity.this, "Questionário deletado com sucesso!", Toast.LENGTH_SHORT).show();

                            ArrayAdapter<String> adapterSpinnerQuestSelec = new ArrayAdapter<>(ResultadosActivity.this,
                                    android.R.layout.simple_spinner_item,
                                    ResultadosDAO.getStringsViewQuestionariosByTipo(tipoQuestionarioSelecionado));
                            adapterSpinnerQuestSelec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                            spinnerSelecQuestResults.setAdapter(adapterSpinnerQuestSelec);
                        }
                        else
                            Toast.makeText(ResultadosActivity.this, "Falha ao tentar deletar o questionário!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(ResultadosActivity.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                alerta = builder.create();
                alerta.show();

            } else
                Toast.makeText(this, "Selecione um questionário!", Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    AdapterView.OnItemSelectedListener selectedListenerSpinnerTipoQuestionario = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            tipoQuestionarioSelecionado = spinnerTipoQuestResults.getSelectedItem().toString();

            ArrayAdapter<String> adapterSpinnerQuestSelec = new ArrayAdapter<>(ResultadosActivity.this,
                    android.R.layout.simple_spinner_item,
                    ResultadosDAO.getStringsViewQuestionariosByTipo(tipoQuestionarioSelecionado));
            adapterSpinnerQuestSelec.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnerSelecQuestResults.setAdapter(adapterSpinnerQuestSelec);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    AdapterView.OnItemSelectedListener selectedListenerSpinnerPositionQuestionario = new AdapterView.OnItemSelectedListener() {
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
            Toast.makeText(this, "Selecione um questionário!", Toast.LENGTH_SHORT).show();
        }
    }

    public void exportarExcel(View view) {
        this.criarAlertDialogConfirmarNomeEscolaInstituicao();
    }

    private class ExportarExcelAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ResultadosActivity.this, "Por favor, aguarde", "Gerando planilha do excel ...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            gerarDadosNaPlanilhaDoExcel();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(ResultadosActivity.this, "Planilha gerada com sucesso!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }

    }

    private void gerarDadosNaPlanilhaDoExcel(){
        try {

            File file;
            if (nomeEscola.equals(""))
                file = new File(Environment.getExternalStorageDirectory(), NOME_ARQUIVO + EXTENSAO_ARQUIVO);
            else
                file = new File(Environment.getExternalStorageDirectory(), NOME_ARQUIVO + "_" + nomeEscola + EXTENSAO_ARQUIVO);

            WritableWorkbook writableWorkbook = null;

            writableWorkbook = Workbook.createWorkbook(file);

            // CRIANDO ABAS DAS PLANILHAS
            writableWorkbook.createSheet("PROFESSORES", 0);
            writableWorkbook.createSheet("ALUNOS", 1);
            writableWorkbook.createSheet("PAIS OU RESPONSÁVEIS", 2);

            // PEGANDO PLANILHAS PARA ESCREVER
            WritableSheet writableSheetPlanProfessor = writableWorkbook.getSheet(0);
            WritableSheet writableSheetPlanAluno = writableWorkbook.getSheet(1);
            WritableSheet writableSheetPlanPaisResponsavel = writableWorkbook.getSheet(2);

            // FORMATACAO DAS CELULAS DO CABECALHO
            WritableCellFormat writableCellFormatHeader = new WritableCellFormat();

            // COR DE FUNDO DAS CELULAS DO CABECALHO
            Colour colorHeaders = Colour.GRAY_80;

            // COR E TIPO DE FONTE CABECALHO
            WritableFont fonteHeader = new WritableFont(WritableFont.ARIAL);
            fonteHeader.setBoldStyle(WritableFont.BOLD);
            fonteHeader.setColour(Colour.WHITE);

            writableCellFormatHeader.setBackground(colorHeaders);
            writableCellFormatHeader.setFont(fonteHeader);
            writableCellFormatHeader.setWrap(true);
            writableCellFormatHeader.setAlignment(Alignment.CENTRE);
            writableCellFormatHeader.setVerticalAlignment(VerticalAlignment.CENTRE);
            writableCellFormatHeader.setBorder(Border.ALL, BorderLineStyle.THIN);

            // FORMATACAO DAS CELULAS DO CORPO DA TABELA
            WritableCellFormat writableCellFormatBody = new WritableCellFormat();

            // COR DE FUNDO DAS CELULAS DO CORPO
            Colour colorBody = Colour.GRAY_25;

            // COR E TIPO DE FONTE DO CORPO
            WritableFont fonteBody = new WritableFont(WritableFont.ARIAL);
            fonteBody.setColour(Colour.BLACK);

            writableCellFormatBody.setBackground(colorBody);
            writableCellFormatBody.setFont(fonteBody);
            writableCellFormatBody.setWrap(true);
            writableCellFormatBody.setAlignment(Alignment.CENTRE);
            writableCellFormatBody.setVerticalAlignment(VerticalAlignment.CENTRE);
            writableCellFormatBody.setBorder(Border.ALL, BorderLineStyle.THIN);

            // INICIANDO A LEITURA DOS DADOS
            Realm realm = Realm.getDefaultInstance();

            realm.beginTransaction();

            // -------------------- QUESTIONARIOS DOS PROFESSORES ------------------------------

            // Pegando todos os questionários do tipo Professor
            RealmQuery<Questionario> questionarioRealmQuery = realm
                    .where(Questionario.class)
                    .equalTo("tipo", TipoQuestionario.PROFESSORES.getTipo());
            List<Questionario> questionariosProfessor = questionarioRealmQuery.findAll();

            QuestoesProfessores[] questoesProfessores = QuestoesProfessores.values();

            // PERCORRENDO VETOR COM TODAS AS QUESTOES DO PROFESSOR
            for (int colunaVetor = 0, colunaExcel = 1; colunaVetor < questoesProfessores.length; colunaVetor++) {

                // Setando a largura das colunas
                writableSheetPlanProfessor.setColumnView(colunaExcel, 25);

                Label label0;
                if (questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q34.getTexto())) {
                    label0 = new Label(0, 0, questoesProfessores[colunaVetor].getTexto());
                    writableSheetPlanProfessor.addCell(label0);

                    WritableCell writableCell0 = writableSheetPlanProfessor.getWritableCell(0, 0);
                    writableCell0.setCellFormat(writableCellFormatHeader);

                    // Setando a largura das colunas
                    writableSheetPlanProfessor.setColumnView(0, 25);
                } else {

                    Label label1;
                    Label label2;
                    if (questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32.getTexto())) {
                        label1 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto() + "(" + QuestoesProfessores.Q32sub1.getTexto() + ")");
                        writableSheetPlanProfessor.addCell(label1);

                        WritableCell writableCell = writableSheetPlanProfessor.getWritableCell(colunaExcel, 0);
                        writableCell.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel + 1;

                        label2 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto() + "(" + QuestoesProfessores.Q32sub2.getTexto() + ")");
                        writableSheetPlanProfessor.addCell(label2);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanProfessor.setColumnView(colunaExcel, 25);

                        WritableCell cell2 = writableSheetPlanProfessor.getWritableCell(colunaExcel, 0);
                        cell2.setCellFormat(writableCellFormatHeader);

                        colunaExcel++;
                    } else {

                        if (!questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.QComentario.getTexto()) &&
                                !questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32sub1.getTexto()) &&
                                !questoesProfessores[colunaVetor].getTexto().equals(QuestoesProfessores.Q32sub2.getTexto())) {

                            label1 = new Label(colunaExcel, 0, questoesProfessores[colunaVetor].getTexto());
                            writableSheetPlanProfessor.addCell(label1);

                            WritableCell cell3 = writableSheetPlanProfessor.getWritableCell(colunaExcel, 0);
                            cell3.setCellFormat(writableCellFormatHeader);

                            colunaExcel++;


                        }

                    }

                }

            }

            // PERCORRER TODAS AS RESPOSTAS DOS QUESTIONARIOS DOS PROFESSORES
            for (int linha = 1, colunaExcel = 1; linha <= questionariosProfessor.size(); linha++) {
                colunaExcel = 1;

                Questionario q = questionariosProfessor.get(linha - 1);

                for (int coluna = 0; coluna < q.getQuestaoRespostas().size(); coluna++) {

                    QuestaoResposta qr = q.getQuestaoRespostas().get(coluna);

                    Label label0;
                    if (qr.getQuestao().equals(QuestoesProfessores.Q34.getTexto())) {
                        label0 = new Label(0, linha, qr.getResposta());
                        writableSheetPlanProfessor.addCell(label0);

                        WritableCell writableCell0 = writableSheetPlanProfessor.getWritableCell(0, linha);
                        writableCell0.setCellFormat(writableCellFormatBody);
                    } else {

                        // Escrevendo as respostas
                        Label label1;
                        Label label2;
                        if (qr.getQuestao().equals(QuestoesProfessores.Q32.getTexto())) {
                            label1 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(0).getResposta());
                            writableSheetPlanProfessor.addCell(label1);

                            WritableCell cell1 = writableSheetPlanProfessor.getWritableCell(colunaExcel, linha);
                            cell1.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label2 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(1).getResposta());
                            writableSheetPlanProfessor.addCell(label2);

                            WritableCell cell2 = writableSheetPlanProfessor.getWritableCell(colunaExcel, linha);
                            cell2.setCellFormat(writableCellFormatBody);

                            colunaExcel++;
                        } else {

                            if (!qr.getQuestao().equals(QuestoesProfessores.QComentario.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesProfessores.Q32sub1.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesProfessores.Q32sub2.getTexto())) {

                                label1 = new Label(colunaExcel, linha, qr.getResposta());
                                writableSheetPlanProfessor.addCell(label1);

                                WritableCell cell3 = writableSheetPlanProfessor.getWritableCell(colunaExcel, linha);
                                cell3.setCellFormat(writableCellFormatBody);

                                colunaExcel++;

                            }

                        }

                    }

                }

            }

            // -------------------- QUESTIONARIOS DOS ALUNOS ------------------------------

            // Pegando todos os questionários do tipo Aluno
            RealmQuery<Questionario> questionarioRealmQueryAluno = realm
                    .where(Questionario.class)
                    .equalTo("tipo", TipoQuestionario.ALUNOS.getTipo());
            List<Questionario> questionariosAlunos = questionarioRealmQueryAluno.findAll();

            QuestoesAlunos[] questoesAlunos = QuestoesAlunos.values();

            // PERCORRENDO VETOR COM TODAS AS QUESTOES DOS ALUNOS
            for (int colunaVetor = 0, colunaExcel = 1; colunaVetor < questoesAlunos.length; colunaVetor++) {

                // Setando a largura das colunas
                writableSheetPlanAluno.setColumnView(colunaExcel, 25);

                Label label0;
                if (questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q34.getTexto())) {
                    label0 = new Label(0, 0, questoesAlunos[colunaVetor].getTexto());
                    writableSheetPlanAluno.addCell(label0);

                    WritableCell writableCell0 = writableSheetPlanAluno.getWritableCell(0, 0);
                    writableCell0.setCellFormat(writableCellFormatHeader);

                    // Setando a largura das colunas
                    writableSheetPlanAluno.setColumnView(0, 25);
                } else {

                    Label label1;
                    Label label2;
                    Label label3;
                    Label label4;
                    if (questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q32.getTexto())) {
                        label1 = new Label(colunaExcel, 0, questoesAlunos[colunaVetor].getTexto() + "(" + QuestoesAlunos.Q32sub1.getTexto() + ")");
                        writableSheetPlanAluno.addCell(label1);

                        WritableCell writableCell = writableSheetPlanAluno.getWritableCell(colunaExcel, 0);
                        writableCell.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel + 1;

                        label2 = new Label(colunaExcel, 0, questoesAlunos[colunaVetor].getTexto() + "(" + QuestoesAlunos.Q32sub2.getTexto() + ")");
                        writableSheetPlanAluno.addCell(label2);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanAluno.setColumnView(colunaExcel, 25);

                        WritableCell cell2 = writableSheetPlanAluno.getWritableCell(colunaExcel, 0);
                        cell2.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel  +1;

                        label3 = new Label(colunaExcel, 0, questoesAlunos[colunaVetor].getTexto() + "(" + QuestoesAlunos.Q32sub3.getTexto() + ")");
                        writableSheetPlanAluno.addCell(label3);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanAluno.setColumnView(colunaExcel, 25);

                        WritableCell cell3 = writableSheetPlanAluno.getWritableCell(colunaExcel, 0);
                        cell3.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel  +1;

                        label4 = new Label(colunaExcel, 0, questoesAlunos[colunaVetor].getTexto() + "(" + QuestoesAlunos.Q32sub4.getTexto() + ")");
                        writableSheetPlanAluno.addCell(label4);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanAluno.setColumnView(colunaExcel, 25);

                        WritableCell cell4 = writableSheetPlanAluno.getWritableCell(colunaExcel, 0);
                        cell4.setCellFormat(writableCellFormatHeader);

                        colunaExcel++;
                    } else {

                        if (!questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.QComentario.getTexto()) &&
                                !questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q32sub1.getTexto()) &&
                                !questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q32sub2.getTexto()) &&
                                !questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q32sub3.getTexto()) &&
                                !questoesAlunos[colunaVetor].getTexto().equals(QuestoesAlunos.Q32sub4.getTexto())) {

                            label1 = new Label(colunaExcel, 0, questoesAlunos[colunaVetor].getTexto());
                            writableSheetPlanAluno.addCell(label1);

                            WritableCell cell5 = writableSheetPlanAluno.getWritableCell(colunaExcel, 0);
                            cell5.setCellFormat(writableCellFormatHeader);

                            colunaExcel++;


                        }

                    }

                }

            }

            // PERCORRER TODAS AS RESPOSTAS DOS QUESTIONARIOS DOS ALUNOS
            for (int linha = 1, colunaExcel = 1; linha <= questionariosAlunos.size(); linha++) {
                colunaExcel = 1;

                Questionario q = questionariosAlunos.get(linha - 1);

                for (int coluna = 0; coluna < q.getQuestaoRespostas().size(); coluna++) {

                    QuestaoResposta qr = q.getQuestaoRespostas().get(coluna);

                    Label label0;
                    if (qr.getQuestao().equals(QuestoesAlunos.Q34.getTexto())) {
                        label0 = new Label(0, linha, qr.getResposta());
                        writableSheetPlanAluno.addCell(label0);

                        WritableCell writableCell0 = writableSheetPlanAluno.getWritableCell(0, linha);
                        writableCell0.setCellFormat(writableCellFormatBody);
                    } else {

                        // Escrevendo as respostas
                        Label label1;
                        Label label2;
                        Label label3;
                        Label label4;
                        if (qr.getQuestao().equals(QuestoesAlunos.Q32.getTexto())) {
                            label1 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(0).getResposta());
                            writableSheetPlanAluno.addCell(label1);

                            WritableCell cell1 = writableSheetPlanAluno.getWritableCell(colunaExcel, linha);
                            cell1.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label2 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(1).getResposta());
                            writableSheetPlanAluno.addCell(label2);

                            WritableCell cell2 = writableSheetPlanAluno.getWritableCell(colunaExcel, linha);
                            cell2.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label3 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(2).getResposta());
                            writableSheetPlanAluno.addCell(label3);

                            WritableCell cell3 = writableSheetPlanAluno.getWritableCell(colunaExcel, linha);
                            cell3.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label4 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(3).getResposta());
                            writableSheetPlanAluno.addCell(label4);

                            WritableCell cell4 = writableSheetPlanAluno.getWritableCell(colunaExcel, linha);
                            cell4.setCellFormat(writableCellFormatBody);

                            colunaExcel++;
                        } else {

                            if (!qr.getQuestao().equals(QuestoesAlunos.QComentario.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesAlunos.Q32sub1.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesAlunos.Q32sub2.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesAlunos.Q32sub3.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesAlunos.Q32sub4.getTexto())) {

                                label1 = new Label(colunaExcel, linha, qr.getResposta());
                                writableSheetPlanAluno.addCell(label1);

                                WritableCell cell5 = writableSheetPlanAluno.getWritableCell(colunaExcel, linha);
                                cell5.setCellFormat(writableCellFormatBody);

                                colunaExcel++;

                            }

                        }

                    }

                }

            }

            // -------------------- QUESTIONARIOS DOS PAIS OU RESPONSAVEIS ------------------------------

            // Pegando todos os questionários do tipo Aluno
            RealmQuery<Questionario> questionarioRealmQueryPaisResponsaveis = realm
                    .where(Questionario.class)
                    .equalTo("tipo", TipoQuestionario.RESPONSAVEL.getTipo());
            List<Questionario> questionariosPaisResponsaveis = questionarioRealmQueryPaisResponsaveis.findAll();

            QuestoesResponsavel[] questoesResponsaveis = QuestoesResponsavel.values();

            // PERCORRENDO VETOR COM TODAS AS QUESTOES DOS RESPONSAVEIS
            for (int colunaVetor = 0, colunaExcel = 1; colunaVetor < questoesResponsaveis.length; colunaVetor++) {

                // Setando a largura das colunas
                writableSheetPlanPaisResponsavel.setColumnView(colunaExcel, 25);

                Label label0;
                if (questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q34.getTexto())) {
                    label0 = new Label(0, 0, questoesResponsaveis[colunaVetor].getTexto());
                    writableSheetPlanPaisResponsavel.addCell(label0);

                    WritableCell writableCell0 = writableSheetPlanPaisResponsavel.getWritableCell(0, 0);
                    writableCell0.setCellFormat(writableCellFormatHeader);

                    // Setando a largura das colunas
                    writableSheetPlanPaisResponsavel.setColumnView(0, 25);
                } else {

                    Label label1;
                    Label label2;
                    Label label3;
                    Label label4;
                    if (questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q32.getTexto())) {
                        label1 = new Label(colunaExcel, 0, questoesResponsaveis[colunaVetor].getTexto() + "(" + QuestoesResponsavel.Q32sub1.getTexto() + ")");
                        writableSheetPlanPaisResponsavel.addCell(label1);

                        WritableCell writableCell = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, 0);
                        writableCell.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel + 1;

                        label2 = new Label(colunaExcel, 0, questoesResponsaveis[colunaVetor].getTexto() + "(" + QuestoesResponsavel.Q32sub2.getTexto() + ")");
                        writableSheetPlanPaisResponsavel.addCell(label2);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanPaisResponsavel.setColumnView(colunaExcel, 25);

                        WritableCell cell2 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, 0);
                        cell2.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel  +1;

                        label3 = new Label(colunaExcel, 0, questoesResponsaveis[colunaVetor].getTexto() + "(" + QuestoesResponsavel.Q32sub3.getTexto() + ")");
                        writableSheetPlanPaisResponsavel.addCell(label3);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanPaisResponsavel.setColumnView(colunaExcel, 25);

                        WritableCell cell3 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, 0);
                        cell3.setCellFormat(writableCellFormatHeader);

                        colunaExcel = colunaExcel  +1;

                        label4 = new Label(colunaExcel, 0, questoesResponsaveis[colunaVetor].getTexto() + "(" + QuestoesResponsavel.Q32sub4.getTexto() + ")");
                        writableSheetPlanPaisResponsavel.addCell(label4);

                        // COLOCOU AQUI, POR QUE PULOU UM COLUNA
                        writableSheetPlanPaisResponsavel.setColumnView(colunaExcel, 25);

                        WritableCell cell4 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, 0);
                        cell4.setCellFormat(writableCellFormatHeader);

                        colunaExcel++;
                    } else {

                        if (!questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.QComentario.getTexto()) &&
                                !questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q32sub1.getTexto()) &&
                                !questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q32sub2.getTexto()) &&
                                !questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q32sub3.getTexto()) &&
                                !questoesResponsaveis[colunaVetor].getTexto().equals(QuestoesResponsavel.Q32sub4.getTexto())) {

                            label1 = new Label(colunaExcel, 0, questoesResponsaveis[colunaVetor].getTexto());
                            writableSheetPlanPaisResponsavel.addCell(label1);

                            WritableCell cell5 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, 0);
                            cell5.setCellFormat(writableCellFormatHeader);

                            colunaExcel++;

                        }

                    }

                }

            }

            // PERCORRER TODAS AS RESPOSTAS DOS QUESTIONARIOS DOS PAIS OU RESPONSAVEIS
            for (int linha = 1, colunaExcel = 1; linha <= questionariosPaisResponsaveis.size(); linha++) {
                colunaExcel = 1;

                Questionario q = questionariosPaisResponsaveis.get(linha - 1);

                for (int coluna = 0; coluna < q.getQuestaoRespostas().size(); coluna++) {

                    QuestaoResposta qr = q.getQuestaoRespostas().get(coluna);

                    Label label0;
                    if (qr.getQuestao().equals(QuestoesResponsavel.Q34.getTexto())) {
                        label0 = new Label(0, linha, qr.getResposta());
                        writableSheetPlanPaisResponsavel.addCell(label0);

                        WritableCell writableCell0 = writableSheetPlanPaisResponsavel.getWritableCell(0, linha);
                        writableCell0.setCellFormat(writableCellFormatBody);
                    } else {

                        // Escrevendo as respostas
                        Label label1;
                        Label label2;
                        Label label3;
                        Label label4;
                        if (qr.getQuestao().equals(QuestoesResponsavel.Q32.getTexto())) {
                            label1 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(0).getResposta());
                            writableSheetPlanPaisResponsavel.addCell(label1);

                            WritableCell cell1 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, linha);
                            cell1.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label2 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(1).getResposta());
                            writableSheetPlanPaisResponsavel.addCell(label2);

                            WritableCell cell2 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, linha);
                            cell2.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label3 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(2).getResposta());
                            writableSheetPlanPaisResponsavel.addCell(label3);

                            WritableCell cell3 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, linha);
                            cell3.setCellFormat(writableCellFormatBody);

                            colunaExcel = colunaExcel + 1;

                            label4 = new Label(colunaExcel, linha, qr.getSubQuestoes().get(3).getResposta());
                            writableSheetPlanPaisResponsavel.addCell(label4);

                            WritableCell cell4 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, linha);
                            cell4.setCellFormat(writableCellFormatBody);

                            colunaExcel++;
                        } else {

                            if (!qr.getQuestao().equals(QuestoesResponsavel.QComentario.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesResponsavel.Q32sub1.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesResponsavel.Q32sub2.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesResponsavel.Q32sub3.getTexto()) &&
                                    !qr.getQuestao().equals(QuestoesResponsavel.Q32sub4.getTexto())) {

                                label1 = new Label(colunaExcel, linha, qr.getResposta());
                                writableSheetPlanPaisResponsavel.addCell(label1);

                                WritableCell cell5 = writableSheetPlanPaisResponsavel.getWritableCell(colunaExcel, linha);
                                cell5.setCellFormat(writableCellFormatBody);

                                colunaExcel++;

                            }

                        }

                    }

                }

            }

            writableWorkbook.write();
            writableWorkbook.close();

            realm.commitTransaction();

            realm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void criarAlertDialogConfirmarNomeEscolaInstituicao() {
        LayoutInflater li = getLayoutInflater();

        View view = li.inflate(R.layout.alerta_dialog, null);

        final EditText edtNomeEscola = (EditText) view.findViewById(R.id.edtNomeEscola);
        Button btnConfirmar = (Button) view.findViewById(R.id.btnConfirmar);
        Button btnIgnorar = (Button) view.findViewById(R.id.btnIgnorar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                nomeEscola = edtNomeEscola.getText().toString();

                if(nomeEscola.equals("")){
                    Toast.makeText(ResultadosActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    ExportarExcelAsync exportarExcelAsync = new ExportarExcelAsync();
                    exportarExcelAsync.execute();
                    alertaNomeEscola.dismiss();
                }

            }
        });

        btnIgnorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeEscola = "";
                ExportarExcelAsync exportarExcelAsync = new ExportarExcelAsync();
                exportarExcelAsync.execute();
                alertaNomeEscola.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nome da Escola/Instituição");
        builder.setView(view);
        alertaNomeEscola = builder.create();
        alertaNomeEscola.show();
    }

}
