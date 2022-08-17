package codewars

import codewars.DirReduction.dirReduc

object DirReduction {
    fun dirReduc(arr: Array<String>): Array<String> {
        val directions = hashMapOf<String, Int>()
        val result = mutableListOf<String>()

        directions["NORTH"] = 0
        directions["SOUTH"] = 0
        directions["WEST"] = 0
        directions["EAST"] =  0

        for (dir in arr) {
            when (dir) {
                "NORTH" -> directions[dir] = directions[dir]!!.plus(1)
                "SOUTH" -> directions[dir] = directions[dir]!!.plus(1)
                "WEST" -> directions[dir] = directions[dir]!!.plus(1)
                "EAST" -> directions[dir] = directions[dir]!!.plus(1)
            }
        }

        // HashMap ["NORTH" to 4, "SOUTH" to 2, "WEST" to 2, "EAST" to 1]
        val NORTH = directions["NORTH"] ?: 0
        val SOUTH = directions["SOUTH"] ?: 0
        val WEST = directions["WEST"] ?: 0
        val EAST = directions["EAST"] ?: 0

        if (NORTH == SOUTH) {
            directions.remove("NORTH")
            directions.remove("SOUTH")
        } else if (NORTH > SOUTH) {
            directions["NORTH"] = NORTH - SOUTH
            directions.remove("SOUTH")
        } else if (SOUTH > NORTH) {
            directions["SOUTH"] = SOUTH - NORTH
            directions.remove("NORTH")
        }

        if (WEST == EAST) {
            directions.remove("WEST")
            directions.remove("EAST")
        } else if (WEST > EAST) {
            directions["WEST"] = WEST - EAST
            directions.remove("EAST")
        } else if (EAST > WEST) {
            directions["EAST"] = EAST - WEST
            directions.remove("WEST")
        }

        for ((k, v) in directions) {
            result.add(k)
        }
        return result.toTypedArray()
    }

    fun dirReduc(arr: Array<String>, a: Boolean = true): List<String> {
        val directions = mapOf(
            "NORTH" to "SOUTH",
            "SOUTH" to "NORTH",
            "WEST" to "EAST",
            "EAST" to "WEST")

        val result = mutableListOf<String>()

//        arr.forEach { if (directions[it] == result?.last() ?: result.add(it)) result.removeLast() else result.add(it)}

        for (dir in arr) {
            try {
                if (directions[dir] == result.last()) result.removeLast()
                else result.add(dir)
            } catch (e: Exception) { result.add(dir) }
        }

        return result
    }

}

fun main() {
    var a = arrayOf("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST")
    print(dirReduc(a, true))
}