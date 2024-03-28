package yandex.school

fun main() {
    val marks = readln().split(' ')
        .map { it.toLong() }
        .toMutableList()
    marks.sort()
    println(marks[1])
}