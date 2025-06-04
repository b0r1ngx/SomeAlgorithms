package leetcode.array

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

// Time: O(m + n)
// Memory O(m) -- thinks, possible can be increased to O(1)
fun mergeSortedArray(
    nums1: IntArray, m: Int,
    nums2: IntArray, n: Int
) {
    if (nums2.isEmpty()) return
    if (m == 0) {
        nums2.forEachIndexed { index, value ->
            nums1[index] = value
        }
        return
    }

    val copyOfNums1 = nums1.copyOf()

    var firstArrayPointer = 0
    var secondArrayPointer = 0
    var indexToInsert = 0

    var doJob = true
    while (doJob) {
        val firstArrayValue = copyOfNums1[firstArrayPointer]
        val secondArrayValue = nums2[secondArrayPointer]

        if (firstArrayValue > secondArrayValue) {
            nums1[indexToInsert++] = secondArrayValue
            secondArrayPointer++
        } else {
            nums1[indexToInsert++] = firstArrayValue
            firstArrayPointer++
        }

        if (firstArrayPointer == m) {
            for (i in secondArrayPointer until n) {
                nums1[indexToInsert++] = nums2[i]
            }
            doJob = false
        } else if (secondArrayPointer == n) {
            for (i in firstArrayPointer until m) {
                nums1[indexToInsert++] = copyOfNums1[i]

            }
            doJob = false
        }
    }
}

fun main() {
    var firstNumbers = intArrayOf(1, 2, 3, 0, 0, 0)
    var secondNumbers = intArrayOf(2, 5, 6)

    var expected = intArrayOf(1, 2, 2, 3, 5, 6)
    mergeSortedArray(firstNumbers, 3, secondNumbers, 3)
    println(firstNumbers.contentEquals(expected))

    firstNumbers = intArrayOf(0)
    secondNumbers = intArrayOf(1)
    expected = intArrayOf(1)
    mergeSortedArray(firstNumbers, 0, secondNumbers, 1)
    println(firstNumbers.contentEquals(expected))
}
