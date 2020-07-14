package ed

sealed class Lista<out A>
//TODO > melhorar toString de Lista
object Nil: Lista<Nothing>()
data class Cons<A>(val cab: A, val cau: Lista<A>): Lista<A>()

val l1 = Cons(3, Cons(10, Cons (7, Nil)))

//TODO Refazer como método
fun <A> tamanho (lista: Lista<A>): Int = when (lista) {
    is Nil -> 0
    is Cons -> 1 + tamanho(lista.cau)
}

//TODO Refazer como método estático da classe Lista
fun soma (lista: Lista<Int>): Int = when (lista) {
    is Nil -> 0
    is Cons -> lista.cab + soma(lista.cau)
}

//TODO Refazer como método da classe Lista
fun <A> substituir(alvo: A, novo: A, lista: Lista<A> ): Lista<A> =
    when(lista) {
        is Nil -> Nil
        is Cons -> when {
            alvo == lista.cab -> Cons(novo, lista.cau)
            else -> Cons( lista.cab , substituir(alvo, novo, lista.cau) )
        }
    }

// val l2 = listOf(7,12,15,92,1004,9,3,33,212).paraLista()

fun <E> List<E>.paraLista(): Lista<E> = TODO()
// * Dois mecanismos de Kotlin:
//     * Funções de extensão > vamos ampliar a classe List, que originalmente não é nossa
//     * Função TODO()

sealed class Arv<out A>
data class Folha<A>(val valor: A): Arv<A>()
data class RmE<A>(val valor: A, val rmE: Arv<A>): Arv<A>()
data class RmD<A>(val valor: A, val rmD: Arv<A>): Arv<A>()
data class Bif<A>(val valor: A, val rmE: Arv<A>, val rmD: Arv<A>): Arv<A>()

val a1: Arv<Int> = Bif(40, RmD(15, Folha(37)), Folha(80))

//TODO Refazer como função da classe Arv
fun inserir(elem: Int, no: Arv<Int>): Arv<Int> =
    when (no) {
        is Folha -> when {
            elem >= no.valor -> RmD(no.valor, Folha(elem))
            else             -> RmE(no.valor, Folha(elem))
        }
        is RmE -> when {
            elem >= no.valor -> Bif(no.valor, no.rmE, Folha(elem))
            else             -> RmE(no.valor, inserir(elem, no.rmE))
        }
        is RmD -> when {
            elem >= no.valor -> RmD(no.valor, inserir(elem, no.rmD))
            else             -> Bif(no.valor, no.rmD, Folha(elem))
        }
        is Bif -> when {
            elem >= no.valor -> Bif(no.valor, no.rmE, inserir(elem, no.rmD))
            else             -> Bif(no.valor, inserir(elem, no.rmE), no.rmD)
        }
    }

val a2 = inserir(50, a1)

fun main() {
    println(tamanho(l1))
    println(soma(l1))

    println(soma(substituir(10, 11, l1)))
    println(a2)
}