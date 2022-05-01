package br.com.danielamaral.listacompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.danielamaral.listacompras.model.Produto

class VisualizarActivity : AppCompatActivity() {

    private lateinit var produtoSelecionado: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        produtoSelecionado = intent.getSerializableExtra("produtoSelecionado") as Produto

        val tvNome:TextView = findViewById(R.id.tvNome)
        val tvMarca:TextView = findViewById(R.id.tvMarca)
        val tvPreco:TextView = findViewById(R.id.tvPreco)

        tvNome.text = produtoSelecionado.nome
        tvMarca.text = produtoSelecionado.marca
        tvPreco.text = produtoSelecionado.preco.toString()

    }
}