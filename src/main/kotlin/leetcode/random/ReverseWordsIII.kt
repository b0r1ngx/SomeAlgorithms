package leetcode.random

/* Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 */
fun reverseWords(s: String): String {
    val words = s.split(" ")
    var result = ""

    words.forEach { word ->
        for (i in word.length - 1 downTo 0) {
            result += word[i]
        }
        result += " "
    }

    return result.dropLast(n = 1)
}

fun main() {
    val s = "Let's take LeetCode contest" // "s'teL ekat edoCteeL tsetnoc"
    println(reverseWords(s))
}