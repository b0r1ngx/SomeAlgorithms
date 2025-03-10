package leetcode.list


// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
fun trap(heights: IntArray): Int {
    var volume = 0

    var leftPointer = 0
    var currentVolume = 0
    for (i in heights.indices) {
        val height = heights[i]
        if (height < heights[leftPointer]) {
            currentVolume += heights[leftPointer] - height
        } else {
            leftPointer = i
            volume += currentVolume
            currentVolume = 0
        }
    }

    currentVolume = 0
    var rightPointer = heights.size - 1
    for (i in heights.size - 1 downTo leftPointer) {
        val height = heights[i]
        if (height < heights[rightPointer]) {
            currentVolume += heights[rightPointer] - height
        } else {
            rightPointer = i
            volume += currentVolume
            currentVolume = 0
        }
    }

    return volume
}

fun main() {
    println(6 == trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(9 == trap(intArrayOf(4, 2, 0, 3, 2, 5)))

    // x
    // x       x
    // x x   x x
    println(4 == trap(intArrayOf(3, 1, 0, 1, 2)))

    // x           x
    // x       x   x
    // x x   x x x x
    println(10 == trap(intArrayOf(3, 1, 0, 1, 2, 1, 3)))

    // x       x
    // x       x   x
    // x x   x x x x
    println(8 == trap(intArrayOf(3, 1, 0, 1, 3, 1, 2)))
}
