package leetcode.a

/* Task:
    Given an integer array nums, return an array answer such that answer[i] is equal to the product
    of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Constraints:
        1) 2 <= nums.length <= 10^5
        2) -30 <= nums[i] <= 30
        3) The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    Follow up: Can you solve the problem in O(1) extra space complexity?
    (The output array does not count as extra space for space complexity analysis.)
 */
class Solution {
    /* Examples:
    Input: nums = [1, 2, 3, 4]
    Output: [24, 12, 8, 6]

    Input: nums = [-1, 1, 0, -3, 3]
    Output: [0, 0, 9, 0, 0]
    */

    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { 0 }
//        val products =
        var product = 1

        for (i in 1 .. nums.size - 2) {
            product *= nums[i - 1]
            answer[i] = product

            product *= nums[i]



//            nums[i] *= nums[i + 1]
        }

//        val a = nums.forEach { it * nums.sum() }
//        println(nums.toList())
        println(product)
        println(answer.toList())
        return intArrayOf()
    }
}

fun main() {
    val my = intArrayOf(3, 4, 6)
    val nums = intArrayOf(1, 2, 3, 4)
    val nums_2 = intArrayOf(-1, 1, 0, -3, 3)
    Solution().productExceptSelf(my)
}