package leetcode.random.matrix

/* A matrix diagonal is a diagonal line of cells starting from some cell
 * in either the topmost row or leftmost column and going in the bottom-right direction
 * until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0],
 * where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 */
fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    if (mat.size <= 1) return mat

    val preparations = mutableMapOf<Int, MutableList<Int>>()

    for (i in mat.indices) {
        for (j in mat[i].indices) {
            if (i == 0 || j == 0) {
                if (i == 0) {
                    preparations[j] = mutableListOf(mat[i][j])
                } else {
//                    preparations.add
                }
            }


        }
    }

//    return preparations
    return arrayOf()
}

fun main() {

    val input = arrayOf(
        intArrayOf(11,25,66,1 ,69, 7),
        intArrayOf(23,55,17,45,15,52),
        intArrayOf(75,31,36,44,58, 8),
        intArrayOf(22,27,33,25,68, 4),
        intArrayOf(84,28,14,11, 5,50),
    ) // Output: [
    // [5 ,17,4 ,1 ,52, 7],
    // [11,11,25,45,8 ,69],
    // [14,23,25,44,58,15],
    // [22,27,31,36,50,66],
    // [84,28,75,33,55,68]]
    val sorted = diagonalSort(input)
    for (row in sorted) println(row)
}