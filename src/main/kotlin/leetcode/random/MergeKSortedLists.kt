package leetcode.random

import leetcode.datalayer.ListNode

/* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    for (list in lists) println(list)
    if (lists.isEmpty()) return null

    var isNotSorted = true
    var result: ListNode? = null
    while (isNotSorted) {
        var currMinValue = Int.MAX_VALUE
        var currMinValueIndex = 0

        for (index in lists.indices) {
            val node = lists[index]
            val value = node?.`val` ?: continue
            if (value < currMinValue) {
                currMinValue = value
                currMinValueIndex = index
            }
        }

        if (currMinValue == Int.MAX_VALUE) break

        if (result == null) result = ListNode(currMinValue)
        else result.appendNode(ListNode(currMinValue))

        lists[currMinValueIndex] = lists[currMinValueIndex]?.next
    }

    return result
}

fun main() {
    val l1 = ListNode(1)
    val nextl1 = ListNode(4)
    nextl1.next = ListNode(5)
    l1.next = nextl1

    val l2 = ListNode(1)
    val nextl2 = ListNode(3)
    nextl2.next = ListNode(4)
    l2.next = nextl2

    val l3 = ListNode(2)
    l3.next = ListNode(6)
    val lists: Array<ListNode?> = arrayOf(l1, l2, l3) // [1,1,2,3,4,4,5,6]

    var output = mergeKLists(lists)
    println(output)
}