package leetcode.random

/* You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
fun containerWithMostWater(height: IntArray): Int {
        val eachStepContainer = mutableListOf<Int>()
        var currContainerSize = height.size - 1
        var leftPointer = 0
        var rightPointer = currContainerSize

        var isSearch = true
        while (isSearch) {
            val left = height[leftPointer]
            val right = height[rightPointer]

            val currContainer = minOf(left, right) * currContainerSize
            eachStepContainer.add(currContainer)

            if (left <= right) {
                leftPointer += 1
                currContainerSize -= 1

                if (leftPointer == rightPointer) isSearch = false
            } else {
                rightPointer -= 1
                currContainerSize -= 1

                if (rightPointer == leftPointer) isSearch = false
            }
        }

        return eachStepContainer.max()
}

fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7) // https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg
    println(containerWithMostWater(height))
}