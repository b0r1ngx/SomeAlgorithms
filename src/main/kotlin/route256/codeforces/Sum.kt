object Sum {
    fun sum(a: Int, b: Int) = a + b
}

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val (a, b) = readln().split(' ')
        println(Sum.sum(a.toInt(), b.toInt()))
    }
}