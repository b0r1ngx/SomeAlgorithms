package mipt.dp

import kotlin.math.max

/* For tasks in dynamic programming, we must discuss and set as initial data 5 points:
 * 1. What is saved in dp?
 * (For the possibility to solve problem in dynamic programming way, problem must have a chance to be divided)
 * (information of big and difficult problem is analogically must be presented as much but a smaller problem)
 * 2. Base of dp
 * 3. Formula of re-count
 * 4. Order of re-count
 * 5. Where is the answer?
 */

/*
 * Grasshopper problem
 *  Objective: max(sum() of numbers on that steps, where is grasshopper was being)
 *
 *  Example:
 *                   5
 *                   __
 *              -20 |
 *               __
 *  ----->  -10 |
 *  |       __
 *  --> -5 |
 *  |   __
 * start
 *
 * from start point, grasshopper can jump to -5 or -10, and so on..
 *
 * 1. Let dp[i], 1, 2, .. i - is the max sum that we can get, if stairs is restricted by first i-steps
 * 2. dp[0] = 0, dp[1] = a[1]
 * 3. dp[i] = ai + max (dp[i - 1], dp[i - 2])
 * 4. i = 1, 2 ... n (in ascending order)
 * 5. dp[n]
 */
object Grasshopper {
    // Asymptotic: speed - O(n), memory - O(1)
    fun letHoppin(dp: List<Int>): Int {
        if (dp.size <= 2)
            return max(dp[0], dp[1])

        var first: Int
        var second: Int
        var now = 0

        for (i in dp.size - 1 downTo   2) {
            first = dp[i - 1]
            second = dp[i - 2]
            now += dp[i] + max(first, second)
        }
        return now
    }
}

fun main() {
    val test1 = listOf(-5, -10, -20, 10)
    val answer1 = 0

    val test2 = listOf(-20 , -10, -5, 5)
    val answer2 = -5

    println(Grasshopper.letHoppin(test1))
}