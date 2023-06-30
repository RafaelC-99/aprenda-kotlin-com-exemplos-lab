// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String, var nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun removerMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("João",Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Pedro", Nivel.DIFICIL)
    val usuario4 = Usuario("Leo", Nivel.BASICO)
    val usuario5 = Usuario("Antonio", Nivel.BASICO)
    
    val conteudoB1 = ConteudoEducacional("Conteudo basico 1")
    val conteudoB2 = ConteudoEducacional("Conteudo basico 2", 30)
    val conteudoB3 = ConteudoEducacional("Conteudo basico 3", 40)
    
    val conteudoI1 = ConteudoEducacional("Conteudo intermediario 1")
    val conteudoI2 = ConteudoEducacional("Conteudo intermediario 2")
    
    val conteudoD1 = ConteudoEducacional("Conteudo dificil 1")
    val conteudoD2 = ConteudoEducacional("Conteudo dificil 2")
    
    var conteudosBasicos = mutableListOf<ConteudoEducacional>(conteudoB1, conteudoB2, conteudoB3)
    var conteudosIntermediarios = mutableListOf<ConteudoEducacional>(conteudoI1, conteudoI2)
    var conteudosDificeis = mutableListOf<ConteudoEducacional>(conteudoD1, conteudoD2)

    
    var formacaoBasica = Formacao("basicio", conteudosBasicos)
    var formacoIntermediaria = Formacao("intermediario", conteudosIntermediarios)
    var formacaoDificil = Formacao("dificil", conteudosDificeis)
}