package org.example.br.com.alura.alugames.modelo

import br.com.alura.alugames.modelo.Recomendavel
import com.google.gson.annotations.Expose
import javax.persistence.*

data class Jogo(@Expose val titulo: String,
                @Expose val capa: String): Recomendavel {
    var descricao:String? = null
    var preco = 0.0

    var id: Int = 0

    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota > 10 || nota < 1) {
            println("A nota deve ser de 1 a 10")
        } else {
            listaNotas.add(nota)
        }
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id: Int = 0):
            this(titulo, capa) {
                this.preco = preco
                this.descricao = descricao
            }

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "ID: $id\n" +
                "Título: $titulo\n" +
                "Capa: $capa\n" +
                "Descricao: $descricao\n" +
                "Avaliação: $media\n" +
                "Preço: $preco"
    }
}