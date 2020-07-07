enum class A {
    Um, Zero
}

enum class B {
    V, F
}

enum class C {
    Triangulo
}

sealed class D
data class Numero(val n:A) : D()
data class Letra(val l:B) : D()
data class Forma(val f:C) : D()

fun f (x : D) : String = when (x) {
    is Numero -> "é número, e o valor é ${x.n}"
    is Letra -> "é número, e o valor é ${x.l}"
    is Forma -> "é número, e o valor é ${x.f}"
}

fun g (x : D) : Int = when (x) {
    is Numero -> 2
    is Letra -> 10
    is Forma -> 23
}

fun main() {
    val v1 : D = Numero(A.Um)
    val v2 : D = Forma(C.Triangulo)
    val v3 : D = Letra(B.F)
    println ("$v1 $v2 $v3")
}