package yandex

// Написать функцию, которая определяет, является ли переданная строка палиндромом
// (читается слева-направо и справа-налево одинаково) •
// Примеры палиндромов: см. main
// Ограничение по памяти 0(1).
fun palindrome(str: String): Boolean {
    var leftPointer = 0
    var rightPointer = str.length - 1

    while (leftPointer < rightPointer) {
        val leftChar = str[leftPointer].lowercaseChar()
        val rightChar = str[rightPointer].lowercaseChar()

        if (!isLetter(leftChar)) {
            leftPointer++
            continue
        }

        if (!isLetter(rightChar)) {
            rightPointer--
            continue
        }

        if (leftChar != rightChar) return false
        leftPointer++
        rightPointer--
    }

    return true
}

fun isLetter(char: Char): Boolean {
    return char.titlecaseChar() != char.lowercaseChar()
}

fun main() {
    println(palindrome("Казак"))
    println(palindrome("А роза упала на лапу Азора|"))
    println(palindrome("Do geese see God?"))
    println(palindrome("Madam, I'm Adam"))
}
