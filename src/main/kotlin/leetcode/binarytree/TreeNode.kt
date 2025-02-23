package leetcode.binarytree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TreeNode) return false
        return `val` == other.`val` && left == other.left && right == other.right
    }

    override fun hashCode(): Int {
        var result = `val`.hashCode()
        result = 31 * result + left.hashCode() + right.hashCode()
        return result
    }
}
