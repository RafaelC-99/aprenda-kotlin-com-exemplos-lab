// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(var nome: String, var idade: Int, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun removerMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }
}

fun imprimirNumeroDeUsuarios(formacao: Formacao){
    println(formacao.inscritos.size)
}

fun imprimirConteudos(formacao: Formacao){
    println("Conteudos:")
    println("--------------------")
    for(conteudo in formacao.conteudos){
        println("Nome: ${conteudo.nome}, carga-horaria: ${conteudo.duracao}")
    }
}

fun imprimirDadosDeUsuarios(formacao: Formacao){
    println("Alunos:")
    println("--------------------")
    for(usuario in formacao.inscritos){
        println("Nome: ${usuario.nome}, idade: ${usuario.idade}")
    }
}

fun imprimirNivel(nivel: Nivel){
    when(nivel){
        Nivel.BASICO -> println("Nivel: Basico")
        Nivel.INTERMEDIARIO -> println("Nivel: Intermediario")
        Nivel.DIFICIL -> println("Nivel: Dificil")
    }
}

fun imprimirInformacoesGeraisDeFormacao(formacao: Formacao){
    println("Nome do curso: ${formacao.nome}")
    imprimirNivel(formacao.nivel)
    println()
    imprimirConteudos(formacao)
    println()
    imprimirDadosDeUsuarios(formacao)
    
    println("___________________________________________________________________")
    println()
}

fun main() {
    val usuario1 = Usuario("João",18, "joao@email.com")
    val usuario2 = Usuario("Maria", 20, "maria@email.com")
    val usuario3 = Usuario("Pedro", 22, "pedro@email.com")
    val usuario4 = Usuario("Leo", 20, "leo@email.com")
    val usuario5 = Usuario("Antonio", 30, "antonio@email.com")
    
    val conteudoB1 = ConteudoEducacional("Conteudo basico 1")
    val conteudoB2 = ConteudoEducacional("Conteudo basico 2", 30)
    val conteudoB3 = ConteudoEducacional("Conteudo basico 3", 40)
    
    val conteudoI1 = ConteudoEducacional("Conteudo intermediario 1")
    val conteudoI2 = ConteudoEducacional("Conteudo intermediario 2")
    
    val conteudoD1 = ConteudoEducacional("Conteudo dificil 1")
    val conteudoD2 = ConteudoEducacional("Conteudo dificil 2")
    
    val conteudosBasicos = mutableListOf<ConteudoEducacional>(conteudoB1, conteudoB2, conteudoB3)
    val conteudosIntermediarios = mutableListOf<ConteudoEducacional>(conteudoI1, conteudoI2)
    val conteudosDificeis = mutableListOf<ConteudoEducacional>(conteudoD1, conteudoD2)

    val formacaoBasica = Formacao("Curso de formacao Kotlin 1", conteudosBasicos, Nivel.BASICO)
    val formacaoIntermediaria = Formacao("Curso de formacao Kotlin 2", conteudosIntermediarios, Nivel.INTERMEDIARIO)
    val formacaoDificil = Formacao("Curso de formacao Kotlin 3", conteudosDificeis, Nivel.DIFICIL)
    
    imprimirInformacoesGeraisDeFormacao(formacaoBasica)
    
    formacaoBasica.matricular(usuario1)
    formacaoBasica.matricular(usuario2)
    
    imprimirInformacoesGeraisDeFormacao(formacaoBasica)
   
   	formacaoIntermediaria.matricular(usuario1)
    formacaoIntermediaria.matricular(usuario5)
    formacaoIntermediaria.matricular(usuario4)
    
    imprimirInformacoesGeraisDeFormacao(formacaoIntermediaria)
    
    formacaoDificil.matricular(usuario3)
    formacaoDificil.matricular(usuario2)
    formacaoDificil.matricular(usuario4)
    
    imprimirInformacoesGeraisDeFormacao(formacaoDificil)
}