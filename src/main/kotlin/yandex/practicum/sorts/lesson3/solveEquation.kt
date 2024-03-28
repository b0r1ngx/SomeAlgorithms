package yandex.practicum.sorts.lesson3

import kotlin.math.log2

/**
 * Бинарный поиск позволяет искать не только элемент массива.
 * Пусть нам нужно найти решение уравнения x⋅log2(x) = Y.
 * Вычислить значение выражения x⋅log2(x) легко,
 * а найти решение уравнения математически — нет.
 *
 * Поскольку функция x⋅log2(x) монотонно возрастает при x >= 1,
 * можно применить бинарный поиск.
 *
 *
 * Вместо математической функции может быть что-то более сложное.
 * Пусть у нас есть некоторый параметр (в примере выше это Y) и значение,
 * которое от этого параметра зависит (в примере выше это x⋅log2(x).
 * Тогда есть смысл пользоваться бинарным поиском при одновременном выполнении условий:
 *  1) Чем больше значение параметра — тем больше (или меньше) значение функции.
 *  2) Вычислить зависимое значение легко, а найти обратную зависимость — нет.
 */

fun equation(value: Double) = value * log2(value)

fun yandexSolveEquation(value: Double, precision: Int = 100): Double {
    var (left, right) = 1.0 to value
    var (mid, equationResult) = .0 to .0

    for (step in 0 until precision) {
        mid = (left + right) / 2
        equationResult = equation(value)

        if (equationResult < value)
            left = mid
        else
            right = mid
    }

    return mid
}