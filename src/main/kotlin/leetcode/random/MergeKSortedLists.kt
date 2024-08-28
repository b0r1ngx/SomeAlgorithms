package leetcode.random

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }

        val result = mutableListOf<Int>()
        var currMin = 10_000
        lists.forEach {
            if (it?.`val` != null) {
                if (it.`val` <= currMin) {
                    currMin = it.`val`
                }
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
//    }[[1,4,5],[1,3,4],[2,6]]
//    MergeKSortedLists().mergeKLists()
}