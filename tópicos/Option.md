# Tipo Option

* Corresponde ao `Option` do OCaml, `Maybe` do Haskell
* Tipo soma genérico que incorpora completamente um tipo qualquer e a ele adiciona um valor único, que representa erro.

* Haskell
```haskell
data Maybe a =
    Just a
  | Nothing

x :: Maybe Int
x = Just 10

y :: Maybe Char
y = Nothing
```

* Cardinalidade

    \# `Maybe a` = \# `a` + 1

## Implementação

* Kotlin (baseado em `The Joy of Kotlin`, Pierre-Yves Saumont , Listing 6.1)

```kotlin
sealed class Option<out A> {
    abstract fun isEmpty(): Boolean
    internal object None: Option<Nothing>() {
        override fun isEmpty() = true
        override fun toString() = "None"
        override fun equals(other: Any?): Boolean =
              other === None
        override fun hashCode(): Int = 0
    }
    internal data class Some<out A> (internal val value: A) : Option<A>() {
        override fun isEmpty() = false
    }
    companion object {
        operator fun <A> invoke(a: A? = null): Option<A>
            = when(a) {
                null -> None
                else -> Some(a)
            }
    }
}
```
