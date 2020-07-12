# Funções

Vídeo: https://youtu.be/xigaxndBJns

Baseado em _The joy of Kotlin_, Seção 2.7 e Capítulo 3

* Resumo
    * Funções em Kotlin

## Funções em Kotlin

* Kotlin admite funções aninhadas
    * Funções localmente definidas, ou simplesmente funções locais

```kotlin
fun f (x : Int) {

    fun g (y : Int) {
       return x + y;
    }

    return g(10);
}
```

* Sintaxe para os tipos de funções
    * Exemplos
        * `(Int) -> String`
        * `(String, Int) -> Pessoa`
    * Os tipos dos parâmetros obrigatoriamente devem aparecer entre parênteses 

* Transitando entre declarações com `fun` e declarações com lambdas
    * `val f = lambda` corresponde a `fun f(params) = corpo`
    * Tipos podem ser omitidos devido à inferência de tipos
        * Compare `g` e `ggg` abaixo
    * Pode acontecer de a anotação de tipo poder ser feita de mais de uma forma
    * Quando `Unit` é o tipo do retorno, o tipo pode ser omitido

(Trecho de `FunLab.kt`)
```kotlin
val f : (Int, String) -> Double =  { n, msg -> 1.0 * n * msg.length }

fun ff ( n: Int, msg: String ) : Double {
    return 1.0 * n * msg.length;
}

fun gg ( a: Double, b: String ) {
    print("$b: $a")
}

val g : (Double, String) -> Unit = { a, b -> print("$b: $a") }

val ggg = { a: Double, b: String -> print("$b: $a") }
```

* Funções de ordem superior
```kotlin
fun fos (f: (Int) -> Int, x: Int): Int = f(f(x))
fun <A> fos2 (f: (A) -> A) : (A) -> A = { x ->  f(f(x)) } 
```
No REPL:
```kotlin
fos ({ x -> x + x }, 1000)
res0: kotlin.Int = 4000

fos2( { x: Int -> x + x } ) (1000)
res1: kotlin.Int = 4000
```
* Sintaxe matemática ou sintaxe de objetos (`ponto`)
    * `f(a)` ou `a.f()`
    * `g(m,n)` ou `m.g(n)`
    * `y = f(g(h(x)))` (leitura `<<<<<<`) ou `y = x.h().g().f()` (leitura `>>>>>>`)
    * Nos tipos, a leitura é sempre `>>>>>>>`
        * `compor(h, g, f): (A) -> D`
        * `h: (A) -> B`
        * `g: (B) -> C`
        * `f: (C) -> D`
        * `compor: ( h: (A) -> B, g: (B) -> C, f: (C) -> D ): (A) -> D = { x -> x.h().g().f() }`

## Currying

* Homenagem ao lógico americano [Haskell Curry](https://pt.wikipedia.org/wiki/Haskell_Curry)
    * Na verdade, [Moses Schönfinkel](https://pt.wikipedia.org/wiki/Moses_Schönfinkel)

* `val f: (Int, Int) -> Int =  { a, b -> a + b }`
    * Como chamar:  `f(3, 4)`
    * Tipo : `(Int, Int) -> Int`
        * Pode-se pensar `(Int, Int)` como tupla

* `val ff: (Int) -> (Int) -> Int = { a -> { b -> a + b } }`
    * Como chamar: `f (3)(4)`
    * Tipo : `(Int) -> (Int) -> Int`
        * Com um só argumento: dado um `Int`, retorna uma função que espera um `Int`

* Aplicação parcial 
    * `val g: (Int) -> (Int) -> (Int) -> Int = { x -> { y -> { z -> 2 * x + 3 * y + z } } }`
        * `g(10)` retorna uma função que espera mais dois parâmetros
        * `g(10)(100)` retorna uma função que espera mais um parâmetro
        * `g(10)(100)(1000)` retorna 1320
    * Não confundir com _função parcial_
        * Função que não é total
        * Há valores no domínio que não estão definidos
            * `0` para `1/x`
            * Lista-nula para `car` e `cdr` em Lisp

* _Currying_ 
    `f(a,b)`   ➔   `f(a)(b)`
* _Uncurrying_ 
    `f(a)(b)`   ➔   `f(a,b)`

## Composição 

* Composição de funções puras

`cubo(dobro(10))`  ➔  8000

Objetivo
`compor(::cubo, ::dobro)(10)`

No `FunLab.kt`:
```kotlin
fun cubo (x: Int): Int = x * x * x
fun dobro(x: Int): Int = x + x

fun compor(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }

val cuboDoDobro = compor(::cubo, ::dobro)
val oitoMil = cuboDoDobro(10)
```