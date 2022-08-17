object Game {
    fun twoDimension(rows: Int, columns: Int, field: MutableList<String>): List<String> {
        // gravity for blocks
        val fieldAfterGravity = mutableListOf<CharArray>()
        for (i in 0 until  columns) {
            val gravityLine = CharArray(rows) { '.' }
            var stones = 0
            for (j in 0 until rows)
                if (field[j][i] == '*') {
                    gravityLine[stones] = '*'
                    stones++
                }
            fieldAfterGravity.add(gravityLine)
        }

        // pouring water
        for (i in 1 until columns - 1) {
            for (j in 0 until rows) {
                val topBlock = fieldAfterGravity[i - 1][j]
                if (topBlock == '.')
                    break

                val block = fieldAfterGravity[i][j]
                if (block != '.')
                    continue

                val bottomBlock = fieldAfterGravity[i + 1][j]

                if (bottomBlock == '*')
                    fieldAfterGravity[i][j] = '~'
                else {
                    // check down to bottom if this water is finally be saved
                    for (k in i + 2 until columns)
                        if (fieldAfterGravity[k][j] == '*') {
                            fieldAfterGravity[i][j] = '~'
                            break
                        }
                }
            }
        }
        return toListOfStrings(rows, columns, fieldAfterGravity)
    }

    private fun toListOfStrings(rows: Int, columns: Int, field: List<CharArray>): List<String> {
        val answer = mutableListOf<String>()

        for (i in rows - 1 downTo 0) {
            var str = ""
            for (j in 0 until columns) {
                str += field[j][i]
            }
            answer.add(str)
        }

        return answer
    }

    // speed - O(2*m*n), memory -
    fun twoDimensionOpt(rows: Int, columns: Int, field: MutableList<CharArray>): List<CharArray> {
        // activate gravity
        if (rows > 1)
            for (i in 0 until columns) {
                var indexOnTopOfStone = rows - 1
                for (j in 0 until rows) {
                    if (j < indexOnTopOfStone) {
                        if (field[j][i] == '*')
                            for (k in indexOnTopOfStone downTo j) {
                                if (field[k][i] == '.') {
                                    field[j][i] = '.'
                                    field[k][i] = '*'
                                    indexOnTopOfStone--
                                    break
                                } else
                                    indexOnTopOfStone--
                            }
                    } else
                        break
                }
            }

        // check if walls on start and end, so just pourish water everywhere

        // pouring water
        for (i in 1 until columns - 1) {
            for (j in 0 until rows) {
                val leftBlock = field[j][i - 1]
                if (leftBlock == '.')
                    continue

                val block = field[j][i]
                if (block != '.')
                    continue

                val rightBlock = field[j][i + 1]
                if (rightBlock == '*')
                    field[j][i] = '~'
                else {
                    for (k in i + 2 until columns)
                        if (field[j][k] == '*') {
                            for (m in i until k) {
                                field[j][m] = '~'
                            }
                            break
                        }
                }
            }
        }
        return field
    }
}

fun main() {
    val tests = readLine()!!.toInt()
//    for (i in 0 until tests) {
//        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
//        val field = mutableListOf<String>()
//        for (j in 0 until n) {
//            field.add(readLine()!!)
//        }
//        val answer = Game.twoDimension(n, m, field)
//        for (line in answer) println(line)
//        println()
//    }

    // 2nd round, after get true answer, round of optimizations
    for (i in 0 until tests) {
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        val field = mutableListOf<CharArray>()
        for (j in 0 until n) {
            field.add(readLine()!!.toCharArray())
        }
        val answer = Game.twoDimensionOpt(n, m, field)
        for (line in answer) println(String(line))
        println()
    }
}
