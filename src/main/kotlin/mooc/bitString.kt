package mooc

import kotlin.math.max

// You are given a bit string consisting of the characters 0 and 1.
// How many ways can you select two positions in the bit string so that the left position
// contains the bit 0 and the right position contains the bit 1?
fun bitString(bits: String): Int {
    var positions = 0

    val orderedIndexesOfOnes = mutableListOf<Int>()
    for (i in bits.indices) {
        val char = bits[i]
        if (char == '1') orderedIndexesOfOnes.add(i)
    }

    for (i in bits.indices) {
        val char = bits[i]
        if (char == '0') {
            var iteratedOnes = 0
            for (index in orderedIndexesOfOnes)
                if (i > index) iteratedOnes++
            positions += max(0, orderedIndexesOfOnes.size - iteratedOnes)
        }
    }

    return positions
}

fun main() {
    println(1 == bitString("01"))
    println(12 == bitString("01001011"))
}
