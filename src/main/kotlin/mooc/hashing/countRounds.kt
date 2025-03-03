package mooc.hashing

// You are given a list of numbers.
// Your task is to collect all the numbers in order from smallest to largest so that in each round you go through the list from left to right. How many rounds do you need?
//
// For example, the list [3, 6, 1, 7, 5, 2, 4, 8] requires 4 rounds.
// The first round collects the numbers 1 and 2, the second round the numbers 3 and 4,
// the third round the number 5, and the fourth round the numbers 6, 7 and 8.
fun countRounds(numbers: List<Int>): Int {
    val orderedSequences = mutableMapOf<Int, MutableList<Int>>()

    for (number in numbers) {
        val prevValue = number - 1
        // todo: can we optimize this, to not use values of map?
        val isPrevValueContained = orderedSequences.values.find {
            it.last() == prevValue
        }?.first()

        if (isPrevValueContained != null)
            orderedSequences[isPrevValueContained]?.add(number)
        else
            orderedSequences[number] = mutableListOf(number)
    }

    println(orderedSequences)
    return orderedSequences.keys.size
}

fun main() {
    println(4 == countRounds(listOf(3, 6, 1, 7, 5, 2, 4, 8)))
}
