package rmartin.part1

// Abstraction over `find element in collection`
infix fun String.contains(other: String) = other in this
infix fun String.contains(other: Char) = other in this


fun main() {
    val msg = "text"
    println(msg.contains("te"))
    println(msg.contains("x"))
}


