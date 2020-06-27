# Tipos algébricos de dados

* TAD ≠ TAD
* 0, 1, ⨉, +

Não confundir com Tipos Abstratos de Dados

"Algébricos" porque alguns tipos são como o 0,
outros como o 1,
e há produto e soma.

## Tipo `Nothing`

* Não existe valor algum 
* Usado como retorno de funções sem retorno

```kotlin
fun f() : Nothing {
    while(true) ;
}

fun g() : Nothing {
    throw Exception
}
```

## Tipo unitário

* Tipo: `Unit`
* Valor: `()`
* Não contém nenhuma informação
    * Aquilo que só pode valer 1 coisa, não traz informação
    * Um evento que tem 100% de probabilidade de ocorrer não traz informação
        * Teoria da informação 
        * I = log (1/P)
        * I = log (1/1) = 0

## Tipos produto

* Tuplas
* Registros (_Records_)

Em programação funcional, tuplas estão presentes e há facilidade em criar e operar.

Por exemplo, em OCaml: `(3, true, "Hello", 4.76, Pessoa "Ruy" 67)`

---
* Tuplas em Kotlin
    * `Pair`
    * `Triple`
    * Criação: `to`
    * Consumo: `first`, `second`, "quebra" (_destructuring_)


Em Kotlin, só há duas classes prontas que exercem a função de tuplas:
`Pair` e `Triple`, para tuplas de 2 e 3 posições respectivamente.

Para demais "larguras", a linguagem incentiva a criação de classes, 
visto que é tão barato criar classes em Kotlin em qualquer ponto do programa.

Para criar uma dupla: `Pair<>(4, "oi")`, ou `4 to "oi"`

Para consumir uma dupla: pelos campos (`first`, `second`)
ou por `val (a, b) = (4, "oi")`

---
* Registros
    * _Records_ em Pascal
    * _Structs_ em C
    * Classes em Java, Kotlin

---
* Por que "Tipos Produto" ?
    * Tem teoria de conjuntos: produto cartesiano
    * Número de elementos

* `Pair<Boolean, Bool>` tem 4 = 2 * 2 possíveis elementos
    * `(true, true)`
    * `(true, false)`
    * `(false, false)`
    * `(false, true)`

* `Pair<Boolean, Unit>` tem 2 = 2 * 1 possíveis elementos
    * `(true, ())`
    * `(false, ())`

## Tipos soma

* Pouco conhecidos fora da programação funcional
    * `union` e `enum` em C
* Em teoria dos conjuntos: união disjunta

---
* Por que "Tipos Soma"?
    * Um tipo soma feito a partir de `Boolean` e `Unit` tem 3 = 2 + 1 elementos
        * `true`
        * `false`
        * `()`

---
* Tipos soma em Kotlin
    * `enum class`
    * `sealed class`

TODO: trazer links para a documentação _online_

* Para consumir tipos soma em Kotlin:
    * _Matching_ 
    * `when`
    * _Smart casts_ 
    
Em programação funcional em geral, existe _pattern matching_,
que é mais amplo um pouco que o `when` em Kotlin.

---
* Tipos soma X herança

Em programação funcional em geral, não há o mecanismo de herança.

Na modelagem de dados em programação funcional, há similaridades
entre o emprego dos tipos soma e alguma forma de herança na
orientação a objetos.

⚠️ Mas não são conceitos equivalentes !!!

Em Kotlin, temos os 2 !!!

