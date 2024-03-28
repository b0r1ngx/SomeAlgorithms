object A {
    fun solving(n: Int, N: List<Int>): Int {
        var price = 0

        // number and how much is it
        val a = mutableMapOf<Int, Int>()

        for (i in N) {
            if (a[i] != null)
                a[i] = a[i]!! + 1
            else
                a[i] = 1
        }

        for ((k, v) in a) {
            if (v > 2) {
                // 3 -> 2, 7-> 5, 9 -> 6
                val formula = v / 3
                price += k * (v - formula )
            } else {
                price += k * v
            }
        }

        return price
    }
}

fun main() {
    val tests = readLine()!!.toInt()
    for (i in 0 until tests) {
        val n = readLine()!!.toInt()
        val N = readLine()!!.split(' ').map { it.toInt() }.toList()
        println(A.solving(n, N))
    }
}