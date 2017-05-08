package com.developer.barbosa.sdq.enums;

/**
 * Created by Bruno Barbosa on 30/03/2017.
 */

public enum QuestoesAlunos {

    Q1("Nome"),
    Q2("Data de Nascimento"),
    Q3("Sexo"),
    Q4("Eu tento ser legal com as outras pessoas. Eu me preocupo com os sentimentos dos outros"),
    Q5("Não consigo parar sentado quando tenho que fazer a lição ou comer; me mexo muito, esbarrando em coisas, derrubando coisas"),
    Q6("Muitas vezes tenho dor de cabeça, dor de barriga ou enjôo"),
    Q7("Tenho boa vontade para dividir, emprestar minhas coisas (comida, jogos, canetas)"),
    Q8("Eu fico muito bravo e geralmente perco a paciência"),
    Q9("Eu estou quase sempre sozinho. Eu geralmente jogo sozinho ou fico na minha"),
    Q10("Geralmente sou obediente e normalmente faço o que os adultos me pedem"),
    Q11("Tenho muitas preocupações, muitas vezes pareço preocupado com tudo"),
    Q12("Tento ajudar se alguém parece magoado, aflito ou sentindo-se mal"),
    Q13("Estou sempre agitado, balançando as pernas ou mexendo as mãos"),
    Q14("Eu tenho pelo menos um bom amigo ou amiga"),
    Q15("Eu brigo muito. Eu consigo fazer com que as pessoas façam o que eu quero"),
    Q16("Frequentemente estou chateado, desanimado ou choroso"),
    Q17("Em geral, os outros jovens gostam de mim"),
    Q18("Facilmente perco a concentração"),
    Q19("Fico nervoso quando tenho que fazer alguma coisa diferente, facilmente perco a confiança em mim mesmo"),
    Q20("Sou legal com crianças mais novas"),
    Q21("Geralmente eu sou acusado de mentir ou trapacear"),
    Q22("Os outros jovens me perturbam, 'pegam no pé'"),
    Q23("Frequentemente me ofereço para ajudar outras pessoas (pais, professores, crianças)"),
    Q24("Eu penso antes de fazer as coisas"),
    Q25("Eu pego coisas que não são minhas, de casa, da escola ou de outros lugares"),
    Q26("Eu me dou melhor com os adultos do que com pessoas da minha idade"),
    Q27("Eu sinto muito medo, eu me assusto facilmente"),
    Q28("Eu consigo terminar as atividades que começo. Eu consigo prestar atenção"),
    QComentario("Você tem algum outro comentário ou preocupações? Descreva-os abaixo"),
    Q29("Pensando no que acabou de responder, você acha que tem alguma dificuldade? Pode ser uma dificuldade emocional, de comportamento, pouca concentracão ou para se dar bem com outras pessoas"),
    Q30("Por quanto tempo estas dificuldades existem?"),
    Q31("Estas dificuldades incomodam ou aborrecem você?"),
    Q32("Estas dificuldades atrapalham o seu dia-a-dia em alguma das situações abaixo?"),
    Q32sub1("DIA-A-DIA EM CASA"),
    Q32sub2("AMIZADES"),
    Q32sub3("APRENDIZADO ESCOLAR"),
    Q32sub4("ATIVIDADES DE LAZER (PASSEIOS, ESPORTES ETC.)"),
    Q33("Estas dificuldades tornam as coisas mais difíceis para as pessoas que convivem com você(família, amigos, professores, etc.)?"),
    Q34("Nome Completo"),
    Q35("Data de Hoje");

    private String texto;

    QuestoesAlunos(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
