object XsOs {
    fun verify(field: MutableList<CharArray>): String {
        val size = 3
        var howMuchXs = 0
        var howMuchOs = 0

        var isXsWin = false
        var isOsWin = false


        // horizontal check
        for (row in 0 until size) {
            var sequence = ""

            for (column in 0 until size) {
                val dot = field[row][column]

                if (dot == 'X')
                    howMuchXs++
                else if (dot == '0')
                    howMuchOs++

                sequence += dot
            }
            if (sequence == "XXX")
                isXsWin = true
            else if (sequence == "000")
                isOsWin = true
        }

        if (howMuchOs > howMuchXs)
            return "NO"

        else if (howMuchXs - howMuchOs >= 2)
            return "NO"

        else if (isXsWin && howMuchOs == howMuchXs)
            return "NO"

        else if (isOsWin && howMuchXs > howMuchOs)
            return "NO"

        isXsWin = false
        isOsWin = false

        // vertical check
        for (row in 0 until size) {
            var sequence = ""

            for (column in 0 until size) {
                val dot = field[column][row]
                sequence += dot
            }

            if (sequence == "XXX")
                isXsWin = true
            else if (sequence == "000")
                isOsWin = true
        }

        if (isXsWin && howMuchOs == howMuchXs)
            return "NO"

        else if (isOsWin && howMuchXs > howMuchOs)
            return "NO"

        // diagonals check
        isXsWin = false
        isOsWin = false

        var sequence = ""

        for (i in 0 until size) {
            val dot = field[i][i]

            sequence += dot
        }

        if (sequence == "XXX")
            isXsWin = true
        else if (sequence == "000")
            isOsWin = true


        if (isXsWin && howMuchOs == howMuchXs)
            return "NO"

        else if (isOsWin && howMuchXs > howMuchOs)
            return "NO"

        isXsWin = false
        isOsWin = false

        sequence = "${field[0][2]}${field[1][1]}${field[2][0]}"

        if (sequence == "XXX")
            isXsWin = true
        else if (sequence == "000")
            isOsWin = true

        if (isXsWin && howMuchOs == howMuchXs)
            return "NO"

        else if (isOsWin && howMuchXs > howMuchOs)
            return "NO"

        return "YES"
    }
}

fun main() {
    val variants = readLine()!!.toInt()
    for (i in 0 until variants) {
        readLine()
        val field = mutableListOf<CharArray>()
        for (j in 0 until 3) {
            field.add(readLine()!!.toCharArray())
        }
        println(XsOs.verify(field))
    }
}