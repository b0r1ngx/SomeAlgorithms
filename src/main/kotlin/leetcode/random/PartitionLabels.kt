package leetcode.random

fun partitionLabels(s: String): List<Int> {
    val result = mutableListOf<String>()

    val charIndexMap = mutableMapOf<Char, MutableList<Int>>()
    s.forEachIndexed { index, char ->
        if (charIndexMap[char] != null) {
            charIndexMap[char]!!.add(index)
        } else {
            charIndexMap[char] = mutableListOf(index)
        }
    }

    var currIndex = 0
    for ((char, charOccurrences) in charIndexMap) {
        if (charOccurrences.size == 1) {
            result.add(char.toString())
            continue
        }

        val minIndex = charOccurrences.first()
        val maxIndex = charOccurrences.last()

        if (currIndex <= minIndex) {
            currIndex = minIndex
        }

        while (true) {
            val char = s[currIndex]
            charIndexMap[char]
        }
    }

    for (char in s) {
        val charOccurrences = charIndexMap[char]!!
    }
// scratch idea
//    currIndex = 0
//    char = s[currIndex]
//    charOccuerences  = map[char]
//
//
//    while currIndex < maxIndex
//        if maxIndex == s.length -1:
//        result.add(s.substring(currIndex, maxIndex - 1))
//        return@forEach
//
//
//        currChar = s[currIndex]
//
//        charIndexes = map[currChar]
//
//        if charIndexes.max > maxIndex
//        char = currChar
//
//        currIndex += 1
//
//        if currIndex == maxIndex
//        result.add(s.substring(minIndex, maxIndex))

    return result.map { it.length }
}

fun main() {
    val test = "abc" // "a", "b", "c". [1,1,1]
    val s = "ababcbacadefegdehijhklij" // "ababcbaca", "defegde", "hijhklij". [9,7,8]
    // a: [0, 2, 6, 8], b: [1, 3, 5], c: [4, 7],
    // d: [9, 13], e: [10, 14], f: [11], g: [12],
    // h: [15, 18], i: [16, 21], j: [17, 22], k: [19], l: [20]
    print(partitionLabels(s))
}