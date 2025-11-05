package leetcode.top150interview

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing
// a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
fun bestTimeToBuyAndSellStock(prices: IntArray): Int {
    var maxProfit = 0
    var max = 0

    for (i in prices.size - 1 downTo 0) {
        val price = prices[i]

        if (price > max)
            max = price

        val possibleNewMaxProfit = max - price
        if (possibleNewMaxProfit > maxProfit)
            maxProfit = possibleNewMaxProfit
    }

    return maxProfit
}

fun main() {
    var input = intArrayOf(7, 1, 5, 3, 6, 4)
    var expected = 5
    var actual = bestTimeToBuyAndSellStock(input)
    println(expected == actual)

    input = intArrayOf(7, 6, 4, 3, 1)
    expected = 0
    actual = bestTimeToBuyAndSellStock(input)
    println(expected == actual)
}
