# Programação genérica
* Programação genérica ou polimorfismo paramétrica
    * O tipo (classe) é incompleto, deixando um lacuna (parâmetro) para receber um outro
    tipo que o completa

```haskell
data Poli a = P a Int deriving (Eq, Show)

x :: Poli Bool
x = P True 3
```

## Classes genéricas em Kotlin
```kotlin
class Caixa<T> (val cont:T) {
    
}
```
## Funções
```kotlin
fun <T> f(x: T) {
  
}
```
## Variância

* `Subt` é subtipo de `T`, e existe um classe `X` que é parametrizada por `T`, 
então qual é a relação entre `X<Subt>` e `X<T>`? 
    * `X<Subt>` é subtipo de `X<T>` : covariância
    * `X<T>` é subtipo de `X<Subt>` : contravariância
    * Não é possível relacionar: invariância

* Kotlin tem mecanismos para expressar essas ideias; quando, pela semântica de `X`, conhece-se o seu comportamento
    *  `X<out T>` define uma relação de covariância entre `T` e `X<T>`
    *  `X<in T>` define uma relação de contravariância entre `T` e `X<T>`

* Sobre o comportamento de `X`
    * Se `X` tem métodos que apenas retornam valores `T`, ela é dita "geradora" (`out`), portanto covariante
    * Se `X` tem métodos que apenas recebem valores `T`, ela é dita "consumidora" (`in`), contravariante

[Documentação Kotlin sobre _generics_](https://kotlinlang.org/docs/reference/generics.html)

