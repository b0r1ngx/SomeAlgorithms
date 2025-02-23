package leetcode.binarytree

// You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree
// were swapped by mistake. Recover the tree without changing its structure.
fun recoverBST(root: TreeNode?): TreeNode? {
    var tmpRoot: TreeNode? = root ?: return null

    val stack = mutableListOf<TreeNode>()
    var pre: TreeNode? = null

    var firstError = TreeNode(0)
    var secondError = TreeNode(0)

    while (tmpRoot != null || stack.isNotEmpty()) {
        while (tmpRoot != null) {
            stack.add(tmpRoot)
            tmpRoot = tmpRoot.left
        }
        tmpRoot = stack.removeLast()
        if (pre != null && tmpRoot.`val` < pre.`val`) {
            if (firstError.`val` == 0)
                firstError = pre
            secondError = tmpRoot
        }
        pre = tmpRoot
        tmpRoot = tmpRoot.right
    }

    firstError.`val` = secondError.`val`.also {
        secondError.`val` = firstError.`val`
    }
    return root
}

fun main() {
    recoverBST(TreeNode(1))
    // Input: root = [1,3,null,null,2]
    // Output: [3,1,null,null,2]

    // Input: root = [3,1,4,null,null,2]
    // Output: [2,1,4,null,null,3]
}
