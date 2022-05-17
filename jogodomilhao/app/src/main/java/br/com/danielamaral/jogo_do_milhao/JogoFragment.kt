package br.com.danielamaral.jogo_do_milhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.danielamaral.jogo_do_milhao.databinding.FragmentJogoBinding
import br.com.danielamaral.jogo_do_milhao.model.Pergunta
import br.com.danielamaral.show_do_milhao.Database

class JogoFragment : Fragment() {

    private lateinit var perguntaSelecionada: Pergunta

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentJogoBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_jogo, container, false)

        perguntaSelecionada = selecionarPergunta()
        binding.tvPergunta.text = perguntaSelecionada.texto
        binding.rbResposta1.text = perguntaSelecionada.respostas[0].texto
        binding.rbResposta2.text = perguntaSelecionada.respostas[1].texto
        binding.rbResposta3.text = perguntaSelecionada.respostas[2].texto

        binding.btResponder.setOnClickListener {
            val rbSelecionadoId = binding.rgRespostas.checkedRadioButtonId
            var respostaSelecionada:String
            when(rbSelecionadoId){
                binding.rbResposta1.id -> respostaSelecionada = binding.rbResposta1.text.toString()
                binding.rbResposta2.id -> respostaSelecionada = binding.rbResposta2.text.toString()
                else -> respostaSelecionada = binding.rbResposta3.text.toString()
            }

            if(validarResposta(respostaSelecionada)){
                view?.findNavController()?.navigate(R.id.action_jogoFragment_to_ganhouFragment)
            }else{
                view?.findNavController()?.navigate(R.id.action_jogoFragment_to_perdeuFragment)
            }
        }
        return binding.root
    }

    private fun validarResposta(respostaSelecionada:String):Boolean{
        var isRespostaCorreta = false
        perguntaSelecionada.respostas.forEach { resposta ->
            if(respostaSelecionada.equals(resposta.texto) && resposta.correta){
                isRespostaCorreta=true
            }
        }
        return isRespostaCorreta
    }

    private fun selecionarPergunta():Pergunta{
        Database.perguntas.shuffle()
        var pergunta = Database.perguntas[0]
        pergunta.respostas = pergunta.respostas.shuffled()
        return Database.perguntas[0]
    }

}