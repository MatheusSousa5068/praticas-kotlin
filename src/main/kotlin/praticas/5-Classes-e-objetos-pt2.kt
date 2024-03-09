open class Funcionario(val nome: String, val idade: Int) {
    init {
        println("Funcionário: $nome com $idade anos foi criado com sucesso.")
    }

    fun apresentar() {
        println("Olá, eu sou $nome e tenho $idade anos - ${this.javaClass}")
    }
}

class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade)
class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade)
class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade)

fun main() {
    val listaDeFuncionarios = mutableListOf<Funcionario>()
    listaDeFuncionarios.add(Gerente("Matheus", 19, "TI"))
    listaDeFuncionarios.add(Desenvolvedor("Marcela", 20, "Python"))
    listaDeFuncionarios.add(Analista("Juan", 21, "RH"))

    for (funcionario in listaDeFuncionarios) {
        when (funcionario) {
            is Gerente -> {
                println("Gerente:")
                (funcionario as Funcionario).apresentar()
            }
            is Desenvolvedor -> {
                println("Desenvolvedor:")
                (funcionario as Funcionario).apresentar()
            }
            is Analista -> {
                println("Analista:")
                (funcionario as Funcionario).apresentar()
            }
        }
    }
}