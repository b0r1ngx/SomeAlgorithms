package leetcode.random.graph

/* You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */

// other path so solve this task:
// if some nodes are not connected to center (so that is not star graph): use map
fun findCenter(edges: Array<IntArray>): Int {
    val (a, b) = edges[0]
    val (c, d) = edges[1]
    if (a == c) return a
    if (a == d) return a
    if (b == c) return b
    if (b == d) return d
    return 0 //
}
fun main() {
    val edges = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(4,2)) // 2
    println(findCenter(edges))
}
