import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Guilherme Mergulhão", "guilherme@email.com")
    println(gamer1)

    val gamer2 = Gamer("Karen Moller", "karen@email.com", "25/01/1992", "karen")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "23/02/1992"
        it.usuario = "mergulhao"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "gui"
    println(gamer1)
}