package leetcode.random

/* Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 */
fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val fixedIntervals = intervals.sortedBy { it[0] } + intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)

    val firstInterval = fixedIntervals[0]
    var currIntervalMin = firstInterval[0]
    var currIntervalMax = firstInterval[1]

    for (interval in fixedIntervals) {
        val currMin = interval[0]
        val currMax = interval[1]

        if (currIntervalMax >= currMin) {
            if (currMin < currIntervalMin) {
                currIntervalMin = currMin
            }

            if (currMax > currIntervalMax) {
                currIntervalMax = currMax
            }
        } else {
            result.add(intArrayOf(currIntervalMin, currIntervalMax))
            currIntervalMin = currMin
            currIntervalMax = currMax
        }
    }

    return result.toTypedArray()
}

// why this version is faster than previous? O_O
fun mergeIntervals2(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    val fixedIntervals = intervals.sortedBy { it[0] } + intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)

    val firstInterval = fixedIntervals[0]
    var currIntervalMin = firstInterval[0]
    var currIntervalMax = firstInterval[1]

    for (interval in fixedIntervals) {
        val currMin = interval[0]
        val currMax = interval[1]

        if (currMin < currIntervalMin) {
            currIntervalMin = currMin
        }

        if (currIntervalMax >= currMin) {
            if (currMax > currIntervalMax) {
                currIntervalMax = currMax
            }
        } else {
            result.add(intArrayOf(currIntervalMin, currIntervalMax))
            currIntervalMin = currMin
            currIntervalMax = currMax
        }
    }

    return result.toTypedArray()
}

fun main() {
//    val intervals = arrayOf(intArrayOf(1,3),intArrayOf(2,6), intArrayOf(8,10),intArrayOf(15,18)) // [1,6],[8,10],[15,18]
//    val intervals = arrayOf(intArrayOf(1,4),intArrayOf(0,4)) // [0, 4]
//    val intervals = arrayOf(intArrayOf(1,4),intArrayOf(0,1)) // [0, 4]
//    val intervals = arrayOf(intArrayOf(1,4), intArrayOf(5, 8), intArrayOf(0,1)) // [0, 4], [5, 8]
//    val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3)) // [1, 4]
    val intervals = arrayOf(intArrayOf(1, 4), intArrayOf(0, 0)) // [0, 0], [1, 4]
    val output = mergeIntervals(intervals)
    for (i in output) {
        for (j in i) {
            println(j)
        }
    }
}