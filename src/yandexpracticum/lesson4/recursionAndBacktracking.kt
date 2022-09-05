package yandexpracticum.lesson4

/**
 *  I knew a shortcut, with a formula !)
 *  (thx Wiki, it's a really must have formula, u must see and know about it)
 */

fun fibonacci(n: Int): Int {
    if (n <= 1)
        return n

    var (prev, curr) = 0 to 1

    for (step in 0 until n)
        prev = curr.also { curr += prev }

    return curr
}

/**
 * Это решение (выше) лучше рекурсии с мемоизацией,
 * но если потребуется выполнять эту операцию несколько раз,
 * то оно становится хуже.
 *
 * Решение проблемы: завести массив для посчитанных значений
 */

fun main() {
    println(fibonacci(2))
}