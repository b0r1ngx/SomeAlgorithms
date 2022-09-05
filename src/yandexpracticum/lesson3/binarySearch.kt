package yandexpracticum.lesson3

fun binarySearch(sortedArray: Array<Int>, target: Int): Boolean {
    var (left, mid, right) = Triple(0, 0, sortedArray.size)

    while (left < right) {
        mid = (left + right) // 2

        if (sortedArray[mid] == target)
            return true
        else if (sortedArray[mid] > target)
            left = mid + 1
        else
            right = mid

    }

    return false
}

/**
 * Нестандартные применения бинарного поиска.
 *
 * Некоторые задачи формально не удовлетворяют условию монотонности
 * и, тем не менее, решаются бинарным поиском.
 *
 * Задача: дана бинарная строка длины N, состоящая только из нулей и единиц.
 * Гарантируется, что самый левый её элемент 0, а самый правый — 1.
 * Найдите любое вхождение подстроки “01”.
 */

fun binarySearch(): Nothing = TODO()