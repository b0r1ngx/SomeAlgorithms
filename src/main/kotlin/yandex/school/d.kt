package yandex.school

import java.lang.Math.pow
import kotlin.math.pow

fun solve(n: Short, array: List<Short>): Short {
    val c: Short = 1
    var numbers = 0
    array.forEach {
        if (it != c) numbers++
    }
    return (2.0.pow(numbers) - 1).toInt().toShort()
}

fun main() {
    val n = readln().toShort()
    val array = readln().split(' ').map { it.toShort() }
    println(solve(n, array))
}