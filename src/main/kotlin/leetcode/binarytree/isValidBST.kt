package leetcode.binarytree

// Validate Binary Search Tree
fun isValidBST(root: TreeNode?): Boolean {
    var root: TreeNode? = root ?: return true
    val stack = mutableListOf<TreeNode>()
    var pre: TreeNode? = null
    while (root != null || stack.isNotEmpty()) {
        while (root != null) {
            stack.add(root)
            root = root.left
        }
        root = stack.removeLast()
        if (pre != null && root.`val` <= pre.`val`) return false
        pre = root
        root = root.right
    }
    return true
}

fun main() {
    // Input: root = [2,1,3]
    // Output: true

    // Input: root = [5,1,4,null,null,3,6]
    // Output: false

    // Input: root = [2,2,2]
    // Output: false

    // Input: root = [5,4,6,null,null,3,7]
    // Output: false
}
