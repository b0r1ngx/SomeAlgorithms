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

    val rowSize = grid[0].size
    val columnSize = grid.size
    val gridCells = grid.size * grid[0].size

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            val value = grid[i][j]

            if (value > 0) {
                if (i == 0) surfaceArea += 1
                if (j == 0) surfaceArea += 1

                surfaceArea += 2

                val rightestCell = grid[i].getOrNull(j + 1) ?: 0
                val bottomCell = grid.getOrNull(i + 1)?.get(j) ?: 0

                surfaceArea += abs(value - rightestCell)
                surfaceArea += abs(value - bottomCell)
            }
        }
    }

    return surfaceArea
}

fun main() {
    val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)) // 34
    // todo: need to find more 3 edges
    println(surfaceArea(grid))
}