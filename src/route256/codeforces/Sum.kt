object Sum {
    fun sum(a: Int, b: Int) = a + b
}

fun main() {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (a, b) = readLine()!!.split(' ')
        println(Sum.sum(a.toInt(), b.toInt()))
    }
}