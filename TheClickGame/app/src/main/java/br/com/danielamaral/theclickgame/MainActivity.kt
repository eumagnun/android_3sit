package br.com.danielamaral.theclickgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import br.com.danielamaral.cliquenobotao.Contador
import br.com.danielamaral.theclickgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var contadorPontos = 0
    private var contadorCliques=0
    private val pontosPorClique = 15
    private lateinit var contador: Contador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btRed.setOnClickListener {
            contadorCliques +=1
            contadorPontos = contadorCliques * pontosPorClique

            binding.tvCliques.text = contadorCliques.toString()
            binding.tvPontos.text = contadorPontos.toString()
        }

        Log.i("CICLO-DE-VIDA","onCreate")
        contador = Contador()

    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO-DE-VIDA","onStart")
        contador.iniciar()
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLO-DE-VIDA","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CICLO-DE-VIDA","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO-DE-VIDA","onStop")
        contador.parar()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO-DE-VIDA","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLO-DE-VIDA","onRestart")
    }
}