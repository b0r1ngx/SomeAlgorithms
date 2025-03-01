package mooc

import kotlin.math.max
import kotlin.math.min

// You are given the price of a stock for n days.
// Your task is figure out the highest profit you could have made
// if you had bought the stock on one day and sold it on another day.
fun stockTrading(prices: List<Int>): Int {
    if (prices.size < 2) return 0

    var bestProfit = 0
    var minPrice = prices[0]
    for (i in prices.indices) {
        val currentValue = prices[i]
        minPrice = min(currentValue, minPrice)
        bestProfit = max(currentValue - minPrice, bestProfit)
    }

    return bestProfit
}

fun main() {
    println(4 == stockTrading(listOf(100, 1, 5)))
    println(99 == stockTrading(listOf(1, 100, 1, 5)))
    println(5 == stockTrading(listOf(3, 7, 5, 1, 4, 6, 2, 3)))
    println(998 == stockTrading(listOf(2, 100, 5, 1000, 1, 5)))
    println(999 == stockTrading(listOf(2, 100, 1, 1000, 1, 5)))
    println(990 == stockTrading(listOf(10, 1000, 2, 100, 1, 5)))
    println(998 == stockTrading(listOf(10, 1000, 2, 100, 1, 5, 999)))
}
