import java.util.*

object D {
    fun solving(n: Int, book: List<Pair<String, String>>): SortedMap<String, MutableList<String>> {
        val bookMap = sortedMapOf<String, MutableList<String>>()

        second@ for (i in n - 1 downTo  0) {
            if (bookMap[book[i].first] != null) {
                if (bookMap[book[i].first]!!.size == 5)
                    continue

                for (k in bookMap[book[i].first]!!)
                    if (k == book[i].second)
                        continue@second

                bookMap[book[i].first]!!.add(book[i].second)
            } else
                bookMap[book[i].first] = mutableListOf(book[i].second)
        }

        return bookMap
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        val n = readLine()!!.toInt()

        val book = mutableListOf<Pair<String, String>>()

        for (j in 0 until n) {
            val (name, phone) = readLine()!!.split(' ')
            book.add(name to phone)
        }

        val bookMap = D.solving(n, book)

        for ((k, v) in bookMap)
            println("$k: ${v.size} ${v.joinToString(separator = " ")}")

        println()
    }
}