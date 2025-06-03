package leetcode.random.linkedlists

import leetcode.datalayer.ListNode
import leetcode.datalayer.toListNode

// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Time: O(n)
// Memory: O(n)
fun reverseListNode(head: ListNode?): ListNode? {
    if (head == null) return null

    val nodeElements = mutableListOf<Int>()

    var currentNode: ListNode = head
    nodeElements.add(currentNode.`val`)

    while (currentNode.next != null) {
        currentNode = currentNode.next!!
        nodeElements.add(currentNode.`val`)
    }

    nodeElements.reverse()
    return nodeElements.toListNode()
}

// Memory: O(1)
fun reverseListNode2(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head
    while (curr != null) {
        val temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp
    }
    return prev
}

fun main() {
    val input = listOf(1, 2, 3, 4, 5).toListNode()
    val expected = listOf(5, 4, 3, 2, 1).toListNode()
    val actual1 = reverseListNode(input)
    val actual2 = reverseListNode2(input)
    println(actual1 == expected)
    println(actual2 == expected)
}
