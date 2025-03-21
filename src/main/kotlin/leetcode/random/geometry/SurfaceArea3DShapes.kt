package leetcode.random.geometry

import kotlin.math.abs

/* You are given an n x n grid where you have placed some 1 x 1 x 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).
 * After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
 * Return the total surface area of the resulting shapes.
 * Note: The bottom face of each shape counts toward its surface area.
 */
fun surfaceArea(grid: Array<IntArray>): Int {
    var surfaceArea = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            val value = grid[i][j]

            // if cell is on side
            if (i == 0) surfaceArea += value
            if (j == 0) surfaceArea += value

            // adding for bottom and upper surface of cell
            if (value != 0) surfaceArea += 2

            // while we iterate: scans right and bottom cells
            val rightCell = grid[i].getOrNull(j + 1) ?: 0
            val bottomCell = grid.getOrNull(i + 1)?.get(j) ?: 0

            surfaceArea += abs(value - rightCell)
            surfaceArea += abs(value - bottomCell)
        }
    }

    return surfaceArea
}

fun main() {
    val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)) // 34
//    val grid = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)) // 32
//    val grid = arrayOf(intArrayOf(2, 2, 2), intArrayOf(2, 1, 2), intArrayOf(2, 2, 2)) // 46
    // todo: need to find more 3 edges
    println(surfaceArea(grid))
}