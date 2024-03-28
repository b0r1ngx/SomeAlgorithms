package codewars

import java.util.*

fun loopSize(n: Node<Int>?): Int {

    val helper = HashMap<Int, Node<Int>?>()
    var next: Node<Int>? = n?.next ?: return 1

    var temp = 0
    while (!helper.containsValue(next)) {
        helper[temp++] = next
        next = next?.next
    }

    var size = 0
    for (i in temp - 1 downTo  0) {
        if (helper[i] == next) break
        else size++
    }
    return size
}

class Node<E> internal constructor(var prev: Node<E>?, var item: E, var next: Node<E>?)


