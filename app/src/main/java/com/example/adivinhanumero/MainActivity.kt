package com.example.adivinhanumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    private val  random = Random()
    private var numeroAdivinhar = 0
    private var jogo = 0
    private var tentativas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        novoJogo()
    }

    private fun novoJogo() {

        numeroAdivinhar = random.nextInt(10) + 1
        jogo++
        tentativas = 0

        atualizaJogo()
        atualizaTentativas()

    }

    private fun atualizaJogo() {
        findViewById<TextView>(R.id.textViewJogo).text = getString(R.string.jogo) + jogo
    }

    private fun atualizaTentativas() {
        findViewById<TextView>(R.id.editViewTentativa).text = getString(R.string.tentativas) + tentativas
    }

    fun Adivinha(view: View) {
        val editTextNumero = findViewById<TextView>(R.id.editTextNumero)

        val numero = editTextNumero.text.toString().toIntOrNull()
        when(numero){
            in 1..10 -> verificaSeAcertou(numero!!)
            null -> editTextNumero.error = getString(R.string.insira_numero)
            else -> editTextNumero.error = getString(R.string.numero_invalido)
        }
    }

    private fun verificaSeAcertou(numero: Int) {
       val textViewFeedBack = findViewById<TextView>(R.id.textViewFeedBack)

        tentativas++
        atualizaTentativas()

        if (numero == numeroAdivinhar){
            textViewFeedBack.text = getString(R.string.acertou)
            querJogarNovamente()
        }else if (numeroAdivinhar > numero){
            textViewFeedBack.text = getString(R.string.numero_maior)
        }else{
            textViewFeedBack.text = getString(R.string.numero_menor)
        }

    }

    private fun querJogarNovamente() {
        //todo: Criar AlerDialog (perguntar se quer jogar novamente)
    }
}