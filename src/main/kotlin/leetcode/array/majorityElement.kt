package leetcode.array

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
// Memory: O(n)
fun majorityElement(nums: IntArray): Int {
    val valueCounter = mutableMapOf<Int, Int>()

    nums.forEach { num ->
        val count = valueCounter[num] ?: 0
        valueCounter[num] = count + 1
    }

    var (`val`, count) = 0 to 0
    valueCounter.forEach { (value, counter) ->
        if (counter > count) {
            `val` = value
            count = counter
        }
    }
    return `val`
}

// Memory: O(1)
// doesn't work if majority element equals to n / 2
fun majorityElementMooreVotingAlgorithm(nums: IntArray): Int {
    var count = 0
    var candidate = Int.MIN_VALUE
    nums.forEach { num ->
        if (count == 0) candidate = num
        if (num == candidate) count++
        else count--
    }
    return candidate
}

fun main() {
    var nums = intArrayOf(3, 2, 3)
    var expected = 3
    var actual = majorityElement(nums)
    println(actual == expected)

    nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)
    expected = 2
    actual = majorityElementMooreVotingAlgorithm(nums)
    println(actual == expected)

    nums = intArrayOf(2, 2, 1, 1, 2, 1, 0, 0, 2, 0, 0, 2, 2, 2, 2)
    expected = 2
    actual = majorityElementMooreVotingAlgorithm(nums)
    println(actual == expected)
}
