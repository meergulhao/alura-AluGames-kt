package org.example.br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi
import org.example.br.com.alura.alugames.modelo.Jogo
import java.util.Scanner


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite código de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    if (informacaoJogo != null) {
        meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
    } else {
        return
    }

//    val resultado = runCatching {
//
//        if (informacaoJogo != null) {
//            meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
//        } else {
//            return
//        }
//    }
    println("Você quer inserir uma descrição para esse jogo? (S/N)")
    val opcao = leitura.nextLine()
    if (opcao.equals("S", true)) {

        println("Insira a descrição abaixo:\n")
        meuJogo?.descricao = leitura.nextLine()

    } else {
        meuJogo?.descricao = meuJogo?.titulo
    }

    println(meuJogo)
    println("Busca realizada com sucesso!")

//    resultado.onSuccess {
//        println("Você quer inserir uma descrição para esse jogo? (S/N)")
//        val opcao = leitura.nextLine()
//        if (opcao.equals("S", true)) {
//
//            println("Insira a descrição abaixo:\n")
//            meuJogo?.descricao = leitura.nextLine()
//
//        } else {
//            meuJogo?.descricao = meuJogo?.titulo
//        }
//
//        println(meuJogo)
//    }
//
//    resultado.onSuccess {
//        println("Busca realizada com sucesso!")
//    }

}
