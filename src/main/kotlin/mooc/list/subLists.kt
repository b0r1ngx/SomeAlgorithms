package mooc.list

// You are given a list containing n integers.
// How many ways can we choose a sublist that contains exactly two distinct integers?
// Go through the list, and at each position, compute how many solutions end at the current position.
fun subLists(numbers: List<Int>): Int {
    var subListsCounter = 0
    var leftPointer = -1
    var rightPointer = -1

    for (i in 1 ..< numbers.size) {
        val value = numbers[i]
        if (value != numbers[i - 1]) {
            if (value != numbers.getOrNull(rightPointer))
                leftPointer = rightPointer
            rightPointer = i - 1
        }
        subListsCounter += rightPointer - leftPointer
    }
    return subListsCounter
}

fun main() {
    println(14 == subLists(listOf(1, 2, 3, 3, 2, 2, 4, 2)))
    //                            0, 1, 1, 1, 3, 3, 2, 3

    println(11 == subLists(listOf(1, 2, 2, 3, 3, 2, 4)))
    //                            0, 1, 1, 2, 2, 4, 1

    println(7 == subLists(listOf(1, 2, 1, 2, 3)))
    //                           0, 1, 2, 3, 1
    // (1, 2),
    // (1, 2, 1), (2, 1),
    // (1, 2, 1, 2), (2, 1, 2), (1, 2),
    // (2, 3)

    println(15 == subLists(listOf(1, 2, 1, 2, 1, 2)))
    //                            0, 1, 2, 3, 4, 5
}
