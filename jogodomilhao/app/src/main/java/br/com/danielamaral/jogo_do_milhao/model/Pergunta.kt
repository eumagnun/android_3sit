package br.com.danielamaral.jogo_do_milhao.model

data class Pergunta
    (
    val texto: String,
    var respostas: List<Resposta>

)