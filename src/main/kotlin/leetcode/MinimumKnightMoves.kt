package leetcode

data class Tile(val x: Int, val y: Int)

interface Figure {
    fun Tile.availableMoves(): List<Tile>
}

class Knight : Figure {
    fun minimumMoves(from: Tile, to: Tile): Int {
        // check how it works if here is List, Map, etc...
        val allAvailableTilesToVisit = mutableSetOf(from)

        var moves = 0
        val nextMoves = mutableListOf<Tile>()
        while (!allAvailableTilesToVisit.contains(to)) {
            allAvailableTilesToVisit.forEach {
                nextMoves.addAll(it.availableMoves())
            }
            moves += 1
            allAvailableTilesToVisit.addAll(nextMoves)
            nextMoves.clear()
            println(allAvailableTilesToVisit)
        }

        // TODO: val fromToPath: List<Tile>
        return moves
    }

    override fun Tile.availableMoves(): List<Tile> {
        return listOf(
            copy(x = x + 1, y = y + 2),
            copy(x = x + 2, y = y + 1),
            copy(x = x + 2, y = y - 1),
            copy(x = x + 1, y = y - 2),
//        -- MIRRORED IN DIFF OF SIGN --
            copy(x = x - 1, y = y - 2),
            copy(x = x - 2, y = y - 1),
            copy(x = x - 2, y = y + 1),
            copy(x = x - 1, y = y + 2),
        )
    }
}

fun main() {
    val from = Tile(0, 0)
    val tos = listOf(
        Tile(0, 0),
        Tile(1, 2),
        Tile(1, 1),
        Tile(2, 2)
    )

    for (to in tos) {
        val moves = Knight().minimumMoves(from, to)
        println(moves)
    }
}