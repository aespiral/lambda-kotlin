# Dobraduras

`fold` & Cia.

## A função

```kotlin
    val lista = listOf(5, 7, 10, 3, 2, 18)

    val s1 = lista.sum()
    val s2 = lista.fold(0) { acc, elem -> acc + elem }

    val m1 = lista.max()
    val m2 = lista.fold(-1000) { acc, elem -> if (elem > acc) elem else acc }
```

## `fold` X `foldRight`

``` 
    1 + 2 + 3 + 4

    ((1 + 2) + 3) + 4    // fold
 
    1 + (2 + (3 + 4))    // foldRight
 
```