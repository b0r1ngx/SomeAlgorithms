package rmartin.part1

// Abstraction over `find element in collection`


infix fun String.sE(v: String) = this == v


fun main() {
    val msg = "t"
    println(msg sE)
}


