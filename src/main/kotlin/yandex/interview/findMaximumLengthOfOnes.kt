package yandex.interview

// Найти максимальное количество подряд идущих 1, в списке из 0 и 1
// требуется удалить одно промежуточное значение
fun findMaximumLengthOfOnes(list: List<Int>): Int {
    if (list.size < 2) return 0
    val maxLengthOfOnes = mutableListOf<Int>()

    var currentLength = 0
    for (value in list) {
        if (value == 1) currentLength++
        else {
            maxLengthOfOnes.add(currentLength)
            currentLength = 0
        }
    }

    // check if last value in list, != 0
    if (currentLength != 0)
        maxLengthOfOnes.add(currentLength)

    if (maxLengthOfOnes.size == 1)
        return maxLengthOfOnes[0] - 1

    var maxLength = 0
    for (i in 0 .. maxLengthOfOnes.size - 2) {
        val neighborsLength = maxLengthOfOnes[i] + maxLengthOfOnes[i + 1]
        if (neighborsLength > maxLength) maxLength = neighborsLength
    }

    return maxLength
}

fun main() {
    println(0 == findMaximumLengthOfOnes(listOf()))
    println(0 == findMaximumLengthOfOnes(listOf(1)))
    println(1 == findMaximumLengthOfOnes(listOf(1, 1)))
    println(0 == findMaximumLengthOfOnes(listOf(0)))
    println(2 == findMaximumLengthOfOnes(listOf(1, 0, 1)))
    println(2 == findMaximumLengthOfOnes(listOf(1, 0, 1, 0, 1)))
    println(6 == findMaximumLengthOfOnes(listOf(1, 0, 0, 1, 0, 1, 1, 1, 1, 1)))
    println(6 == findMaximumLengthOfOnes(listOf(1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1)))
    println(11 == findMaximumLengthOfOnes(listOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0)))
    println(12 == findMaximumLengthOfOnes(listOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    println(12 == findMaximumLengthOfOnes(listOf(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1)))
    println(12 == findMaximumLengthOfOnes(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
}
