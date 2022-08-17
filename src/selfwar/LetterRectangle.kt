const val rectangleRaw = """
    KOTE
    NULE
    AFIN
"""

const val dictionaryRaw = "Kotlin, fun, file, line, null, full, lenifun"

val directions = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)

fun main() {
    val rectangle = rectangleRaw.trimIndent().split("\n")
    val dictionary = dictionaryRaw.uppercase().split(", ").toSet()
    val prefixes = dictionary.flatMap { word ->
        List(word.length + 1) { word.take(it) }
    }.toSet()

    println(prefixes)

    fun search(rowIndex: Int, columnIndex: Int, word: String) {
        if (word !in prefixes) return
        if (word in dictionary) println(word)
        // dictionary.any { it.equals(word, ignoreCase = true)}

        for ((stepByRowIndex, stepByColumnIndex) in directions) {
            val stepInRow = rowIndex + stepByRowIndex
            val stepInColumn = columnIndex + stepByColumnIndex
            val trailingLetter = rectangle.getOrNull(stepInRow)?.getOrNull(stepInColumn) ?: continue
            search(stepInRow, stepInColumn, word + trailingLetter)
        }
    }

    for (row in rectangle.indices)
        for (column in rectangle[0].indices)
            search(row, column, rectangle[row][column].toString())
}