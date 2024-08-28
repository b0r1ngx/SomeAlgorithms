package leetcode.random

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
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    println(containerWithMostWater(height))
}