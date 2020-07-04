# Tipo Option

* Corresponde ao `Option` do OCaml, `Maybe` do Haskell
* Tipo soma 

* Haskell
```haskell
data Maybe a =
    Just a
  | Nothing

data Option a =
    Some a
  | None
```

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

