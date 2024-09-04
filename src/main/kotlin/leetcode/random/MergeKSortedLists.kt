package leetcode.random

/* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }

        val result = mutableListOf<Int>()
        var currMin = 10_000 // max constraint by task, can be replaced by Int.MAX_VALUE
        for (list in lists) {
            val firstListValue = list?.`val` ?: continue
            if (firstListValue <= currMin) {
                currMin = firstListValue
            }
        }

        val isNotSorted = true
        var nextMin = currMin
        while (isNotSorted) {
            lists.forEach {

            }
        }
        lists.forEach {

        }

        return ListNode(0)
//        return result.forEach {  }
    }
}

fun main() {
//    val lists = Array<ListNode?>{
//
//    }[[1,4,5],[1,3,4],[2,6]] // [1,1,2,3,4,4,5,6]
//    MergeKSortedLists().mergeKLists()
}