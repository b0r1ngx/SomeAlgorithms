package codewars

import codewars.IsMyFriendCheating.incrementString

object IsMyFriendCheating {
    var ny: Long = 0L
    fun removeNumbers(n: Long): Array<Array<Long>> {
        ny =  n
        val sum = sum(n)
        val a = mutableListOf<Array<Long>>()

        for (i in 2 until n) {
            val it = detect(i, sum)
            if (it != null) a.add(it)
        }

        return a.toTypedArray()
    }

    private fun sum(n: Long): Long = n * (n + 1) / 2

    private fun detect(i: Long, sum: Long): Array<Long>? {
        val j = (sum - i) / (i + 1)
        if (j < ny)
            if (((sum - i) % (i + 1)) == 0L)
                return arrayOf(i, j)

        return null
    }

    private fun sum(n: Long, except: Pair<Long, Long> = Pair(0L, 0L)): Long {
        var sum = 0L
        for (i in 0..n) sum += i

        if (except.first != 0L)
            sum -= (except.first + except.second)

        return sum
    }

    fun incrementString(str: String) : String {
        if (str == "") return "1"
        if (!str.last().isDigit()) return str + "1"
        if (str.last() == '0') return str.dropLast(1) + (str.last().digitToInt() + 1)

        var result = ""
        var number = ""

        if (stringIsInteger(str)) {
            for (char in str) {
                if (char == '0') result += char
                else break
            }
            return if (isGetBigger(number)) result.dropLast(1) + (number.toInt() + 1).toString()
            else result + (number.toInt() + 1).toString()
        }

        for (i in str.indices) {
            if (!str[i].isDigit()) result += str[i]
            else if (str[i] == '0') result += str[i]
            else {
                number += str.substring(i)
                break
            }
        }

        return if (result.last() == '0' && isGetBigger(number)) result.dropLast(1) + (number.toInt() + 1).toString()
        else result + (number.toInt() + 1).toString()
    }

    private fun stringIsInteger(str: String): Boolean = try { str.toInt(); true } catch (e: Exception) { false }

    private fun isGetBigger(number: String): Boolean = number.length != (number.toInt() + 1).toString().length

    fun incrementString(str: String, bestPractice: Boolean): String {
        val i = str.takeLastWhile { it.isDigit() }
        return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
    }
}

fun main() {
//    print(removeNumbers(26)[0])
    println(incrementString("foobar000"))
    println(incrementString("foobar001"))
    println(incrementString("foobar0001"))
    println(incrementString("foobar000999"))
    println(incrementString("fooba999"))
    println(incrementString("1"))
    println(incrementString(""))
    println(incrementString("09"))
    println(incrementString("gOnvNwdscKt604468"))
    println(incrementString("COEDI650768"))
//    print(incrementString(""))

}
