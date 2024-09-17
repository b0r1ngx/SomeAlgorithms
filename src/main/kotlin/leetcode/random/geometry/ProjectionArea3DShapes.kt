package leetcode.random.geometry

/* You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).
 * We view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * Return the total area of all three projections.
 */

fun projectionArea(grid: Array<IntArray>): Int {
    var projectionArea = 0
    val maxValuesAtBottom = MutableList(grid.size) { 0 }

    for (i in grid.indices) {
        var maxInRow = 0
        for (j in grid[0].indices) {
            val value = grid[i][j]

            // adding for under (xy)
            if (value != 0) projectionArea += 1

            // adding for right side (yz)
            if (value > maxInRow) maxInRow = value
            if (j == grid[0].size - 1) projectionArea += maxInRow

            // calculating for bottom side (zx)
            if (value > maxValuesAtBottom[j]) maxValuesAtBottom[j] = value
        }
    }

    // adding for bottom side (zx)
    projectionArea += maxValuesAtBottom.sum()

    return projectionArea
}

fun main() {
    val grid = arrayOf(intArrayOf(1, 0), intArrayOf(0, 2)) // 8
    println(projectionArea(grid))
}