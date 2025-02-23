package leetcode.binarytree

import java.math.BigInteger

// Unique Binary Search Trees
// Given an integer n, return the number of structurally unique binary search trees
// which has exactly n nodes of unique values from 1 to n.

// Solve: Catalan number
fun numBSTs(n: Int): Int {
    val numerator = factorial(2 * n)
    val denominator = factorial(n + 1).multiply(factorial(n))
    return numerator.divide(denominator).toInt()
}

fun factorial(n: Int): BigInteger {
    if (n == 1) return BigInteger.ONE
    return factorial(n - 1).multiply(BigInteger.valueOf(n.toLong()))
}

fun main() {
    println(58786 == numBSTs(11))
    println(429 == numBSTs(7))
    println(5 == numBSTs(3))
    println(1 == numBSTs(1))
}