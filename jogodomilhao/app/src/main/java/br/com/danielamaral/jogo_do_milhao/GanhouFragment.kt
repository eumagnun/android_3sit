package br.com.danielamaral.jogo_do_milhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.danielamaral.jogo_do_milhao.databinding.FragmentGanhouBinding


class GanhouFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingGanhou: FragmentGanhouBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_ganhou, container, false)
        bindingGanhou.btJogarDeNovo.setOnClickListener {
            jogarDeNovo()
        }
        return bindingGanhou.root
    }

    private fun jogarDeNovo() {
        view?.findNavController()?.navigate(R.id.action_ganhouFragment_to_jogoFragment)
    }

}