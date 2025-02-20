package codewars

// Count the number of Duplicates
// Write a function that will return the count of distinct case-insensitive alphabetic characters
// and numeric digits that occur more than once in the input string.
// The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
fun duplicateCount(text: String): Int {
    val duplicates = mutableMapOf<String, Int>()
    text.forEach { char ->
        val char = char.lowercase()
        val finalCurrentValue =
            if (duplicates.get(char) != null)
                duplicates[char]!! + 1
            else 1
        duplicates[char] = finalCurrentValue
    }

    var countDuplicates = 0
    duplicates.values.forEach {
        if (it != 1) countDuplicates += 1
    }

    return countDuplicates
}

fun main() {
    println(0 == duplicateCount("abcde"))
    println(1 == duplicateCount("abcdea"))
    println(1 == duplicateCount("indivisibility"))

    val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
    println(3 == duplicateCount(text))
}
