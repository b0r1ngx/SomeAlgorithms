package mooc.list

// You are given a list containing n integers.
// Your task is to count how many ways one can split the list into two parts
// so that both parts have the same total sum of elements.
fun listSplitting(numbers: List<Int>): Int {
    var splitCounter = 0
    val totalSum = numbers.sum()
    var leftSum = 0
    for (i in 0 .. numbers.size - 2) {
        val number = numbers[i]
        leftSum += number
        val rightSum = totalSum - leftSum
        if (leftSum == rightSum) splitCounter++
    }
    return splitCounter
}

fun main() {
    // 3 splits between indexes: 1 & 2, 3 & 4, 5 & 6
    println(3 == listSplitting(listOf(1, -1, 1, -1, 1, -1, 1, -1)))
    println(1 == listSplitting(listOf(1, 1, 1, 1)))
    println(3 == listSplitting(listOf(0, 0, 0, 0)))
    println(2 == listSplitting(listOf(1, 1, 0, 1, 1)))
    println(0 == listSplitting(listOf(1, 1, 1)))
    println(0 == listSplitting(listOf(-1, 0, 1)))
    println(1 == listSplitting(listOf(-1, 1, 0)))
    println(1 == listSplitting(listOf(0, 1, -1)))
    println(1 == listSplitting(listOf(0, -1, 1)))
    println(1 == listSplitting(listOf(1, 1)))
    println(0 == listSplitting(listOf(-1, 0)))
    println(0 == listSplitting(listOf(1, -1)))
    println(0 == listSplitting(listOf(0)))
    println(0 == listSplitting(listOf()))
}
