val f : (Int, String) -> Double =  { n, msg -> 1.0 * n * msg.length }

fun ff ( n: Int, msg: String ) : Double {
    return 1.0 * n * msg.length;
}

fun gg ( a: Double, b: String ) {
    print("$b: $a")
}

val g : (Double, String) -> Unit = { a, b -> print("$b: $a") }

val ggg = { a: Double, b: String -> print("$b: $a") }

// ---
// Funções de ordem superior
fun fos (f: (Int) -> Int, x: Int): Int = f(f(x))
fun <A> fos2 (f: (A) -> A) : (A) -> A = { x ->  f(f(x)) }

// Currying
val g2: (Int) -> (Int) -> (Int) -> Int = { x -> { y -> { z -> 2 * x + 3 * y + z } } }

// Compor
fun cubo (x: Int): Int = x * x * x
fun dobro(x: Int): Int = x + x

fun compor(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }

val cuboDoDobro = compor(::cubo, ::dobro)
val oitoMil = cuboDoDobro(10)

fun <T, U, V> compor2(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
    { f -> { g -> { x -> f(g(x)) } } }