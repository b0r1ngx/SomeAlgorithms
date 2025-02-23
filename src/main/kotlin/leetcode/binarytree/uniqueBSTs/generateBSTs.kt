package leetcode.binarytree.uniqueBSTs

import leetcode.binarytree.TreeNode

fun generateBSTs(n: Int): List<TreeNode?> {
    val bsts = mutableMapOf<Pair<Int, Int>, List<TreeNode?>>()
    return possibleBSTs(1, n, bsts)
}

fun possibleBSTs(from: Int, to: Int, bsts: MutableMap<Pair<Int, Int>, List<TreeNode?>>): List<TreeNode?> {
    val result = mutableListOf<TreeNode?>()
    if (from > to) {
        result.add(null)
        return result
    }

    val entry = bsts.get(from to to)
    if (entry != null) return entry

    for (i in from .. to) {
        val leftSubTrees = possibleBSTs(from, i - 1, bsts)
        val rightSubTrees = possibleBSTs(i + 1, to, bsts)

        for (left in leftSubTrees)
            for (right in rightSubTrees)
                result.add(TreeNode(i, left, right))
    }
    bsts[from to to] = result
    return result
}

fun main() {
    val expectedForTwoN = listOf(
        TreeNode(1, null, TreeNode(2)),
        TreeNode(2, TreeNode(1), null)
    )
    val actualForTwoN = generateBSTs(3)
    for (expected in expectedForTwoN) {
        if (expected !in actualForTwoN) println("expected $expected, but actual entries is $actualForTwoN")
    }
    println(true)
    println(listOf(TreeNode(1)) == generateBSTs(1))
}
