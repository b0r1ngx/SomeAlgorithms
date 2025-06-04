package leetcode.array

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *  * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 *    The remaining elements of nums are not important as well as the size of nums.
 *  * Return k.
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var leftElements = 0
    nums.forEachIndexed { index, value ->
        if (value != `val`) {
            nums[leftElements++] = value
        }
    }
    return leftElements
}

fun main() {
    var nums = intArrayOf(3, 2, 2, 3)
    var expected = 2
    var actual = removeElement(nums, 3)
    println(actual == expected)

    nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    expected = 5
    actual = removeElement(nums, 2)
    println(actual == expected)
}
