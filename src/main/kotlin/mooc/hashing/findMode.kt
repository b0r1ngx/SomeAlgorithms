package mooc.hashing

// You are given a list of numbers, and your task is to compute the mode,
// which is the most frequent number on the list.
// If the mode is not unique, you can choose any of the possible choices for the most frequent number.
fun findMode(numbers: List<Int>): Int {
    val counter = mutableMapOf<Int, Int>()
    var mode = numbers[0]

    for (number in numbers) {
        counter[number] = counter.getOrDefault(number, 0) + 1

        if (counter.getOrDefault(number, 0) > counter.getOrDefault(mode, 0))
            mode = number
    }

    return mode
}

fun main() {
    println(2 == findMode(listOf(1, 2, 3, 2, 2, 3, 2, 2)))
    println(listOf(1, 2).contains(findMode(listOf(1, 1, 2, 2))))
}
