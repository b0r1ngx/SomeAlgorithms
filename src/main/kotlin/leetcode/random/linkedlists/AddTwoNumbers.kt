package leetcode.random.linkedlists

import leetcode.random.ListNode

/* There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1
 * edges that connect the center node with every other node.
 * You are given a 2D integer array edges where each edges[i] = [ui, vi]
 * indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1node = l1
    var l2node = l2

    var firstNumber = 0
    var secondNumber = 0

    var currFirstDigit: Int
    var currSecondDigit: Int
    var currentDigit = 1

    var isBothNumbersNotEnd = true
    while (isBothNumbersNotEnd) {
        currFirstDigit = l1node?.`val` ?: 0
        currSecondDigit = l2node?.`val` ?: 0

        firstNumber += currFirstDigit * currentDigit
        secondNumber += currSecondDigit * currentDigit

        l1node = l1node?.next
        l2node = l2node?.next

        if (l1node == null && l2node == null) {
            isBothNumbersNotEnd = false
        }

        currentDigit *= 10
    }

    val preResult = (firstNumber + secondNumber).toDigits()
    println(preResult)
    val preResultSize = preResult.size - 1

    val result = ListNode(preResult[preResultSize])
    var nextRes = result
    for (i in preResultSize - 1 downTo 0) {
        val value = preResult[i]
        val node = ListNode(value)
        nextRes.next = node
        nextRes = node
    }

    return result
}

fun Int.toDigits() = toString().map { it.toString().toInt() }

fun main() {
//    val l1 = ListNode(2)
//    val nextl1 = ListNode(4)
//    nextl1.next = ListNode(3)
//    l1.next = nextl1
//
//    val l2 = ListNode(5)
//    val nextl2 = ListNode(6)
//    nextl2.next = ListNode(4)
//    l2.next = nextl2
//    println(addTwoNumbers(l1 = l1, l2 = l2)?.next?.`val`)


    val l1 = ListNode(9)

    val L2head = ListNode(1)
    val nodeValues = listOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)
    var nextL2 = L2head
    for (i in 1 until nodeValues.size - 1) {
        val value = nodeValues[i]
        val node =  ListNode(value)
        nextL2.next = node
        nextL2 = node
    }

    // Output: [8,0,4,5,6,0,0,1,4,1]
    // Expected: [0,0,0,0,0,0,0,0,0,0,1]
    val result = addTwoNumbers(l1 = l1, l2 = L2head)

}