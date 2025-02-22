package leetcode.datalayer

class ListNode(var `val`: Int) {
    var prev: ListNode? = null
    var next: ListNode? = null

    fun appendNode(node: ListNode) {
        var lastNode: ListNode = this
        while (lastNode.next != null) {
            lastNode = lastNode.next!!
        }
        lastNode.next = node
    }

    override fun toString(): String {
        var output = ""
        var node: ListNode? = this
        while (node != null) {
            output += "${node.`val`}->"
            node = node.next
        }
        return output
    }
}