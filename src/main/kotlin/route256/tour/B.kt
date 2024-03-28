object B {
    fun solving(n: Int, m: Int, field: List<List<Int>>, j: Int, J: List<Int>): List<List<Int>> {
        var answer = field

        var prevIndex = -1
        for (i in 0 until j) {
            if (prevIndex != J[i])
                answer = click(n, m, answer, J[i])

            prevIndex = J[i]
        }

        return answer
    }

    private fun click(n: Int, m: Int, field: List<List<Int>>, clickedIndex: Int): List<List<Int>> {
        val afterClick = mutableListOf<List<Int>>()

        var A = mutableListOf<Pair<Int, Int>>()

        for (i in 0 until n) {
            A.add(i to field[i][clickedIndex])
        }

        A.sortBy { it.second }

        for (i in 0 until n) {
            afterClick.add(field[A[i].first])
        }

        return afterClick
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        readLine()
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }

        val field = mutableListOf<List<Int>>()
        for (j in 0 until n) {
            val list = readLine()!!.split(' ').map { it.toInt() }
            field.add(list)
        }

        val j = readLine()!!.toInt()
        val J = readLine()!!.split(' ').map { it.toInt() - 1 }.toList()

        val answer = B.solving(n, m, field, j, J)

        for (k in answer) {
            println(k.joinToString(separator = " "))
        }
        println()
    }
}