package leetcode.array

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
 * such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums
 * should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
fun removeMoreThanTwiceDuplicatesFromSortedArray(nums: IntArray): Int {
    var twiceUniqueElements = 0
    var lastValue = Int.MIN_VALUE
    var lastValueCounter = 1

    nums.forEachIndexed { index, value ->
        if (value == lastValue) {
            if (lastValueCounter < 2) {
                nums[twiceUniqueElements++] = value
                lastValueCounter++
            }
        } else {
            nums[twiceUniqueElements++] = value
            lastValue = value
            lastValueCounter = 1
        }
    }

    return twiceUniqueElements
}

fun removeMoreThanNDuplicatesFromSortedArray(nums: IntArray, n: Int): Int {
    var uniqueElements = 0
    var lastValue = Int.MIN_VALUE
    var lastValueCounter = 1

    nums.forEachIndexed { index, value ->
        if (value == lastValue) {
            if (lastValueCounter < n) {
                nums[uniqueElements++] = value
                lastValueCounter++
            }
        } else {
            nums[uniqueElements++] = value
            lastValue = value
            lastValueCounter = 1
        }
    }

    return uniqueElements
}

fun main() {
    var nums = intArrayOf(1, 1, 1, 2, 2, 3)
    var expected = 5
    var actual = removeMoreThanTwiceDuplicatesFromSortedArray(nums)
    println(actual == expected)

    nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    expected = 7
    actual = removeMoreThanTwiceDuplicatesFromSortedArray(nums)
    println(actual == expected)

    nums = intArrayOf(1, 1, 1, 1, 2, 2, 3)
    expected = 5
    actual = removeMoreThanNDuplicatesFromSortedArray(nums, n = 2)
    println(actual == expected)
}
