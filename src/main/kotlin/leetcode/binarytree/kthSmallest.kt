package leetcode.binarytree

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var root: TreeNode? = root ?: return 0

    val stack = mutableListOf<TreeNode>()
    val sortedList = mutableListOf<Int>()

    while (root != null || stack.isNotEmpty()) {
        while (root != null) {
            stack.add(root)
            root = root.left
        }
        root = stack.removeLast()
        sortedList.add(root.`val`)
        if (sortedList.size == k) return sortedList[k-1]
        root = root.right
    }
    return 0
}

fun main() {
    // Input: root = [3,1,4,null,2]
    println(1 == kthSmallest(TreeNode(3), 1))

    // Input: root = [5,3,6,2,4,null,null,1]
    println(3 == kthSmallest(TreeNode(5), 3))
}
