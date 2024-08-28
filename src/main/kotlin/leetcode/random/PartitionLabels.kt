package leetcode.random

fun partitionLabels(s: String): List<Int> {
    val result = mutableListOf<Int>()

    val leftPointer = 0
    val rightPointer = s.length - 1

    val charIndexMap = mutableMapOf<Char, MutableList<Int>>()
    s.forEachIndexed { index, char ->
        if (charIndexMap[char] != null) {
            charIndexMap[char]!!.add(index)
        } else {
            charIndexMap[char] = mutableListOf(index)
        }
    }

    for (char in s) {
        val charOccurrences = charIndexMap[char]

        val minIndex = charOccurrences?.first() ?: -1
        val maxIndex = charOccurrences.last()
    }

    return result
}

fun main() {
    val test = "abc" // "a", "b", "c". [1,1,1]
    val s = "ababcbacadefegdehijhklij" // "ababcbaca", "defegde", "hijhklij". [9,7,8]
    // a: [0, 2, 6, 8], b: [1, 3, 5], c: [4, 7],
    // d: [9, 13], e: [10, 14], f: [11], g: [12],
    // h: [15, 18], i: [16, 21], j: [17, 22], k: [19], l: [20]
    print(partitionLabels(s))
}