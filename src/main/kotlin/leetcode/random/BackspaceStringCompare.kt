package leetcode.random

/* Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 */
fun backspaceCompare(s: String, t: String): Boolean {
    var sResult = ""
    var tResult = ""
    val backspace = '#'

    val totalLength = s.length + t.length - 2

    for (i in 0 .. totalLength) {
        val sChar = s.getOrNull(i)
        val tChar = t.getOrNull(i)

        if (sChar != null) {
            if (sChar == backspace)
                sResult = sResult.dropLast(n = 1)
            else sResult += sChar
        }

        if (tChar != null) {
            if (tChar == backspace)
                tResult = tResult.dropLast(n = 1)
            else tResult += tChar
        }
    }

    return sResult == tResult
}

fun main() {
    val s = "ab#c"
    val t = "ad#c" // true, Explanation: Both s and t become "ac".

    val s1 = "ab##"
    val t1 = "c#d#" // true, Explanation: Both s and t become "".

    val s2 = "a#c"
    val t2 = "b" // false, Explanation: s becomes "c" while t becomes "b".

    println(backspaceCompare(s, t))
}