/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * 
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }

            val media = calcularMedia(listaNotas)
            println("Media da disciplina foi: $media")
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(notas: MutableList<Double>?): Double {
    if(notas != null) {
        return notas.sum() / notas.size
    } else {
        return 0.0
    }
}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val notasDaMateria = materiasENotas[materia] ?: return false
    notasDaMateria.addAll(notas.toList())
    return true
}


fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("Estrutura de Dados", mutableListOf(7.5, 9.2, 5.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia="Programação para Dispositivos Móveis", notas=mutableListOf(5.5, 10.0, 6.2))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    adicionarDisciplina("Padrões de Projeto")

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("GPS")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Estrutura de Dados", 8.2)
    adicionarNota("GPS", 2.3)
    adicionarNota("Programação para Dispositivos Móveis", 10.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Estrutura de Dados")
    mostrarNotas("Programação para Dispositivos Móveis")
    mostrarNotas("GPS")
    
    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Empreendedorismo")
    
    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    // feito

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Empreendedorismo", 5.5, 1.2, 9.2)
    
    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Empreendedorismo")
    
    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)
    
    // 11: calcularMedia -> Implemente a função calcularMedia()
    // check
    
    // 12: calcularMedia -> calcule a media de 2 disciplinas
    println(calcularMedia(materiasENotas["Empreendedorismo"]))
    
    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    // check
    
    // 14: mostrarNotas -> mostre as notas de 1 disciplina 
    mostrarNotas("Estrutura de Dados")

}