package yandexpracticum.dstructures.lesson8

/**
 * Задача:
 * Дан массив целых чисел длины N и число K.
 * Для каждого окна длины K найдите его медиану.
 *
 * Подумайте, как бы вы решили эту задачу. Какова оптимальная асимптотика решения?
 * Мой ответ: O(N) (см. реализацию функции ниже)
 * Яндекса:
 * Нужно рассмотреть O(N) окон и для каждого мы будем хранить дерево размера O(K),
 * соответственно операции с ним на каждом шаге займут время O(logK).
 */

fun findMedianForWindow(array: Array<Int>, windowLength: Int): MutableList<Float> {
    val currentWindow = array.copyOfRange(0, windowLength).toMutableList()
    val isWindowLengthEvenNumber = windowLength % 2 != 1

    val mediums = mutableListOf<Float>()
    if (isWindowLengthEvenNumber) {
        val leftMediumIndex = windowLength / 2 - 1
        val rightMediumIndex = leftMediumIndex + 1

        var medium = (currentWindow[leftMediumIndex] + currentWindow[rightMediumIndex]).toFloat() / 2
        mediums.add(medium)

        for (i in 0 until array.size - windowLength) {
            currentWindow.removeAt(0)
            currentWindow.add(array[i + windowLength])
            medium = (currentWindow[leftMediumIndex] + currentWindow[rightMediumIndex]).toFloat() / 2
            mediums.add(medium)
        }
    } else {
        val mediumIndex = windowLength / 2 + 1
        var medium = currentWindow[mediumIndex].toFloat()
        mediums.add(medium)
        for (i in 0 until array.size - windowLength) {
            currentWindow.removeAt(0)
            currentWindow.add(array[i + windowLength])
            medium = currentWindow[mediumIndex].toFloat()
            mediums.add(medium)
        }
    }

    return mediums
}

fun main() {
    println(findMedianForWindow(
        array = arrayOf(5, 8, 3, 1, 15, 13, 19, 20),
        windowLength = 4
    ))
}