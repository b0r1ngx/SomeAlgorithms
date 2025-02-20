package codewars

// Imagine two rings with numbers on them. The inner ring spins clockwise (decreasing by 1 each spin)
// and the outer ring spins counter clockwise (increasing by 1 each spin).
// We start with both rings aligned on 0 at the top, and on each move we spin each ring one increment.
// How many moves will it take before both rings show the same number at the top again?
// The inner ring has integers from 0 to innerMax and the outer ring has integers from 0 to outerMax,
// where innerMax and outerMax are integers >= 1.
fun spinningRings(innerMax: Int, outerMax: Int): Int {
    var innerPointer = innerMax
    var outerPointer = 1
    var moves = 1

    while (innerPointer != outerPointer) {
        innerPointer -= 1
        if (innerPointer == -1)
            innerPointer = innerMax

        outerPointer += 1
        if (outerPointer > outerMax)
            outerPointer = 0

        moves += 1
    }

    return moves
}

fun main() {
    println(spinningRings(2, 3) == 5)
    println(spinningRings(3, 2) == 2)
    println(spinningRings(1, 1) == 1)
    println(spinningRings(2, 2) == 3)
    println(spinningRings(3, 3) == 2)
}
