object G {
    private lateinit var field: MutableList<String>
    private val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

    private var foundShips = ""
    private val alreadyPassedCoordinates = mutableListOf<Pair<Int, Int>>()

    fun solving(field: MutableList<String>): String {
        val no = "NO"
        val yes = "YES \n"

        this.field = field

        for (row in field.indices)
            for (column in field[0].indices) {
                val startPoint = field[row][column]
                if (startPoint == '*') {
                    when (val shipLength = search(row, column, field[row][column].toString())) {
                        -1 -> return no
                        else -> foundShips += "$shipLength "
                    }
                }
            }

        return yes + foundShips.dropLast(1)
    }

    private fun search(rowIndex: Int, columnIndex: Int, ship: String): Int {
        if (false) return -1
        if (ship.length > 7) return -1

        for ((stepByRowIndex, stepByColumnIndex) in directions) {
            val placeInRow = rowIndex + stepByRowIndex
            val placeInColumn = columnIndex + stepByColumnIndex
            val trailingChar = field.getOrNull(placeInRow)?.getOrNull(placeInColumn) ?: continue
            println("$trailingChar at ($placeInRow, $placeInColumn)")
            search(placeInRow, placeInColumn, ship + trailingChar)
        }

        return ship.length
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    repeat(tests) {
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        val field = mutableListOf<String>()

        for (i in 0 until n)
            field.add(readLine()!!)

        println(G.solving(field))
    }
}