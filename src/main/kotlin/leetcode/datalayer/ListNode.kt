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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ListNode) return false

        var currentThis: ListNode? = this
        var currentOther: ListNode? = other
        while (currentThis != null && currentOther != null) {
            if (currentThis.`val` != currentOther.`val`) return false
            currentThis = currentThis.next
            currentOther = currentOther.next
        }

        // If one ListNode is longer than other, they're not equal
        return currentThis == null && currentOther == null
    }

    override fun hashCode(): Int {
        var result = `val`
        var current = next
        while (current != null) {
            result = 31 * result + current.`val`
            current = current.next
        }
        return result
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

fun List<Int>.toListNode(): ListNode {
    if (isEmpty()) throw IllegalArgumentException("List must not be empty")

    val head = ListNode(get(0))
    var currentNode = head
    for (i in 1 until size) {
        val nextNode = ListNode(get(i))
        currentNode.next = nextNode
        nextNode.prev = currentNode
        currentNode = nextNode
    }
    return head
}
