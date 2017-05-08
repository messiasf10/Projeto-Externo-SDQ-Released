package com.developer.barbosa.sdq.enums;

/**
 * Created by Bruno Barbosa on 30/03/2017.
 */

public enum QuestoesProfessores {

    Q1("Nome da Criança"),
    Q2("Data de Nascimento"),
    Q3("Sexo"),
    Q4("Tem consideração pelos sentimentos de outras pessoas"),
    Q5("Não consegue parar sentado quando tem que fazer a lição ou comer; mexe-se muito, esbarrando em coisas, derrubando coisas."),
    Q6("Muitas vezes se queixa de dor de cabeça, dor de barriga ou enjôo"),
    Q7("Tem boa vontade em compartilhar doces, brinquedos, lápis ... com outras crianças"),
    Q8("Frequentemente tem acessos de raiva ou crises de birra"),
    Q9("É solitário, prefere brincar sozinho"),
    Q10("Geralmente é obediente e faz normalmente o que os adultos lhe pedem"),
    Q11("Tem muitas preocupações, muitas vezes parece preocupado com tudo"),
    Q12("Tenta ser atencioso se alguém parece magoado, aflito ou se sentindo mal"),
    Q13("Está sempre agitado, balançando as pernas ou mexendo as mãos"),
    Q14("Tem pelo menos um bom amigo ou amiga"),
    Q15("Frequentemente briga com outras crianças ou as amendronta"),
    Q16("Frequentemente parece triste, desanimado ou choroso"),
    Q17("Em geral, é querido por outras crianças"),
    Q18("Facilmente perde a concentração"),
    Q19("Fica inseguro quando tem que fazer alguma coisa pela primeira vez, facilmente perde a confiança em si mesmo"),
    Q20("É gentil com crianças mais novas"),
    Q21("Frequentemente engana ou mente"),
    Q22("Outras crianças 'pegam no pé' ou atormentam-no"),
    Q23("Frequentemente se oferece para ajudar outras pessoas (pais, professores, outras crianças)"),
    Q24("Pensa nas coisas antes de fazê-las"),
    Q25("Rouba coisas de casa, da escola ou de outros lugares"),
    Q26("Se dá melhor com adultos do que com outras crianças"),
    Q27("Tem muitos medos, assusta-se facilmente"),
    Q28("Completa as tarefas que começa, tem boa concentração"),
    QComentario("Você tem algum outro comentário ou preocupações? Descreva-os abaixo"),
    Q29("Pensando no que acabou de responder, você acha que na escola esta criança tem alguma dificuldade? Pode ser uma dificuldade emocional, de comportamento, pouca concentracão ou para se dar bem com outras pessoas"),
    Q30("Por quanto tempo estas dificuldades existem?"),
    Q31("Estas dificuldades incomodam ou aborrecem a criança?"),
    Q32("Estas dificuldades atrapalham o dia-a-dia da criança em alguma das situações abaixo?"),
    Q32sub1("AMIZADES"),
    Q32sub2("APRENDIZADO ESCOLAR"),
    Q33("Estas dificuldades são um peso para você ou para a classe como um todo?"),
    Q34("Nome Completo"),
    Q35("Data");

    private String texto;

    QuestoesProfessores(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
