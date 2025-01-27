package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite código de jogo para buscar:")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    var meuJogo:Jogo? = null

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

//    try {
//        val gson = Gson()
//        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
//        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//        println(meuJogo)
//    } catch (ex: JsonSyntaxException) {
//        println("Jogo não encontrado! Tente outro id.")
//    }

    val gson = Gson()

    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo não encontrado! Tente outro id.")
    }

    resultado.onSuccess {
        println("Você quer inserir uma descrição para esse jogo? (S/N)")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)) {

            println("Insira a descrição abaixo:\n")
            meuJogo?.descricao = leitura.nextLine()

        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca realizada com sucesso!")
    }

}
